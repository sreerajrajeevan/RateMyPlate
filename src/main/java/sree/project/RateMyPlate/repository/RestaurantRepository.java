package sree.project.RateMyPlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sree.project.RateMyPlate.model.Restaurant;

import java.util.Optional;

@Component
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    Optional<Restaurant>findByRestaurantNameAndLocation(String restaurantName , String location);
}
