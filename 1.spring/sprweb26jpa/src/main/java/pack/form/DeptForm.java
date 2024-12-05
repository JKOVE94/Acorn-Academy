package pack.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Dept;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeptForm {
	private int deptno;
	private String dname;
	private String loc;

	private int count; //근무 인원수
	private List<String> names; //근무 직원 이름
	
	
	public static Dept toEntity(DeptForm form) {
		return Dept.builder()
				.deptno(form.deptno)
				.dname(form.dname)
				.loc(form.loc)
				.build();
	}
}
