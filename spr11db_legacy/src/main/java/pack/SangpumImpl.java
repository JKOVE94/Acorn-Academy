package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository // DB와 연결
public class SangpumImpl implements SangpumInter {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SangpumImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("driver lodding 실패");
		}
	}

	@Override
	public ArrayList<SangpumDto> selectList() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "jkove1994");
			pstmt = conn.prepareStatement("SELECT * FROM sangdata");
			rs = pstmt.executeQuery(); //Select 외에는 updateQuery
			
			while(rs.next()){
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setDan(rs.getString("dan"));
				dto.setSu(rs.getString("su"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("Select List err :" + e);
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

}
