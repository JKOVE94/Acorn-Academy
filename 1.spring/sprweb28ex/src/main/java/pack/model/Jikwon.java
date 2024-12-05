package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
	private int jikwonpay;
	
	@OneToMany(mappedBy = "jikwon", fetch = FetchType.LAZY)
	private List<Gogek> gogekList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busernum")
	private Buser buser;
	
}
