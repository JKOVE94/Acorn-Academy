package pack.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public HashMap<Integer,String> getBuserInfo() {
		SqlSession sqlSession = factory.openSession();
		List<BuserDto> list = null;
		HashMap<Integer,String> map = new HashMap();
		
		try {
			list = sqlSession.selectList("selectBuser");
		} catch (Exception e) {
			System.out.println("getBuserInfo err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		for(BuserDto d : list) {
			map.put(d.getBuserno(), d.getBusername());
		}
		return map;
	}
	
	@Override
	public List<InwonDto> FindInwon() {
		SqlSession sqlSession = factory.openSession();
		List<InwonDto> list =null;
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
	public List<JikwonDto> SelectJikwon() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list =null;
		
		try {
			list = sqlSession.selectList("selectAllJikwon");
		} catch (Exception e) {
			System.out.println("SelectJikwon err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
}
