package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardBean {
	private String author, title, content,bwrite;
	private int num,readcnt;
	private String searchName, searchValue;
	
}
