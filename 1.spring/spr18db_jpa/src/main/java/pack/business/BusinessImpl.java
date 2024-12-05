package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemEntity;

@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataList() {
		List<MemEntity> list = dataInterface.selectDataAll();
		System.out.println("건수 : "+list.size());
	}

}
