package pack.model;

public class SangpumImpl implements SangpumInter {
	
	@Override
	public String calcMoney(String sang, int su, int dan) {
		int total = su * dan;
		return "\n상품명 : "+sang+"\n금액 : "+total+"원";
	}
}
