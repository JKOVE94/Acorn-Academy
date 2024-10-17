package pack.model;

import java.util.List;

import pack.model.SqlMapperInter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<SangpumDto> selectDataAll(){
		SqlSession sqlSession = factory.openSession();
		List<SangpumDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.
		}catch (Exception e) {
			System.out.println("selectDataAll err :"+e);
		}
		finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
