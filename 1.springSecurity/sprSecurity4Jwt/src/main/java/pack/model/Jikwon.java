package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jikwon {

	@Id
	private Long jikwonno;
	private String jikwonname;
	
	
}
