package pack.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter {

	//JdbcDaoSupport에 dataSource 설정하기
	@Autowired
	public JikwonImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	//직급으로 직원 찾기
	@Override
	public List<JikwonDto> findJikwonL(String level) {
		String sql;
		List<JikwonDto> list;
		if(level.equals("")) {
			sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon";
			list  = (ArrayList<JikwonDto>) getJdbcTemplate().query(sql,(RowMapper) (rs, rowNum) -> {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				return dto;
			});			
		}
	
		//PreparedStatement로 조건 추가 => Object 사용
		else {
			sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon WHERE jikwonjik=?";
			list  = (ArrayList<JikwonDto>) getJdbcTemplate().query(sql, new Object[] {level}, (RowMapper) (rs, rowNum) -> {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				return dto;
			});			
		}
		return list;	
	}
	
	//부서명으로 직원 찾기
	@Override
	public List<JikwonDto> findJikwonD(String depart) {
		String sql;
		List<JikwonDto> list;
		if(depart.equals("")) {
			//jikwon Table에는 부서명이 없기 때문에 INNER JOIN으로 buser Table의 부서명을 가져오기.
			sql = "SELECT j.jikwonno, j.jikwonname, j.jikwongen, j.jikwonpay FROM jikwon AS j INNER JOIN buser AS b ON j.busernum = b.buserno";
			list  = (ArrayList<JikwonDto>) getJdbcTemplate().query(sql,(RowMapper) (rs, rowNum) -> {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				return dto;
			});			
		}
		
		//PreparedStatement로 조건 추가 => PrepareStatementSetter 사용
		else {
			//jikwon Table에는 부서명이 없기 때문에 INNER JOIN으로 buser Table의 부서명을 가져오기.
			sql =  "SELECT j.jikwonno, j.jikwonname, j.jikwongen, j.jikwonpay FROM jikwon AS j INNER JOIN buser AS b ON j.busernum = b.buserno WHERE b.busername=?";
			//PreparedStatement와 RowMapper는 추상메소드를 1개만 가지는 Interface이다. 즉 Lambda 함수를 사용 할 수 있다.
			list  = (ArrayList<JikwonDto>) getJdbcTemplate().query(sql, pss -> pss.setString(1, depart), (RowMapper) (rs, rowNum) -> {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				return dto;
			});			
		}
		return list;
	}
}
