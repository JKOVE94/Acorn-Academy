package conect.data.repository;

import conect.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcccountRepository extends JpaRepository<AccountEntity,Integer> {
}
