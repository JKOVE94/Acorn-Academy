package conect.data.repository;

import conect.data.entity.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<FavoritesEntity,Integer> {
}
