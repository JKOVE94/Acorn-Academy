package pack.model;

import org.springframework.data.repository.CrudRepository;


public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer>{ //CrudRepository<타입, Primekey의 데이터 타입(식별자 타입)>
	// EntityManagerFactory, EntityManager, EntityTransaction이 내부적으로 처리된다. => 즉 개발자가 따로 선언할 필요가 없다.
	//Repository <- CrudRepository 지원 메소드 - save(), findById(), count(), exsit(), delete() ...
}