package pack.form;

import lombok.Getter;
import lombok.Setter;
import pack.entity.User;

@Setter
@Getter
public class UserForm {

	private long userno;
	private String userid;
	private String username;
	private int userheight;
	private int userweight;
	private String userpass;
	
	public static User toEntity(UserForm form) {
		User user = new User();
		if(form.getUserno() > 0) {
			user.setUserno(form.getUserno());
		}
		user.setUserid(form.getUserid());
		user.setUsername(form.getUsername());
		user.setUserheight(form.getUserheight());
		user.setUserweight(form.getUserweight());
		user.setUserpass(form.getUserpass());
		return user;
	}
}
