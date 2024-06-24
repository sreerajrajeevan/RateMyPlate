package sree.project.RateMyPlate.service;

import sree.project.RateMyPlate.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getAllRestaurants();
    Integer createRestaurent(Restaurant restaurant);
    Restaurant updateRestaurantById(int id, Restaurant restaurant);
    void deleteRestaurent(int id);
}
