package pack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	@Column(name = "jikwonno")
	private int jikwonno;
	
	@Column(name = "jikwonname")
	private String jikwonname;
	
	@Column(name = "jikwonibsail")
	private Date jikwonibsail;
	
	//JPA 어노테이션을 사용해서 JOIN하는 방법 
	@ManyToOne
	@JoinColumn(name = "busernum", referencedColumnName = "buserno")
	private Buser buser;
	
}
