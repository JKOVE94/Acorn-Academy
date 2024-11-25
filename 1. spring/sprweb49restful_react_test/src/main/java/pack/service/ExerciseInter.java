package pack.service;

import java.util.List;

import pack.dto.ExercisesDto;
import pack.form.ExercisesForm;

public interface ExerciseInter {

	List<ExercisesDto> getAllList();
	ExercisesDto getOne(long num);
	void insert(ExercisesForm form);
	void update(long id, ExercisesForm form);
	void delete(long num);
	long getMaxno();
}
