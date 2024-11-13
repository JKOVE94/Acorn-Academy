package pack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.EmpDto;
import pack.entity.Emp;
import pack.repository.EmpRepository;
import pack.repository.MemberRepository;

@Controller
public class JpqlController {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	EntityManagerFactory emf;
	
	@GetMapping("/jpql")
	public String jpql() {
		return "jpql";
	}
	
	//ResponseBody를 사용하면 Class로 담긴 데이터가 Key Value 형식의 JSON으로 반환된다. (jackson 라이브러리 지원)
	@ResponseBody
	@PostMapping("/jpql/test") //ajax 요청
	public List<EmpDto> testSql(@RequestParam("query")String query) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<EmpDto> list = null; 
		
		tx.begin();
		try {
			//전달된 query 값을 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			list = tQuery.getResultStream()
					.map(EmpDto :: fromEntity)
					.collect(Collectors.toList());
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
		}
		return list;
	}
}
