package pack.model;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{

	@Autowired
	public MemberDao(DataSource datasource) {
		super.setDataSource(datasource);
	}
	
	//전체 자료 읽기
	public List<MemberDto> getMemberAll(){
		String sql = "SELECT id, name, passwd, regdate FROM membertab";
		
		List<MemberDto> list = getJdbcTemplate().query(sql, (RowMapper) (rs, rowNum) -> {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setRegdate(rs.getString("regdate"));
			return dto;
		});
		return list;
	}
		//추가
		public void insData(MemberBean bean){
			String sql = "INSERT INTO membertab(id, name, passwd, regdate) VALUES(?,?,?,now())";
			Object [] params = {bean.getId(), bean.getName(), bean.getPasswd()};
			getJdbcTemplate().update(sql, params);
		}
		
		//한명 자료 읽기
		public MemberDto getMember(String id){
			String sql = "SELECT id, name, passwd, regdate FROM membertab WHERE id=?";
			MemberDto dto = (MemberDto) getJdbcTemplate().queryForObject(sql, new Object[] {id}, (rs, rowNum) -> {
				MemberDto dto1 = new MemberDto();
				dto1.setId(rs.getString("id"));
				dto1.setName(rs.getString("name"));
				dto1.setPasswd(rs.getString("passwd"));
				dto1.setRegdate(rs.getString("regdate"));
				return dto1;
			});
			return dto;
		}
		
		//자료 수정
		public void upData(MemberBean bean){
			String sql = "UPDATE membertab SET name=?, passwd=? WHERE id=?";
			getJdbcTemplate().update(sql, new Object[] {bean.getName(),bean.getPasswd(),bean.getId()});
		}
		
		//자료 삭제
		public void delData(String id){
			String sql = "DELETE FROM membertab WHERE id=?";
			getJdbcTemplate().update(sql, new Object[] {id});
		}
}
