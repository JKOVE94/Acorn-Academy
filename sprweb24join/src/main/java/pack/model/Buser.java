package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "buser")
public class Buser {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
	//양방향 연관관계
	@OneToMany(mappedBy = "buser", fetch = FetchType.LAZY) //Jikwon Entity의 buser colum을 말한다. FetchType.LAZY (Default) mappedBy는 주인이 아닌 경우에 사용
	private List<Jikwon> jikwonList; //one의 기준으로 Many는 복수이기 때문에 Collection으로 받게 된다. (하나의 부서는 여러명의 직원과 연관될 수 있다.)
}
