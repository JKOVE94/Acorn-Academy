package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {

	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public ArrayList<SangpumDto> getDataAll() {
		String sql = "SELECT * FROM sangdata";

		return (ArrayList<SangpumDto>) getJdbcTemplate().query(sql, new ItemRowMapper());
	}

	// 내부 클래스
	class ItemRowMapper implements RowMapper<SangpumDto>{

			@Override
			public SangpumDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				return dto;
			}
			
		}
}
