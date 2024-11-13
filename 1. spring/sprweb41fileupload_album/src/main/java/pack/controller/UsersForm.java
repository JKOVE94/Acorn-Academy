package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Users;

@Setter
@Getter
public class UsersForm {

	private long id;
	private String username;
	private String password;
	private String email;
	
	/*
	public static Users toEntity(UsersForm form) {
		return Users.builder()
				.id(form.getId())
				.username(form.getUsername())
				.password(form.getPassword())
				.email(form.getEmail())
				.build();
	}
	*/
	
	public static Users toEntity(UsersForm form) {
		Users users = new Users();
		users.setId(form.getId());
		users.setUsername(form.getUsername());
		users.setPassword(form.getPassword());
		users.setEmail(form.getEmail());
		return users;
	}
}
