package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default // Builder.Default를 걸면 초기화를 한다.
	private List<Emp> Emplist = new ArrayList<Emp>();
}
