package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class SangpumImpl implements SangpumInter{
private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<SangpumDto> selectDataAll(){
		SqlSession sqlSession = factory.openSession();
		List<SangpumDto> list = null;
		
		try {
			list = sqlSession.selectList("selectDataAll");
		}catch (Exception e) {
			System.out.println("selectDataAll err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
