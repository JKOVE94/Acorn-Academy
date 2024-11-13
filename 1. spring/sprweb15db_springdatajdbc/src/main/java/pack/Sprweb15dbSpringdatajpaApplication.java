package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb15dbSpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb15dbSpringdatajpaApplication.class, args)
				.getBean(Sprweb15dbSpringdatajpaApplication.class).myExecute();
	}

	@Autowired
	ProductCrudRepository crudRepository;

	//Spring Data JDBC : Spring Data JPA보다 가볍게 사용할 수 있는 라이브러리
	private void myExecute() {
		System.out.println("독립 어플리케이션 실행");
		insertData();
		deleteData();
		selectData();
	}
	private void insertData() {
		/*
		//Entity 생성
		ProductVo productVo = new ProductVo(null,"라떼",12, 5000);
		crudRepository.save(productVo); //code에 null을 준다 => 그러면 insert처리
		*/
		ProductVo productVo = new ProductVo(2,"아메리카노",22, 4000);
		crudRepository.save(productVo); //code에 기존 번호를 주면 update 처리
	}
	
	private void deleteData() {
		crudRepository.deleteById(4); //해당 index가 없더라고 오류가 떨어지지는 않는다.
	}

	private void selectData() {
		List<ProductVo> list = (List<ProductVo>) crudRepository.findAll();
//		System.out.println(list.get(0).getSang());
		list.forEach(e -> System.out.println(e.getCode() + " " + e.getSang() + " " + e.getSu() + " " + e.getDan()));
		

		System.out.println("\n특정 레코드 1개 읽기");
		ProductVo vo = (ProductVo) crudRepository.findById(1).get(); //findById(PK값)
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
	}
	


	
}
