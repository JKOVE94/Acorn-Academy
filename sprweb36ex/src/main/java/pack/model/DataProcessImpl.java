package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangForm;
import pack.entity.Sang;
import pack.repository.SangRepository;

@Repository
public class DataProcessImpl implements DataProcess{
	
	@Autowired
	private SangRepository repository;
	
	@Override
	public List<SangDto> getAllSang(){
		List<Sang> list = repository.findAll();
		return list.stream()
				.map(SangDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public SangDto getSang(int code) {
		Sang sang = repository.findById(code).get();
		return SangDto.fromEntity(sang);
	}
	
	
	@Override
	public int getMax() {
		return repository.getMax()+1;
	}
	
	@Override
	public void insert(SangForm form) {
		form.setCode(getMax());
		repository.save(SangForm.toEntity(form));
	}
	
	@Override
	public void update(SangForm form){
		repository.save(SangForm.toEntity(form));
	}
	
	@Override
	public void delete(int code){
		repository.deleteById(code);
	}

}
