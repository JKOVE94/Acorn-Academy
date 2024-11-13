package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "mem") // 그렇기 때문에 Table 어노테이션을 활용해서 해당 Table 이름을 명시적으로 작성하는것이 좋다.
//JPA는 자바의 CamelCase로 이름을 작성한 경우 Underscore naming convention (Snake Case)로 변경한다.
//MemEntity => Mem_entity

@Entity
public class MemEntity { 
	
	@Id // Prime Key
	@Column(name = "num") //실제 주소
	private int num; //자바 변수
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "addr")
	private String addr;
	
	public MemEntity() {}
	public MemEntity(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
}
