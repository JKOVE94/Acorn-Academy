package pack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BuserRepository extends JpaRepository<Buser, Integer> {
	@Query("SELECT new pack.BuserJikwonGogekDTO(" +
		       "b.buserno, b.busername, b.buserloc, " +
		       "j.jikwonno, j.jikwonname, j.jikwonjik, j.jikwonpay, " +
		       "g.gogekno, g.gogekname, g.gogektel) " +
		       "FROM Buser b JOIN b.jikwons j " +
		       "LEFT JOIN j.gogeks g")
	List<BuserJikwonGogekDTO> findAllJoinedData();
}