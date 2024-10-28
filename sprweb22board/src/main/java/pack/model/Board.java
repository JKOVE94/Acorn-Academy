package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="board")
public class Board {

	@Id
	private int num;
	private String name;
	private String pass;
	private String mail;
	private String title;
	private String cont;
	private String bip;
	private String bdate;
	private int readcnt;
	private int gnum;
	private int onum;
	private int nested;
}
