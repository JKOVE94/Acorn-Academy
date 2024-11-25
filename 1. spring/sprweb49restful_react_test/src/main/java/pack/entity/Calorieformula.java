package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Calorieformula {

	@Id
	private long formulaid;
	private double formula;
	private String exname;
	@OneToOne(mappedBy = "calorieformula")
	private Exercises exercises;
	
}
