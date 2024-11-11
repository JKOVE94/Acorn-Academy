package pack.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sangdata {

	@Id
	private int code;
	private String sang;
	private int su;
	private int dan;
	
	@OneToMany(mappedBy = "sangdata")
	private List<Sajindata> sajinList;
	
	
}
