package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BuserBean;

@Repository
public class DataProcess {

	@Autowired
	private BuserRepository repository;
	
	public List<BuserDto> getDataAll(){
		List<BuserEntity> list = repository.findAll();
		/*
		List<BuserDto> dtoList = new ArrayList<BuserDto>();
		list.forEach(data -> dtoList.add(new BuserDto().fromEntity(data)));
		return dtoList;
		*/
		
		//Strem을 사용했을 때
		//반환된 BuserDto를 리스트로 수집 후 최종적으로 리스트를 반환
		// collect : 스트림의 처리 결과를 다시 List 등의 컬렉션으로 변환하는 최종 연산
		return list.stream().map(BuserDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	public BuserDto getById(int buserno) {
		BuserEntity entity = repository.findById(buserno).get();
		BuserDto dto = new BuserDto().fromEntity(entity);
		return dto;
	}
	
	
	public String insert(BuserBean bean) {
		String msg;
		try {
			//번호 중복 확인
			BuserEntity existingData = repository.findById(bean.getBuserno()).orElse(null);
			
			// or Else : findById() 는 조회 결과가 있으면 Optional<BuserEntity> 객체를 반환, 없으면 null
			if(existingData != null) {
				msg = "부서 번호 중복";
				return msg;
			}
			else {
				repository.save(bean.toEntity(bean)); //FormBean에 담긴 데이터를 Entity로 변환 => Save는 부서를 대상으로 하기 때문
				msg ="success";				
			}
			
		} catch (Exception e) {
			System.out.println("insert err :"+e);
			msg="오류 발생 : "+e;
		}
		return msg;
	}
	
	public String delete(int buserno) {
		String msg;
		try {
			repository.deleteById(buserno);//FormBean에 담긴 데이터를 Entity로 변환 => Save는 부서를 대상으로 하기 때문
			msg ="success";				
			
		} catch (Exception e) {
			System.out.println("delete err :"+e);
			msg="오류 발생 : "+e;
		}
		return msg;	
	}
	
	public String update(BuserBean bean) {
		String msg;
		try {
			BuserEntity entity = repository.findById(bean.getBuserno()).get();
			entity.builder().buserloc(bean.getBuserloc()).busertel(bean.getBusertel()).buserno(bean.getBuserno()).busername(bean.getBusername()).build();
			msg ="success";				
			
		} catch (Exception e) {
			System.out.println("delete err :"+e);
			msg="오류 발생 : "+e;
		}
		return msg;	
	}
	
}
