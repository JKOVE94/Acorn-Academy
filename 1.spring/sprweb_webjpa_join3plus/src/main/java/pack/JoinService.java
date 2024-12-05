package pack;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class JoinService {
    private final BuserRepository buserRepository;
    private final GogekRepository gogekRepository;
    private final JikwonRepository jikwonRepository;

    public JoinService(BuserRepository buserRepository, JikwonRepository jikwonRepository, GogekRepository gogekRepository) {
        this.buserRepository = buserRepository;
        this.jikwonRepository = jikwonRepository;
        this.gogekRepository = gogekRepository;
    }

    public List<BuserJikwonGogekDTO> getJoinedData() {
        // DTO로 직접 데이터를 조회
        return buserRepository.findAllJoinedData();
    }
    
    public List<Buser> getAllBusers() {
        // DTO로 직접 데이터를 조회
        return buserRepository.findAll();
    }
    
    public List<JikwonDto> getAllJikwons() {
        // DTO로 직접 데이터를 조회
        return jikwonRepository.findAll().stream()
        		.map(jikwon -> new JikwonDto(
        				jikwon.getJikwonno(),
        				jikwon.getJikwonname(),
        				jikwon.getBuser().getBusername(),
        				jikwon.getJikwonjik(),
        				jikwon.getJikwonpay(),
        				jikwon.getJikwonibsail().toString(),
        				jikwon.getJikwongen(),
        				jikwon.getJikwonrating())
        				).collect(Collectors.toList());
    }
    
    public List<Gogek> getAllGogeks() {
        // DTO로 직접 데이터를 조회
        return gogekRepository.findAll();
    }
    
}
