package pack.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.model.SqlMapperInter;

public class SqlMapConfig {
	public static SqlSessionFactory sqlSession;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
	 
	  static{
	     String resource = "pack/mybatis/Configuration.xml";
	     try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sqlSession = new SqlSessionFactoryBuilder().build(reader);
	         reader.close();
	         
	         //Interface에 
	         Class[] mappers = {SqlMapperInter.class};
	         
	         //Mybatis 어노테이션을 추가 할 때 아래와 같이 SqlSessionFactory에 설정값안에 mapper를 지정해줘야한다.
	         for(Class m : mappers) {
	        	 sqlSession.getConfiguration().addMapper(m);
	         }
	         
	     } catch (Exception e) {
	     System.out.println("SqlMapConfig 오류 : " + e);
	  }
	}
	 
	public static SqlSessionFactory getSqlSession(){
	     return sqlSession;
	  }
}
