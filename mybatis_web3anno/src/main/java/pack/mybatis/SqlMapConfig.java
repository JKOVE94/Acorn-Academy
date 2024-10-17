package pack.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.buisness.SqlMapperInterface;

public class SqlMapConfig {
	public static SqlSessionFactory sessionFactory;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
	 
	  static{
	     String resource = "pack/mybatis/Configuration.xml";
	     try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	         reader.close();
	         
	         //Mabatis Annotation 사용시 추가 코드
	         Class[] mappers = {SqlMapperInterface.class};
	         for(Class m : mappers) {
	        	 sessionFactory.getConfiguration().addMapper(m);;
	         }
	         
	         
	     } catch (Exception e) {
	     System.out.println("SqlMapConfig 오류 : " + e);
	  }
	}
	 
	public static SqlSessionFactory getSqlSession(){
	     return sessionFactory;
	  }
}
