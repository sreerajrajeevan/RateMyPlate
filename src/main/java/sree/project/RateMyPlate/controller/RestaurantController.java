package sree.project.RateMyPlate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sree.project.RateMyPlate.exception.RestaurantException;
import sree.project.RateMyPlate.model.Restaurant;
import sree.project.RateMyPlate.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/rateme")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/{prodId}")
    public Restaurant getProductById(@PathVariable int prodId) {
        return restaurantService.getRestaurantById(prodId);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            int restaurantId = restaurantService.createRestaurent(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurantId);
        } catch (RestaurantException e) {
            if (e.getErrorCode() == RestaurantException.ErrorCode.DUPLICATE_RESTAURANT) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            } else if (e.getErrorCode() == RestaurantException.ErrorCode.RESTAURANT_NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the restaurant.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the restaurant.");
        }
    }

    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<?> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurant restaurant) {
        try {
            Restaurant temprestaurant = restaurantService.updateRestaurantById(restaurantId, restaurant);
            return ResponseEntity.ok().body(temprestaurant.getRestaurantId());
        } catch (RestaurantException e) {
            if (e.getErrorCode() == RestaurantException.ErrorCode.DUPLICATE_RESTAURANT) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            } else if (e.getErrorCode() == RestaurantException.ErrorCode.RESTAURANT_NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the restaurant.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the restaurant.");
        }
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable int restaurantId) {
        restaurantService.deleteRestaurent(restaurantId);
    }


}
