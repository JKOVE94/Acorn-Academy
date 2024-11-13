package pack.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {
	
	@Override
	public List<MemEntity> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<MemEntity> list = null;
		try {
			//레코드 추가
			/*
			tx.begin();
			
			MemEntity member1 = new MemEntity(4, "고소해", "서초구 방배동");
			em.persist(member1);		
			
			tx.commit();
			*/
			
			//레코드 수정
			/*
			tx.begin();
			MemEntity member2 = em.find(MemEntity.class, 4);
			member2.setName("고소한");		
			tx.commit();
			*/
			
			//레코드 삭제
			/*
			tx.begin();
			MemEntity member3 = em.find(MemEntity.class, 4);
			em.remove(member3);
			tx.commit();
			*/
			
			
			
			System.out.println("부분 자료 읽기1 : pk 값으로 find 메소드 호출");
			MemEntity mentity = em.find(MemEntity.class, 1);
			System.out.println(mentity.getNum() + " " + 
						mentity.getName() + " " +
						mentity.getAddr());
			
			System.out.println("부분 자료 읽기2 : find... 메소드 작성 후 호출");
			List<MemEntity> listPart = null;
			listPart = findByAddrStartingWith(em, "강남");
			for(MemEntity m:listPart) {
				System.out.println(m.getNum() + " " + 
						m.getName() + " " +
						m.getAddr());
			}
			
			System.out.println("\n전체 자료 읽기 : findAll 작성 후 호출");
			list = findAll(em, MemEntity.class);
			for(MemEntity m:list) {
				System.out.println(m.getNum() + " " + 
						m.getName() + " " +
						m.getAddr());
			}
			
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public List<MemEntity> findByAddrStartingWith(EntityManager em, String prefix){
		// JPQL 쿼리 문자열 정의  addr 필드가 prefix로 시작하는 자료 읽기
		String jpql = "select m from MemEntity m where m.addr like :prefix";
		
		TypedQuery<MemEntity> query = em.createQuery(jpql, MemEntity.class);
		query.setParameter("prefix", prefix + "%");
		return query.getResultList();
	}
	
	public List findAll(EntityManager em, Class cla) {
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
	}
	

}