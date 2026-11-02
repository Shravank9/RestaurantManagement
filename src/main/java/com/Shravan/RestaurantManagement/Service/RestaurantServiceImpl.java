package com.Shravan.RestaurantManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shravan.RestaurantManagement.Modal.Restaurant;
import com.Shravan.RestaurantManagement.Repo.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant updateRestaurant(Integer id, Restaurant restaurant) {

		Restaurant existingRestaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
		existingRestaurant.setLocation(restaurant.getLocation());
		existingRestaurant.setCity(restaurant.getCity());
		existingRestaurant.setContactNumber(restaurant.getContactNumber());
		existingRestaurant.setEmail(restaurant.getEmail());
		existingRestaurant.setRating(restaurant.getRating());
		existingRestaurant.setIsActive(restaurant.getIsActive());

		return restaurantRepository.save(existingRestaurant);
	}

	@Override
	public Restaurant partialUpdateRestaurant(Integer id, Restaurant restaurant) {

		Restaurant existingRestaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		if (restaurant.getRestaurantName() != null)
			existingRestaurant.setRestaurantName(restaurant.getRestaurantName());

		if (restaurant.getLocation() != null)
			existingRestaurant.setLocation(restaurant.getLocation());

		if (restaurant.getCity() != null)
			existingRestaurant.setCity(restaurant.getCity());

		if (restaurant.getContactNumber() != null)
			existingRestaurant.setContactNumber(restaurant.getContactNumber());

		if (restaurant.getEmail() != null)
			existingRestaurant.setEmail(restaurant.getEmail());

		if (restaurant.getRating() != null)
			existingRestaurant.setRating(restaurant.getRating());

		if (restaurant.getIsActive() != null)
			existingRestaurant.setIsActive(restaurant.getIsActive());

		return restaurantRepository.save(existingRestaurant);
	}

	@Override
	public void deleteRestaurant(Integer id) {
		restaurantRepository.deleteById(id);
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {
		return restaurantRepository.findById(id).get();
	}

	@Override
	public List<Restaurant> saveMultipleRestaurants(List<Restaurant> restaurants) {
		return restaurantRepository.saveAll(restaurants);
	}
	@Override
	public List<Restaurant> getRestaurantsByCity(String city) {
	    return restaurantRepository.findByCity(city);
	}
	@Override
	public List<Restaurant> getRestaurantsByCityAndIsActive(
	        String city, Boolean isActive) {

	    return restaurantRepository.findByCityAndIsActive(city, isActive);
	}

	@Override
	public List<Restaurant> getRestaurantsByRating(Double rating) {

	    return restaurantRepository.findByRatingGreaterThan(rating);
	}

	@Override
	public List<Restaurant> getByRestaurantNameContaining(String name) {
	    return restaurantRepository.findByRestaurantNameContaining(name);
	}
	

}
