package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb16dbSpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb16dbSpringdatajpaApplication.class, args)
		.getBean(Sprweb16dbSpringdatajpaApplication.class).myExecute();;
	}
	
	@Autowired
	private ProductRepository repository; 
	
	private void myExecute() {
		selectData();
	}
	
	private void selectData() {
		List<ProductVo> list = (List<ProductVo>) repository.findAll();
//		System.out.println(list.get(0).getSang());
		list.forEach(e -> System.out.println(e.getCode() + " " + e.getSang() + " " + e.getSu() + " " + e.getDan()));
		

		System.out.println("\n특정 레코드 1개 읽기");
		ProductVo vo = (ProductVo) repository.findById(1).get(); //findById(PK값)
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
	}

}
