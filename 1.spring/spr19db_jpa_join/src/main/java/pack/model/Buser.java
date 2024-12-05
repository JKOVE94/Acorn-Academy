package pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

//직원 번호, 이름, 부서, 입사년
@Getter
@Entity
@Table(name = "buser")
public class Buser {
	
	@Id
	private int buserno;
	private String busername;
}
