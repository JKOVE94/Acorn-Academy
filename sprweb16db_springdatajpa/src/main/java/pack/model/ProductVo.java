package pack.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class ProductVo {

	@Id
	@Column(name="code")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //default 값은 AUTO / 자동 설정이 있을때에만 작성
	private int code;
	
	@Column(name="sang", nullable= true, length = 20)
	private String sang;
	
	@Column(name="su")
	private int su; // not null
	
	@Column(name="dan")
	private int dan;
	
}
