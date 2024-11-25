package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.ExercisesDto;
import pack.entity.Exercises;
import pack.form.ExercisesForm;
import pack.repository.ExerciseRepository;

@Service
public class ExerciseService implements ExerciseInter{

	@Autowired
	private ExerciseRepository repository;
	
	//운동 전체 리스트 가져오기
	@Override
	public List<ExercisesDto> getAllList(){
		return repository.findAll().stream()
				.map(ExercisesDto :: fromEntity)
				.collect(Collectors.toList());
	}
	//자동 번호 생성을 위한 메소드
	@Override
	public long getMaxno() {
		return repository.getMaxNum()+1;
	}
	
	//수정을 위한 1개 조회
	@Override
	public ExercisesDto getOne(long num) {
		return ExercisesDto.fromEntity(repository.findById(num).get());
	}
	
	//유저가 한 운동정보 입력
	@Override
	public void insert(ExercisesForm form) {
		form.setExid(getMaxno());
		repository.save(ExercisesForm.toEntity(form));
	}
	
	@Override
	public void update(long id, ExercisesForm form) {
		Exercises e = repository.findById(id).get();
		e.setFormulaid(form.getFormulaid());
		e.setExname(form.getExname());
		e.setExstarttime(form.getExstarttime());
		e.setExendtime(form.getExstarttime());
		e.setExcalorieburn(form.getExcalorieburn());
		
	}
	
	@Override
	public void delete(long num) {
		repository.deleteById(num);
	}
}
