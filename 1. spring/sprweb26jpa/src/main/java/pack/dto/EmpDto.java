package pack.dto;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class EmpDto {
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
	
	public static Emp toEntity(EmpDto dto) {
		return Emp.builder()
				.empno(dto.getEmpno())
				.ename(dto.getEname())
				.job(dto.getJob())
				.mgr(dto.getMgr())
				.hiredate(dto.getHiredate())
				.sal(dto.getSal())
				.comm(dto.getComm())
				.build();			
	}
	
	public static EmpDto fromEntity(Emp emp) {
		return EmpDto.builder()
				.empno(emp.getEmpno())
				.ename(emp.getEname())
				.job(emp.getJob())
				.mgr(emp.getMgr())
				.hiredate(emp.getHiredate())
				.sal(emp.getSal())
				.comm(emp.getComm())
				.deptno(emp.getDept().getDeptno())
				.dname(emp.getDept().getDname())
				.build();			
	}
}
