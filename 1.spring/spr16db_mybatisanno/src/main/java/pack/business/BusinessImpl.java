package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private SangpumInter inter;
	
	@Override
	public void dataPrint() {
		List<SangpumDto> list = inter.selectDataAll();
		int count =0;
		for(SangpumDto s: list) {
			System.out.println(s.getCode() + " " + s.getSang() + " "+ s.getSu() + " " + s.getDan());
			count+=1;
		}
		System.out.println("건수 : "+count);
	}
}