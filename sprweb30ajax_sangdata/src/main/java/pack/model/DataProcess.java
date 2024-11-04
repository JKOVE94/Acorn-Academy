package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangdataForm;

@Repository
public class DataProcess {
	
	@Autowired
	private SangdataRepository sangdataRepository;
	
	public int getMax() {
		return sangdataRepository.getMax()+1;
	}
	
	public List<SangdataDto> getAllSang(){
		List<Sangdata> list = sangdataRepository.findAll();
		return list.stream()
				.map(SangdataDto :: fromEntity)
				.collect(Collectors.toList());
	}
	public void addSang(SangdataForm form) {
		System.out.println(form.getSang());
		Sangdata sangdata = SangdataForm.toEntity(form);
		sangdata.builder().code(getMax()).build();
		sangdataRepository.save(sangdata);
	}
	

}
