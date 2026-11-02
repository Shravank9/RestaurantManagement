package com.Shravan.RestaurantManagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shravan.RestaurantManagement.Modal.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
    List<Food> findByRestaurant_RestaurantId(Integer restaurantId);

}
