package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jikwon")
public class Jikwon {
	
	@Id
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	private String jikwonibsail;
	private String jikwongen;
	private String jikwonrating;
	//private int busernum; JOIN이 될 주체이기 때문에 따로 작성하지 않는다.
	
	@ManyToOne //연관관계의 주체는 Many다.(ownership, Jikwon Enitity가 주인) => 그렇기 때문에 주체가 되는 Entity에 @ManyToOne를 작성한다.
	@JoinColumn(name="busernum") //Buser의 buserno(PK)와 관계를 맺는 FK(외래키)
	// FK의 대상은 PK만 있기 때문에 대상을 따로 작성하지 않아도 된다. => 자동으로 해당 테이블의 PK를 대상으로 지정
	private Buser buser; //Jikwon Entity의 멤버 => Buser Entity를 참조
}
