package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jikwon")
public class Jikwon {
	
	@Id
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	
	@OneToMany(mappedBy = "jikwon", fetch = FetchType.LAZY)
	private List<Gogek> gogekList;
	
}
