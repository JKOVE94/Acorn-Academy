package lambda_ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyLambda5db {
	public MyLambda5db() {
		//abc();
		
		//JDBC를 사용해서 DB연결
		try {
			Class.forName("org.mariadb.jdbc.Driver");	
		} 
		catch (Exception e) {
			System.out.println("Driver err: "+e);
			return;
		}
		queryDb("select * from sangdata", rs -> {
			System.out.println("처리 2");
			try {
				while(rs.next()) {
					System.out.print("코드 : "+rs.getString("code")+" ");
					System.out.print("상품 : "+rs.getString("sang")+" ");
					System.out.print("단가 : "+rs.getString("dan")+" ");
					System.out.print("수량 : "+rs.getString("su")+" ");
					System.out.println();
				}
			}
			catch (Exception e) {
				System.out.println("err : "+e);
			}
		});	
	}
	
	
	private void abc() {
		Consumer<Integer> printInt = i -> System.out.println(i);	
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		numbers.forEach(printInt);
	}
	
	private void queryDb(String sql, Consumer<ResultSet> consumer) {
		// try-with-resources : try문에 매개변수 전달 가능
		try(Connection conn  = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","jkove1994");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery()) 
		{
			System.out.println("처리 1");
			consumer.accept(rs);
			System.out.println("처리 3");
		} 
		catch (Exception e) {
			System.out.println("queryDB err :"+e);
		}
	}
	
	public static void main(String[] args) {
		new MyLambda5db();
	}

}
