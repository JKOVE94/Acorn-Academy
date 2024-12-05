package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	
	// @Autowired <- 만들어지는 순서상으로 JdbcDaoSupport가 먼저 상속되고 이후에 Setter가 작동한다.
	// @Autowired는 생성자 선언 이후에 실행이 된다. 그러나 만약 Field Injection 을 하게된다면, 
	// 부모Class인 JdbcDaoSupport에서 생성자가 실행될 당시 dataSource의 초기화가 되지 않은 상태 (즉 데이터가 없는 상태) 이기 때문에 오류가 발생한다.
	private DataSource dataSource;
	
	@Autowired
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public List<SangpumDto> selectList() {
		RowMapper rowMapper = new SangpumRowMapper();
		
		//아래와 같이 기술하면 레코드의 갯수 만큼 mapRow()를 호출 -> sangdata의 레코드가 고갈될때까지 반복하며 List로 반환한다.
		return getJdbcTemplate().query("SELECT * FROM sangdata", rowMapper);
		//jdbcDaoSupport 클래스안에 getJdbcTemplate()를 통해서 JdbcTemplate의 기능을 사용할 수 있다.
		//Getter로 미리 설정해 두었다.
	}
	
	//내부 클래스
	
	// RowMapper를 구현한 Class를 내부 클래스로 선언
	@Component
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
