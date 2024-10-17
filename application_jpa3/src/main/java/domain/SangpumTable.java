package domain;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SangpumTable {
	@Id
	int code;
	
	@NonNull
	String sang;
	
	int su, dan;

	public SangpumTable() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
}
