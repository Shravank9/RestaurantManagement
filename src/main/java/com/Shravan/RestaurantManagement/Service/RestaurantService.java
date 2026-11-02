package com.Shravan.RestaurantManagement.Service;

import java.util.List;

import com.Shravan.RestaurantManagement.Modal.Restaurant;

public interface RestaurantService {

	Restaurant saveRestaurant(Restaurant restaurant);

	Restaurant getRestaurantById(Integer id);

	List<Restaurant> getAllRestaurants();

	Restaurant updateRestaurant(Integer id, Restaurant restaurant);

	Restaurant partialUpdateRestaurant(Integer id, Restaurant restaurant);

	List<Restaurant> saveMultipleRestaurants(List<Restaurant> restaurants);

	List<Restaurant> getRestaurantsByCity(String city);

	void deleteRestaurant(Integer id);

	List<Restaurant> getRestaurantsByCityAndIsActive(String city, Boolean isActive);

	List<Restaurant> getRestaurantsByRating(Double rating);
	List<Restaurant> getByRestaurantNameContaining(String name);
}
