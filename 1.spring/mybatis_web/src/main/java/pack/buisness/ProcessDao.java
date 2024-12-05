package pack.buisness;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	public static ProcessDao getInstance() {
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectAll() throws SQLException{
		SqlSession sqlSession = factory.openSession();
		List<DataDto> list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		DataDto dataDto = sqlSession.selectOne("selectDataById",para);
		sqlSession.close();
		return dataDto;
	}
	
	public void insData(FormBean bean) throws SQLException{
		SqlSession sqlSession = factory.openSession(); //수동 commit
		sqlSession.insert("insertData", bean);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void upData(FormBean bean) throws SQLException{ //parameter
		//일반적으로 java에서 db작업은 수정이 필요하기 때문에 manual commit 이 기본값이다.
		//필요시에 rollback을 해야하기 때문
		
		SqlSession sqlSession = factory.openSession(true); // true를 넣게 되면 auto commit이 된다.
		//SqlSession sqlSession = factory.openSession(); //manual commit
		sqlSession.update("updateData", bean);
		//sqlSession.commit();
		sqlSession.close();
	}
	
	public boolean delData(int para){ //parameter
		//일반적으로 java에서 db작업은 수정이 필요하기 때문에 manual commit 이 기본값이다.
		//필요시에 rollback을 해야하기 때문
		SqlSession sqlSession = factory.openSession(); // true를 넣게 되면 auto commit이 된다.
		//SqlSession sqlSession = factory.openSession(); //manual commit
		boolean b = false;
		try {
			int count = sqlSession.delete("deleteData", para);
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
