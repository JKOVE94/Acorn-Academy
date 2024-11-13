package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="springboard")
public class BoardVo {

	@Id
	private int num;
	private String author;
	private String title;
	private String content;
	private String bwrite;
	private int readcnt;
	
}
