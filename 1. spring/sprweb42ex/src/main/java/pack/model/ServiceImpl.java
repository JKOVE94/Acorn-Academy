package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pack.controller.SajinForm;
import pack.controller.SangForm;
import pack.dto.SangDto;
import pack.entity.Sajindata;
import pack.entity.Sangdata;
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
		return sangdataRepository.findAll().stream()
				.map(SangDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public SangDto getSang(int code) {
		return SangDto.fromEntity(sangdataRepository.findById(code).get());			
	}	
	
	@Override
	@Transactional
	public Sangdata uploadSang(SangForm form) {
		Sangdata savedSangdata = sangdataRepository.save(SangForm.toEntity(form));
		System.out.println("savedSangdata"+savedSangdata);
		return savedSangdata;
	}
	
	@Override
	@Transactional
	public void uploadPic(SangForm sangform, SajinForm form) {
		Sajindata data = new Sajindata();
		data.setAbout(form.getAbout());
		data.setFilepath(form.getFilepath());
		data.setSangdata(uploadSang(sangform));
		data.setUploadat(form.getUploadat());
		
		sajindataRepository.save(data);
	}
}
