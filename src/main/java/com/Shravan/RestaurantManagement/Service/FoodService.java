package com.Shravan.RestaurantManagement.Service;

import java.util.List;
import com.Shravan.RestaurantManagement.Modal.Food;

public interface FoodService {

    Food saveFoodItems(Integer restaurantId, Food food);

    List<Food> saveMultipleFoodItems(Integer restaurantId, List<Food> foods);

    List<Food> getAllFoods();

    Food getFoodByID(Integer id);

    Food updateFoodById(Integer id, Food food);

    Food partialUpdateFood(Integer id, Food food);
    List<Food> getFoodsByRestaurantId(Integer restaurantId);
    void deleteFoodById(Integer id);
}