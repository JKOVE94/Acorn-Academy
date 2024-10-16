package aopex2;

import org.springframework.stereotype.Repository;

//@Component
@Repository //객체 생성, persistence (Database를 처리하는 Class)
public class AticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("selectAll : db 전체 자료 읽기");
	}
}
