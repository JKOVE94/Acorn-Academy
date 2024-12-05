package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Jikwon {

	@Id
	private int jikwonno;
	private String jikwonname, jikwonjik, jikwonibsail, jikwongen, jikwonrating;
	private int jikwonpay;
	
	
	@ManyToOne
	@JoinColumn(name = "busernum")
	private Buser buser;
	
}
