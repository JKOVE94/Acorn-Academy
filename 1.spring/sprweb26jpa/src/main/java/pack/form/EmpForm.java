package pack.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Emp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpForm {
	private Integer empno; 
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	
	//부서 관련 정보
	private Integer deptno;
	private String dname;
	
	public static Emp toEntity(EmpForm form) {
		return Emp.builder()
				.empno(form.getEmpno())
				.ename(form.getEname())
				.job(form.getJob())
				.mgr(form.getMgr())
				.hiredate(form.getHiredate())
				.sal(form.getSal())
				.comm(form.getComm())
				.build();			
	}
	
}
