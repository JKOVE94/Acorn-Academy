package pack.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBean {

	private int num, readcnt, gnum, onum,nested;
	private String name, pass, mail, title, cont, bip, bdate;
	private String searchName, searchValue;
	private int page;
	
	public void setBdate(){
		/*
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		this.bdate = year+"-"+month+"-"+day;
		*/
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		this.bdate = format.format(new Date());
		
	}
	
	public void setBip() {
	}
}
