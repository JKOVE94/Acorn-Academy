package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangdataForm;
import pack.dto.SangpumDto;
import pack.entity.Sangdata;

@Repository
public class DataProcess {
	
	@Autowired
	private SangdataRepository sangdataRepository;
	
	
	
	public List<SangpumDto> getAllSang(){
		List<Sangdata> list = sangdataRepository.findAll();
		return list.stream()
				.map(SangpumDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	public int getMax() {
		return sangdataRepository.getMax()+1;
	}
	
	public List<SangpumDto> addSang(SangdataForm form) {
		form.setCode(getMax());
		System.out.println("Code : "+ form.getCode());
		Sangdata sangdata = SangdataForm.toEntity(form);
		sangdataRepository.save(sangdata);
		
		
		List<Sangdata> list = sangdataRepository.findAll();
		return list.stream()
				.map(SangpumDto :: fromEntity)
				.collect(Collectors.toList());
	}
}
