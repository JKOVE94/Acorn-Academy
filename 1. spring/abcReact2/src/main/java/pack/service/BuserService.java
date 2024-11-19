package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.JikwonDto;
import pack.repository.JikwonRepository;

@Service
public class BuserService {

	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<JikwonDto> getJikwonWithBuserName(String busername){
		return jikwonRepository.getJikwonWithBusername(busername).stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
}
