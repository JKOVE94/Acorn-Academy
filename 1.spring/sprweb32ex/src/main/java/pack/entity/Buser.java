package pack.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Buser {

	@Id
	private int buserno;
	private String busername, buserloc, busertel;
	
	@OneToMany(mappedBy = "buser")
	private List<Jikwon> jikwonlist;
}
