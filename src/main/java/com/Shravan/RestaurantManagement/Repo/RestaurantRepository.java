package com.Shravan.RestaurantManagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shravan.RestaurantManagement.Modal.Restaurant;

public interface RestaurantRepository
        extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findByCity(String city);
    List<Restaurant> findByCityAndIsActive(String city, Boolean isActive);

    List<Restaurant> findByRatingGreaterThan(Double rating);
    List<Restaurant> findByRestaurantNameContaining(String name);
}