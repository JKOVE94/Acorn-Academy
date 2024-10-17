package pack.model;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pack.model")
public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		EntityManager em = emf.createEntityManager();
		try {
			// JPQL 작성 -> 이 쿼리는 DB 테이블에서 참고하는 것이 아닌 Entity에서 참고하는 쿼리이다.
			String jpql = "SELECT j.jikwonno, j.jikwonname, b.busername, j.jikwonibsail " +
						 "FROM Jikwon AS j JOIN j.buser b";
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();
			for(Object[] res : results) {
				int year = getYear((Date)res[3]);
				System.out.println(res[0] + " " + res[1] + " " + res[2] + " " + year);
			}
			
			System.out.println("---------Native SQL 사용 ----------"); 
			//JPA의 강점이 dialet인데 Native SQL을 사용하는것은 JPA의 강점을 제대로 살리지 못하는 행위 이기 때문에 비추천
			String sql = "SELECT j.jikwonno, j.jikwonname, b.busername, YEAR(j.jikwonibsail) " +
					 "FROM jikwon AS j JOIN buser AS b ON b.buserno = j.busernum";
			
			Query query2 = em.createNativeQuery(sql);
			List<Object[]> results2 = query2.getResultList();
			for(Object[] res : results2) {
				System.out.println(res[0] + " " + res[1] + " " + res[2] + " " + res[3]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		finally {
			em.close();
			emf.close();
		}
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
	}
	//Calendar Class를 활용해서 연도만 출력
	private static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR); //final Static => 만들어지는 순서때문에 일반 메소드를 사용하면 오류가 발생함
	}
}
