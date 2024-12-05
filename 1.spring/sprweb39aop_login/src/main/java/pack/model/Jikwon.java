package pack.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private String jikwongen;
	private int jikwonpay;
	private LocalDate jikwonibsail;
	
	//양방향 참조가 아닌 단방향 참조일 때에 다른 Entity를 참조하는 코드를 쓸때에는 꼭 EAGER로 해야한다 (불러오는 시기에 다른 Entity가 로딩되어있지 않기 때문)
	@ManyToOne(targetEntity = Buser.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "busernum")
	private Buser buser;
}
