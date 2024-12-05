package pack.model;

public class MoneyCalc implements MoneyInter{

	@Override
	public int[] calcMoney(int money) {
		int res[] = new int [5];
		int divisor = 10000;
		for(int i=0; i<res.length; i++) {
			res[i] = money/divisor;
			money %= divisor;
			divisor /=10;
		}
		return res;
	}

}
