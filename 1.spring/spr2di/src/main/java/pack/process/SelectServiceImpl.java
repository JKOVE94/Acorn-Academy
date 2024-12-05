package pack.process;

import pack.model.DataDao;

public class SelectServiceImpl implements SelectService{
	private DataDao dataDao;
	
	public SelectServiceImpl(DataDao dataDao) {
		//생성자를 통해 dataDao에게 객체 주소를 치환
		System.out.println("SelectServiceImpl 생성자 수행");
		this.dataDao = dataDao; 
	}
	
	@Override
	public void selectProcess() {
		System.out.println("selectProcess 수행");
		dataDao.selectData();
	}
}
