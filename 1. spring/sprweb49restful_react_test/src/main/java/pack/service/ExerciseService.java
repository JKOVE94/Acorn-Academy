package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.controller.ExerciseForm;
import pack.dto.ExerciseDto;
import pack.repository.ExerciseRepository;

@Service
public class ExerciseService implements ExerciseInter{

	@Autowired
	private ExerciseRepository repository;
	
	//운동 전체 리스트 가져오기
	@Override
	public List<ExerciseDto> getAllList(){
		return repository.findAll().stream()
				.map(ExerciseDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//수정을 위한 1개 조회
	@Override
	public ExerciseDto getOne(long num) {
		return ExerciseDto.fromEntity(repository.findById(num).get());
	}
	
	@Override
	public void insertAndUpdate(ExerciseForm form) {
		repository.save(ExerciseForm.toEntity(form));
	}
	
	@Override
	public void delete(long num) {
		repository.deleteById(num);
	}
}
