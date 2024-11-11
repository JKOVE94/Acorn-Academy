package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DataImpl implements DataInterface {

	@Autowired
	private GogekRepository repository;
	
	@Override
	public List<GogekDto> selectDataAll() {
		return repository.findAll();
	}
}
