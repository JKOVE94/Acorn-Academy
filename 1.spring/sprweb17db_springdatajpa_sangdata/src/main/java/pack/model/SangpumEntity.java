package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sangdata")
public class SangpumEntity {
	
	@Id
	@Column(name = "code")
	private int code;
	
	@Column(name = "sang", nullable = false)
	private String sang;
	
	@Column(name = "su", nullable = false)
	private int su;
	
	@Column(name = "dan", nullable = false)
	private int dan;
	
}
