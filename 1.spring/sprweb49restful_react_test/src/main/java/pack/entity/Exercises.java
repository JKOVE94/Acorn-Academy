package pack.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Exercises {

	@Id
	private long exid;
	private String exname;
	private LocalDate exstarttime;
	private LocalDate exendtime;
	private int excalorieburn;
	private long formulaid;
	
	@ManyToOne
	@JoinColumn(name = "userno")
	private User user;
	
	@OneToOne
	@JoinColumn(name="formulaid")
	private Calorieformula calorieformula;
	
}
