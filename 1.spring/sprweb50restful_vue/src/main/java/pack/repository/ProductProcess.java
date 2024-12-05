package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.ProductDto;

@Repository
public class ProductProcess {

	@Autowired
	private SqlSession session;
	
	public List<ProductDto> getAll(){
		return session.selectList("product.getAll");
	}
	public ProductDto getData(String code){
		return session.selectOne("product.getData", code);
	}
	public int insert(ProductDto fbean){
		return session.insert("product.insert", fbean);
	}
	
	public int update(ProductDto fbean){
		return session.update("product.update", fbean);
	}
	
	public int delete(String code){
		return session.delete("product.delete", code);
	}
	
}
