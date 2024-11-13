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
		
		System.out.println("\n특정 레코드 1개 읽기---------------");
		ProductVo vo = (ProductVo) repository.findById(1).get(); //findById(PK값)
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println("\n특정 레코드 1개 읽기---------------");
		ProductVo vo2 = (ProductVo) repository.findByCode(2); // 코드가 2인 record를 찾을 수 있다.
		System.out.println(vo2.getCode() + " " + vo2.getSang() + " " + vo2.getSu() + " " + vo2.getDan());
		
		System.out.println("\nJPQL에 의한 처리---------------");
		List<ProductVo> list2 = repository.findAllData();
		list2.forEach(e -> System.out.println(e.getCode() + " " + e.getSang() + " " + e.getSu() + " " + e.getDan()));
		
		System.out.println("\nWHERE 조건---------------");
		System.out.println();
		ProductVo vo3 = (ProductVo) repository.findByCodeMy(3); // 코드가 3인 record를 찾을 수 있다. (JPQL를 적용)
		System.out.println(vo3.getCode() + " " + vo3.getSang() + " " + vo3.getSu() + " " + vo3.getDan());

		System.out.println();
		ProductVo vo4 = (ProductVo) repository.findByCodeMy2(1); // 코드가 3인 record를 찾을 수 있다. (JPQL를 적용)
		System.out.println(vo4.getCode() + " " + vo4.getSang() + " " + vo4.getSu() + " " + vo4.getDan());
		
		System.out.println();
		List<ProductVo> list3 = (List<ProductVo>) repository.findByCodeMy3(2, "콘파냐");
		list3.forEach(e -> System.out.println(e.getCode() + " " + e.getSang() + " " + e.getSu() + " " + e.getDan()));
		
		System.out.println("nativeQuery");
		List<ProductVo> list4 = (List<ProductVo>) repository.findAllDataNative();
		list4.forEach(e -> System.out.println(e.getCode() + " " + e.getSang() + " " + e.getSu() + " " + e.getDan()));
		
		repository.deleteById(null);
	}

}
