package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	
	public List<MemberDto> getDataAll(){
		return session.selectList("member.selectDataAll");
	}
	
	public MemberDto getData(int num) {
		return session.selectOne("member.selectData", num);
	}
	
	public void insert(MemberDto fbean) {
		session.insert("member.insert", fbean);
	}
	
	public void update(MemberDto fbean) {
		session.update("member.update", fbean);
	}
	
	public void delete(int num) {
		session.delete("member.delete", num);
	}
	
}
