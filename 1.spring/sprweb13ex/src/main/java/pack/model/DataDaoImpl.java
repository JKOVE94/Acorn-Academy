package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDaoImpl implements DataDaoInter{

	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public List<JikwonDto> getAllJik() {
		List<JikwonDto> list = dataMapper.getAllJik();
		return list;
	}
	
	@Override
	public List<JikwonDto> getSearchJik(String jikwonname) {
		List<JikwonDto> list = dataMapper.getJikSearch(jikwonname);
		return list;
	}
}
