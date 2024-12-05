package model;

import org.springframework.stereotype.Service;

import business.SangpumBean;

@Service
public class SangpumModel { //모델 영역의 클래스
	public String compute(SangpumBean bean) {
		String data = "품명 : "+bean.getSang() +
		"<br/>금액 : " + (bean.getSu()*bean.getDan());
		return data;
	}
}
