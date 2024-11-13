package aopex1;

public class AticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("selectAll : db 전체 자료 읽기");
	}
}
