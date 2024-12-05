package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Dept;
import pack.entity.Emp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeptDto {
	private int deptno;
	private String dname;
	private String loc;

	private int count; //근무 인원수
	private List<String> names; //근무 직원 이름
	
	
	public static Dept toEntity(DeptDto dto) {
		return Dept.builder()
				.deptno(dto.deptno)
				.dname(dto.dname)
				.loc(dto.loc)
				.build();
	}
	
	public static DeptDto fromEntity(Dept dept) {
		
		//Entity -> DTO의 과정 가운데 계산을 추가할 수 있다.
		List<String> names = new ArrayList<String>(); 
		for(Emp imsi:dept.getEmplist()) {
			names.add(imsi.getEname());
		}
		
		
		return DeptDto.builder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getEmplist().size())
				.names(names)
				.build();
	}
}
