package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.JikwonDto;
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

}
