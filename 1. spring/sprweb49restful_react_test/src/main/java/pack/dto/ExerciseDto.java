package pack.dto;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Exercise;

@Getter
@Setter
public class ExerciseDto {

	private long id;
	private String name;
	private int duration;
	private int calorieburn;
	
	public static ExerciseDto fromEntity(Exercise exercise) {
		ExerciseDto dto = new ExerciseDto();
		dto.setId(exercise.getId());
		dto.setName(exercise.getName());
		dto.setDuration(exercise.getDuration());
		dto.setCalorieburn(exercise.getCalorieburn());
		return dto;
		
	}
}
