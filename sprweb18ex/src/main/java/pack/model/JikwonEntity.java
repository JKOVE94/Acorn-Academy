package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "jikwon")
public class JikwonEntity {
	
	@Id
	private int jikwonno;
	private String jikwonname;
	private String jikwongen;
	private String jikwonjik;
	
}
