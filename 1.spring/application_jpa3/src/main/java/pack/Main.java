package pack;

import java.util.List;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Main {

	public static void main(String[] args) {
		// JPA : CRUD test
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		// 전체 자료 읽기
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder(); //기준 빌더 : 를 통해 표준 쿼리를 꺼낼 수 있음
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			//조회의 시작점을 의미하는 Root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);
			
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
			
			for(SangpumTable st : resultList) {
				System.out.println();
				System.out.println("상품코드 : "+st.getCode());
				System.out.println("상품명 : "+st.getSang());
				System.out.println("수량 : "+st.getSu());
				System.out.println("단가 : "+st.getDan());
			}
			System.out.println("JPQL을 사용해 전체 자료 읽기");
			//entity Class명을 작성하는것
//			TypedQuery<SangpumTable> queryql = em.createQuery("Select m from SangpumTable AS m", SangpumTable.class);
//			List<SangpumTable> resultList2 = queryql.getResultList();
			
			List<SangpumTable> resultList2 = em.createQuery("Select m from SangpumTable AS m", SangpumTable.class).getResultList();
			for(SangpumTable st : resultList2) {
				System.out.println();
				System.out.println("상품코드 : "+st.getCode());
				System.out.println("상품명 : "+st.getSang());
				System.out.println("수량 : "+st.getSu());
				System.out.println("단가 : "+st.getDan());
			}
			System.out.println("JPQL 사용해 부분 자료 읽기1 - 1개");
			
			int findId= 1; //String도 가능
			
			SangpumTable sangt = em.find(SangpumTable.class, findId);
			
			if(sangt==null) {
				System.out.println("자료 없음");
			}
			else {
				System.out.println();
				System.out.println("상품코드 : "+sangt.getCode());
				System.out.println("상품명 : "+sangt.getSang());
				System.out.println("수량 : "+sangt.getSu());
				System.out.println("단가 : "+sangt.getDan());
			}
			
			System.out.println("JPQL 사용해 부분 자료 읽기2 - 여러개");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(query.where(cb.equal(root.get("sang"), "가죽장갑")));
			List<SangpumTable> resultList3 =  typedQuery.getResultList();
			for(SangpumTable st : resultList3) {
				System.out.println();
				System.out.println("상품코드 : "+st.getCode());
				System.out.println("상품명 : "+st.getSang());
				System.out.println("수량 : "+st.getSu());
				System.out.println("단가 : "+st.getDan());
			}
		}
			catch (Exception e) {
				System.out.println("전체 자료 읽기 오류"+e);
			}
	}
}
			
			//자료 추가
//			try {
//				transaction.begin();
//				SangpumTable table = new SangpumTable(5,"연필",11,1000);
//				em.persist(table); // 바로 저장되는 것이 아니라, 영속성 컨텍스트를 통해 엔티티를 영속화함.
//				transaction.commit();
//			}
//			catch(Exception e) {
//				System.out.println("추가 실패 :"+e);
//				transaction.rollback();
//				return;
//			}
			//자료 수정
//			try {
//				transaction.begin();
//				SangpumTable utable = em.find(SangpumTable.class, "5");
//				
//				if(utable==null) {
//					System.out.println("수정 대상 자료 없음");
//				}
//				else {
//					String newName = "지우개";
//					utable.setSang(newName); //이름 갱신
//				} 
//				
//				transaction.commit();
//			}
//			catch(Exception e) {
//				System.out.println("수정 실패 :"+e);
//				transaction.rollback();
//				return;
//			}
//		} 
//		
		
		
//			자료 삭제
//try {
//	transaction.begin();
//	int delId=5;
//	SangpumTable dtable = em.find(SangpumTable.class, delId);
//	transaction.commit();
//	
//	if(dtable==null) {
//		System.out.println("삭제 대상 자료 없음");
//	}
//	else {
//		em.remove(dtable);
//	} 
//	
//	transaction.commit();
//}
//catch(Exception e) {
//	System.out.println("삭제 실패 :"+e);
//	transaction.rollback();
//	return;
//}
//} 
//
//catch (Exception e) {
//System.out.println("전체 자료 읽기 오류"+e);
//}try {
//	transaction.begin();
//	int delId=5;
//	SangpumTable dtable = em.find(SangpumTable.class, delId);
//	transaction.commit();
//	
//	if(dtable==null) {
//		System.out.println("삭제 대상 자료 없음");
//	}
//	else {
//		em.remove(dtable);
//	} 
//	
//	transaction.commit();
//}
//catch(Exception e) {
//	System.out.println("삭제 실패 :"+e);
//	transaction.rollback();
//	return;
//}
//} 
//
//catch (Exception e) {
//System.out.println("전체 자료 읽기 오류"+e);
//}
