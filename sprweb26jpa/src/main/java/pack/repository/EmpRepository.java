package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
