package pack.service;

import java.util.List;
import pack.controller.ExerciseForm;
import pack.dto.ExerciseDto;

public interface ExerciseInter {

	List<ExerciseDto> getAllList();
	ExerciseDto getOne(long num);
	void insertAndUpdate(ExerciseForm form);
	void delete(long num);
}
