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
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter {

	private DataSource dataSource;

	@Autowired
	public JikwonImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<JikwonDto> getAlljikwon() {
		RowMapper rowMapper = new JikwonRow();
		return getJdbcTemplate().query("SELECT j.jikwonno, j.jikwonname, b.busername, j.jikwonjik "
				+ "FROM jikwon AS j INNER JOIN buser AS b ON j.busernum = b.buserno ", rowMapper);
	}

	class JikwonRow implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			JikwonDto dto = new JikwonDto();
			dto.setJkiwonno(rs.getInt("jikwonno"));
			dto.setJikwonname(rs.getString("jikwonname"));
			dto.setBusername(rs.getString("busername"));
			dto.setJikwonjik(rs.getString("jikwonjik"));
			return dto;
		}
	}

}
