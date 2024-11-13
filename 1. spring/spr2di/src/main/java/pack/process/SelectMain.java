package pack.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public class SelectMain {

	public static void main(String[] args) {
		//전통적인 방법
		DataDaoImpl daoImpl = new DataDaoImpl();
		DataDao dataDao = daoImpl;
		
		SelectServiceImpl selectServiceImpl = new SelectServiceImpl(dataDao);
		SelectService selectService = selectServiceImpl;
		selectService.selectProcess();
		
		System.out.println("-----");
		
		//Spring 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		SelectService selectService2 = (SelectService) context.getBean("selectServiceImpl");
		selectService2.selectProcess();	
	}
}
