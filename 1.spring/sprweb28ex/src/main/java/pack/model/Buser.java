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

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buser")
public class Buser {
	@Id
	private int buserno;
	private String busername;
	private String busertel;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.LAZY)
	private List<Jikwon> jikwonList;	
}
