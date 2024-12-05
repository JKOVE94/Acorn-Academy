package pack.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	private long userno;
	private String username;
	private int userheight;
	private int userweight;
	private String userid;
	private String userpass;
	
	@OneToMany(mappedBy = "user")
	private List<Exercises> exlist;
}
