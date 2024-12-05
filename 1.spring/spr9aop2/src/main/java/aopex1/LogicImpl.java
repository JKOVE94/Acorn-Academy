package aopex1;

//핵심 로직

public class LogicImpl implements LogicInter{
	private ArticleInter articleInter;
	
	public LogicImpl() {}
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll();
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("selectDataProcess2 수행");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("selectDataProcess2 err :"+e);
		}
		System.out.println("selectDataProcess2 수행 최종 소요 시간 3초");
	}

}
