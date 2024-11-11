package pack.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Photos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100)
	private String albumname;
	
	@Column(length = 100)
	private String title;

	@Column(columnDefinition = "TEXT") //테이블의 text type으로 매핑
	private String description;
	
	@Column(nullable = false, length= 255)
	private String filepath;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime uploadat;
	
				//영속성 작업을 진행하기 이전에 기본값을 지정하는 방법 => @PrePersist 어노테이션을 사용하면 영속성을 지니전에 해당 메소드가 자동 실행된다.
	@PrePersist //기본값 지정에만 사용하는것은 아니다
	protected void onCreate() {
		uploadat=LocalDateTime.now();
	}
	
	@ManyToOne
	@JoinColumn(name="userid", nullable = false)
	private Users users;
	
}
