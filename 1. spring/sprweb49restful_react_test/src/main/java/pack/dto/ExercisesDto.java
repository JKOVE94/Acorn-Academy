package pack.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Calorieformula;
import pack.entity.Exercises;

@Getter
@Setter
public class ExercisesDto {

	private long exid;
	private String exname;
	private LocalDate exstarttime;
	private LocalDate exendtime;
	private int excalorieburn;
	private double formula;
	
	public static ExercisesDto fromEntity(Exercises exercises) {
		ExercisesDto dto = new ExercisesDto();
		dto.setExid(exercises.getExid());
		dto.setExname(exercises.getExname());
		dto.setExstarttime(exercises.getExstarttime());
		dto.setExendtime(exercises.getExendtime());
		dto.setExcalorieburn(exercises.getExcalorieburn());
		dto.setFormula(exercises.getCalorieformula().getFormula());
		return dto;
	}
}
