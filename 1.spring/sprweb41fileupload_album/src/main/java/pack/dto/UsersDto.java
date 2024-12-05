package pack.dto;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Users;

@Setter
@Getter
public class UsersDto {

	private long id;
	private String username;
	private String password;
	private String email;
	
	/*
	public static UsersDto fromEntity(Users users) { //Users에서 UsersDTO로 데이터 옮기기 - Builder 패턴
		return UsersDto.builder()
				.id(users.getId())
				.username(users.getUsername())
				.password(users.getPassword())
				.email(users.getEmail())
				.build();
	}
	*/
	
	public static UsersDto fromEntity(Users users) { //Users에서 UsersDTO로 데이터 옮기기 - Setter 사용
		UsersDto dto = new UsersDto();
		dto.setId(users.getId());
		dto.setUsername(users.getUsername());
		dto.setPassword(users.getPassword());
		dto.setEmail(users.getEmail());
		return dto;
	}
}
