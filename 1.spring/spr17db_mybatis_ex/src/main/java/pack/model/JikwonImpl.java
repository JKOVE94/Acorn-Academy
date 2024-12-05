package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> SelectAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list =null;
		
		try {
			list = sqlSession.selectList("selectAllJikwon");
		} catch (Exception e) {
			System.out.println("SelectAll err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> FindInwon() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list =null;
		
		try {
			list = sqlSession.selectList("selectBuserInwon");
		} catch (Exception e) {
			System.out.println("SelectAll err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> FindTopSal() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list =null;
		
		try {
			list = sqlSession.selectList("selectBuserTopPay");
		} catch (Exception e) {
			System.out.println("SelectAll err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
}
