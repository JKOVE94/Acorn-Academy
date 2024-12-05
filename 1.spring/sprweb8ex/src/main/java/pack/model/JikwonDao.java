package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao implements JikwonDaoInter {
	
	@Autowired
	private DataSource datasource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public ArrayList<JikwonDto> getJik(String jikwon){
		ArrayList<JikwonDto> list = new ArrayList<JikwonDto>();
		String sql;
		System.out.println(jikwon);
		try {
			conn = datasource.getConnection();
			
			if(jikwon == "") {
				sql = "SELECT jikwonno, jikwonname, jikwonjik, jikwonpay, jikwongen FROM jikwon";
				pstmt = conn.prepareStatement(sql);
			}
			else {
				sql = "SELECT jikwonno, jikwonname, jikwonjik, jikwonpay, jikwongen FROM jikwon WHERE jikwonjik = ?";				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jikwon);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getInt("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getInt("jikwonpay"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getJik err :"+e);
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			}catch (Exception e) {}
		}
		
		return list;
	}
}
