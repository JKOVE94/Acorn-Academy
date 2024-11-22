package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Exercise;

@Getter
@Setter
public class ExerciseForm {

	private long id;
	private String name;
	private int duration;
	private int calorieburn;
	
	public static Exercise toEntity(ExerciseForm form) {
		Exercise exercise = new Exercise();
		exercise.setId(form.getId());
		exercise.setName(form.getName());
		exercise.setDuration(form.getDuration());
		exercise.setCalorieburn(form.getCalorieburn());
		return exercise;
	}
}
