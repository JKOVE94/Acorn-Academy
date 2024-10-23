package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FormBean;

@Repository
public class DataDao {

	private Logger logger = LoggerFactory.getLogger(DataDao.class); //getClass()
	
	@Autowired
	private DataMapperInter dataInter; //자동으로 pooling 처리
	
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = dataInter.selectAll();
		logger.info("datas :"+ list.size());
		return list;
	}
	
	public List<SangpumDto> getDataSearch(FormBean bean){
		logger.info("bean :"+ bean.getSearchValue());
		List<SangpumDto> list = dataInter.selectSearch(bean);
		logger.info("datas :"+ list.size());
		return list;
	}
}
