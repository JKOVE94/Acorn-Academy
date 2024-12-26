package pack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUser {
	private int id;
	private String userName;
	private String password;
	private String email; //기타 다양한 변수 선언 가능
	
	private String role; // Authority 정보를 저장할 컬럼 ROLE_USER, ROLE_STAFF ... 이런 형식으로 저장
	
}
