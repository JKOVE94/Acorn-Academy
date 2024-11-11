package pack.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SajinForm;
import pack.controller.SangForm;
import pack.dto.SajinDto;
import pack.dto.SangDto;
import pack.repository.SajindataRepository;
import pack.repository.SangdataRepository;

@Repository
public class ServiceImpl implements Service{


	@Autowired
	private SajindataRepository sajindataRepository;
	
	@Autowired
	private SangdataRepository sangdataRepository;
	
	@Override
	public List<SangDto> getSangpumlist(){
		System.out.println("사진 주소 :" + sangdataRepository.findById(8).get().getSajinList().get(0).getFilepath());
		return sangdataRepository.findAll().stream()
				.map(SangDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public SangDto getSang(int code) {
		return SangDto.fromEntity(sangdataRepository.findById(code).get());			
	}	
	
	@Override
	public void uploadSang(SangForm form) {
		sangdataRepository.save(SangForm.toEntity(form));
	}
	
	@Override
	public void uploadPic(SajinForm form) {
		sajindataRepository.save(SajinForm.toEntity(form));
	}
}
