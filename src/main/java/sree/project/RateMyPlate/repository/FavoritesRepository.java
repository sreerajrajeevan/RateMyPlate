package sree.project.RateMyPlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sree.project.RateMyPlate.model.Favorites;
@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {
}
