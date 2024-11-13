package pack.buisness;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectAll(){
		SqlSession sqlSession = factory.openSession();
		
		List<DataDto> list = null;
		
		try {
			list = sqlSession.selectList("selectDataAll");
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
			dataDto = sqlSession.selectOne("selectDataByPart",id);
			
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
			if(sqlSession.insert("insertData", bean)>0) b=true;
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
			DataDto dto = selectPart(bean.getId());
			if(bean.getPasswd().equalsIgnoreCase(dto.getPasswd())) {				
				if(sqlSession.update("updateData", bean)>0) {
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
			int count = sqlSession.delete("deleteData", id);
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
