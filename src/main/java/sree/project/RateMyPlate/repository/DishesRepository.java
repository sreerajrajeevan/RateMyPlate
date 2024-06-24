package sree.project.RateMyPlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sree.project.RateMyPlate.model.Dishes;
@Repository
public interface DishesRepository extends JpaRepository<Dishes,Integer> {
}
