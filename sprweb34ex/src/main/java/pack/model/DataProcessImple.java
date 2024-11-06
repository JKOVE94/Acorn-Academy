package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.GogekDto;
import pack.dto.JikwonDto;
import pack.entity.Gogek;
import pack.entity.Jikwon;
import pack.repository.GogekRepository;
import pack.repository.JikwonRepository;

@Repository
public class DataProcessImple implements DataProcess{
	
	@Autowired
	private GogekRepository gogekRepository;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Override
	public JikwonDto getJikwon(String gogeknum, String gogekname) {
		if(jikwonRepository.getDamJik(gogeknum, gogekname)!=null) {
		Jikwon jikwon = jikwonRepository.getDamJik(gogeknum, gogekname);
		return JikwonDto.builder()
				.jikwonname(jikwon.getJikwonname())
				.busername(jikwon.getBuser().getBusername())
				.busertel(jikwon.getBuser().getBusertel())
				.jikwonjik(jikwon.getJikwonjik())
				.build();
		}
		else return null;
	}
	
	@Override
	public List<JikwonDto> getJikwonsWithBusername(String busername) {
		List<Jikwon> list = jikwonRepository.getJikWithBuser(busername);
		System.out.println(list.get(0).getJikwonname());
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<GogekDto> getGogeksWithJikwonno(String jikwonno){
		List<Gogek> list = jikwonRepository.getGogekWithJikwon(jikwonno);
		return list.stream()
				.map(GogekDto :: fromEntity)
				.collect(Collectors.toList());
	}

}
