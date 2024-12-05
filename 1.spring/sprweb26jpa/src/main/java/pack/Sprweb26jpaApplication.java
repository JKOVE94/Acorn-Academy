package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@SpringBootApplication
public class Sprweb26jpaApplication {
	/*실습 순서
	 * 1. 어플리케이션 프로그래밍 : SQL 연습용 DB 저장, JPA 메소드 연습
	 * 2. @MVC로 회원(member)관리
	 * 3. @MVC로 직원(dept, emp)관리 - JOIN
	 * 4. JPQL연습용 화면 작성 - AJAX 맛보기
	 */ 
	
	// DB 자료 입력 후 jpa 메소드 보기
	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private EntityManagerFactory emf;
	
	@PostConstruct
	public void initDatas() {
		//dept, emp 샘플 데이터 저장
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =em.getTransaction();
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			queries.add("INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);");
			
			//반복을 통해 실행 쿼리를 얻어 직접 실행
			for(String query : queries) {
				em.createNativeQuery(query).executeUpdate();
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
		}
		
		// Emp 자료 읽기
		Emp e1 = empRepository.findById(7499).get();
		System.out.println(e1.getEname() + " 직원의 부서명은 " + e1.getDept().getDname());
		
		// Emp에 자료 추가 (8000 번, 직원명:Oliveia, 부서번호 : 40) 
		Dept dNum = deptRepository.findById(40).get();
		System.out.println(dNum.getDeptno()); // 40
		
		Dept d = Dept.builder().deptno(40).build();
		System.out.println(d.getDeptno());
		
		Emp e2 = Emp.builder().empno(8000).ename("Olivia").dept(d).build();
		empRepository.save(e2);
		
		//10번 부서 정보출력
		Dept dept10 = deptRepository.findById(10).get();
		System.out.println("부서명 : "+dept10.getDname());
		System.out.println("부서위치 : "+dept10.getLoc());
		System.out.println("근무인원수 : "+dept10.getEmplist().size());
		dept10.getEmplist().forEach(e->System.out.println("직원명 : "+e.getEname()));
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb26jpaApplication.class, args);
	}

}
