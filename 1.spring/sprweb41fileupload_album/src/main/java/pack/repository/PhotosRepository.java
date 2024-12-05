package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Photos;
import pack.entity.Users;

public interface PhotosRepository extends JpaRepository<Photos, Long>{

	List<Photos> findByUsersId(Long userid);
	
}
