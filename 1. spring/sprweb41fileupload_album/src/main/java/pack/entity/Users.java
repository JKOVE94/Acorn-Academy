package pack.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length=20)
	private String username;
	
	@Column(nullable = false, length=255)
	private String password;
	
	@Column(nullable = false, length=50, unique = true)
	private String email;
	
	// orphanRemoval : 고아객체를 모두 제거하겠다. 연관된 자식 Entity가 부모 Entity와의 관계에서 제외될 경우 자식 Entity 자동 삭제
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true) 
	private List<Photos> photoList;
}
