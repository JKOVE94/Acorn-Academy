package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	
	@Override
	public List<SangpumDto> selectList() {
		RowMapper rowMapper = new SangpumRowMapper();
		
		//아래와 같이 기술하면 레코드의 갯수 만큼 mapRow()를 호출 -> sangdata의 레코드가 고갈될때까지 반복하며 List로 반환한다.
		return getJdbcTemplate().query("SELECT * FROM sangdata", rowMapper);
		//jdbcDaoSupport 클래스안에 getJdbcTemplate()를 통해서 JdbcTemplate의 기능을 사용할 수 있다.
		//Getter로 미리 설정해 두었다.
	}
	
	//내부 클래스
	class SangpumRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// mapRow : PrepareStatement로 select 실행 결과를 1개씩 순서대로 전달 받음 rs.next() 필요없이 내부에서 수행되고 있음
			System.out.println("rowNum : "+rowNum);
			
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			
			return dto; //리턴하게 된다면 알아서 List Collection에 들어가게 됨
		}
		
	}

}
