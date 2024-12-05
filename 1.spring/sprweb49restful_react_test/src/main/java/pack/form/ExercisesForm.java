package pack.form;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Exercises;

@Getter
@Setter
public class ExercisesForm {

	private long exid;
	private String exname;
	private LocalDate exstarttime;
	private LocalDate exendtime;
	private int excalorieburn;
	private long formulaid;
	
	public static Exercises toEntity(ExercisesForm form) {
		Exercises exercise = new Exercises();
		exercise.setExname(form.getExname());
		exercise.setExstarttime(form.getExstarttime());
		exercise.setExendtime(form.getExendtime());
		exercise.setExcalorieburn(form.getExcalorieburn());
		return exercise;
	}
}
