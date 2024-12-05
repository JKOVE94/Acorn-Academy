package pack.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {

	private int num, readcnt;
	private String author, title, content, bwrite;
}
