package pack.model;

public class Gugudan implements CalcInter{
	
	@Override
	public int[] numberCalc(int su) {
		int gugu[] = new int[9];
		for(int i=0; i<9; i++) {
			gugu[i]=su*(i+1);
		}
		return gugu;
	}	

}
