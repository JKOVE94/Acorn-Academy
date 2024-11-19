package pack.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Buser {
	@Id
	private int buserno;
	private String busername;
	
	@OneToMany(mappedBy = "buser")
	private List<Jikwon> JikwonList;
	
}
