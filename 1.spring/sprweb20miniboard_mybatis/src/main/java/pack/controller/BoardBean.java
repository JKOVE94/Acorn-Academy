package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardBean {

	private int num, readcnt;
	private String author, title, content, bwrite;
	private String searchName, searchValue; //검색용
}
