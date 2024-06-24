package sree.project.RateMyPlate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sree.project.RateMyPlate.exception.RestaurantException;
import sree.project.RateMyPlate.model.Restaurant;
import sree.project.RateMyPlate.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository= restaurantRepository;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.orElse(null);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Integer createRestaurent(Restaurant restaurant) {
        Optional<Restaurant> isDuplicateRestaurant = restaurantRepository.findByRestaurantNameAndLocation(restaurant.getRestaurantName(),restaurant.getLocation());
        if(isDuplicateRestaurant.isPresent()){
            throw new RestaurantException(RestaurantException.ErrorCode.DUPLICATE_RESTAURANT,"Restaurant with the same name and location already exists.");
        }
        restaurantRepository.save(restaurant);
        return restaurant.getRestaurantId();
    }

    @Override
    public Restaurant updateRestaurantById(int id, Restaurant restaurant) {
        Optional<Restaurant> isDuplicateRestaurant = restaurantRepository.findByRestaurantNameAndLocation(restaurant.getRestaurantName(),restaurant.getLocation());
        if(isDuplicateRestaurant.isPresent()){
            throw new RestaurantException(RestaurantException.ErrorCode.DUPLICATE_RESTAURANT,"Restaurant with the same name and location already exists.");
        }
        // Find the existing restaurant by ID
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id " + id));


        // Update the fields of the existing restaurant
        existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        existingRestaurant.setLocation(restaurant.getLocation());

        // Save the updated restaurant entity to the repository
        return restaurantRepository.save(existingRestaurant);
    }


    @Override
    public void deleteRestaurent(int id) {
        restaurantRepository.deleteById(id);

    }
}
