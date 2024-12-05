package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import pack.dto.MemberDto;
import pack.entity.Member;
import pack.form.MemberForm;
import pack.repository.MemberRepository;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Override
	public void getAllMember(Model model){
		List<MemberDto> list = repository.findAllByOrderByNumDesc().stream()
				.map(MemberDto :: fromEntity)
				.collect(Collectors.toList());
		model.addAttribute("list", list);
		//컨트롤러에 MemberDto가 담긴 List를 바로 전달 할 수 있음.
		// 모델객체는 스프링이 관리하므로 메소드가 호출된 후 값이 유지됨.
	}
	
	@Override
	public void getData(Long num, Model model) { //상세보기, 수정용
		Member mem = repository.findById(num).get();
		model.addAttribute("dto", MemberDto.fromEntity(mem));
	}
	@Override
	public Member getOne(Long num) { //상세보기, 수정용
		return repository.findById(num).get();
	}
	
	
	@Override
	@Transactional
	public void insert(MemberForm form) {
		//form.setNum(repository.getMax()+1); 이런식으로 Auto Increment를 대체할 수 있다. 그러나 현재는 걸려있기 때문에 필요 없음
		repository.save(MemberForm.toEntity(form));
	}
	
	@Override
	@Transactional
	public void update(MemberForm form) {
		repository.save(MemberForm.toEntity(form));
	}
	
	/*
	 * 동일성 검사 (실제로는 JPA가 동일성을 검사
	 * - m1 == m2는 두 객체가 동일한 인스턴스인지를 확인한다.
	 * - 동일한 트랜잭션 내에서 같은 엔티티를 두 번 조회하면 동일한 객체 인스턴스를 반환하는지 확인할 수 있다.
	 * - System.out.println("m1과 m2가 같냐?" + isEqual);는 이를 출력하여 실제로 동일한 객체인지를 확인한다.
	 */
	
	@Override
	@Transactional
	public void update2(MemberForm form) {
	   // 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = repository.findById(form.getNum()).get();
	    Member m2 = repository.findById(form.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1과 m2가 같냐?" + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기 : transaction 이 진행중인 상황에서 변경된 값이 있다면 save() 메소드를 할 필요가 없다.
	    // Entity의 값이 변화되기 때문에 JPA가 자동으로 해당 내용을 저장해준다.
//	    m1.builder().addr(form.getAddr()).name(form.getName()).build();
	    m1.setAddr(form.getAddr());
	    m1.setName(form.getName());
	}
	
	@Override
	@Transactional
	public void delete(Long num) {
		repository.deleteById(num);
	}
}
