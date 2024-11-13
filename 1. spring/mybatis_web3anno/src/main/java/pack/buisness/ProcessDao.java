package pack.buisness;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectAll(){
		SqlSession sqlSession = factory.openSession();
		
		List<DataDto> list = null;
		
		try {
			SqlMapperInterface inter = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);
			list = inter.selectDataAll();
		}
		catch(Exception e) {
			System.out.println("selectAll err : "+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	public DataDto selectPart(String id){
		SqlSession sqlSession = factory.openSession();
		
		DataDto dataDto =null;
		try {
			SqlMapperInterface inter = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);
			dataDto = inter.selectDataByPart(id);
			
		}catch (Exception e) {
			System.out.println("selectPart err : "+e);
		}
		finally{
			if(sqlSession != null) sqlSession.close();			
		}
		return dataDto;
	}
	
	public boolean insData(FormBean bean){
		SqlSession sqlSession = factory.openSession(); //수동 commit
		boolean b = false;
		try {
			SqlMapperInterface inter = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);
			if(inter.insertData(bean)>0) b=true;
			sqlSession.commit();
					
			
		}catch (Exception e) {
			System.out.println("insData err : "+e);
			sqlSession.rollback();
		}
		finally{
			if(sqlSession != null) sqlSession.close();			
		}
		return b;
	}
	
	public boolean upData(FormBean bean) { //parameter
		//일반적으로 java에서 db작업은 수정이 필요하기 때문에 manual commit 이 기본값이다.
		//필요시에 rollback을 해야하기 때문
		
		SqlSession sqlSession = factory.openSession(); //수동 commit
		boolean b = false;
		try {
			//비번 비교후 수정 여부를 판단
			SqlMapperInterface inter = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);
			
			DataDto dto = inter.selectDataByPart(bean.getId()); //기존 데이터를 꺼내오기 위해서 interface안에서 개인의정보를 추출 이후 비교
			
			if(bean.getPasswd().equalsIgnoreCase(dto.getPasswd())) {				
				if(inter.updateData(bean)>0) {
					b= true;
					sqlSession.commit();
				}		
			}
		}catch (Exception e) {
			System.out.println("upData err : "+e);
			sqlSession.rollback();
		}
		finally{
			if(sqlSession != null) sqlSession.close();			
		}
		return b;
	}
	
	public boolean delData(String id){ //parameter
		//일반적으로 java에서 db작업은 수정이 필요하기 때문에 manual commit 이 기본값이다.
		//필요시에 rollback을 해야하기 때문
		SqlSession sqlSession = factory.openSession(); // true를 넣게 되면 auto commit이 된다.
		//SqlSession sqlSession = factory.openSession(); //manual commit
		boolean b = false;
		try {
			SqlMapperInterface inter = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);
			int count = inter.deleteData(id);
			if(count>0) b=true;
			sqlSession.commit();
		}
		catch(Exception e){
			System.out.println("delData err :"+e);
			sqlSession.rollback();
		}
		finally{
			if(sqlSession !=null) sqlSession.close();
		}
		return b;
	}
	
	
}
