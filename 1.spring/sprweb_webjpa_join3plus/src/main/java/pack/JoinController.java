package pack;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5500")
public class JoinController {
	
    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/joindata")
    public List<BuserJikwonGogekDTO> getJoinData() {
        return joinService.getJoinedData();
    }
    
    @GetMapping("/busers")
    public List<Buser> getAllBusers() {
    	return joinService.getAllBusers();
    }
    
    @GetMapping("/jikwons")
    public List<JikwonDto> getAllJikwons() {
    	return joinService.getAllJikwons();
    }
    
    @GetMapping("/gogeks")
    public List<Gogek> getAllGogeks() {
    	return joinService.getAllGogeks();
    }
    
   
}