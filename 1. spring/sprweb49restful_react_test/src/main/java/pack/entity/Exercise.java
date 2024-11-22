package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Exercise {

	@Id
	private long id;
	private String name;
	private int duration;
	private int calorieburn;
}
