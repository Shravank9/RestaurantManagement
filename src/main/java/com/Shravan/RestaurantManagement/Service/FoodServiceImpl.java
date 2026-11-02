package com.Shravan.RestaurantManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shravan.RestaurantManagement.Modal.Food;
import com.Shravan.RestaurantManagement.Modal.Restaurant;
import com.Shravan.RestaurantManagement.Repo.FoodRepository;
import com.Shravan.RestaurantManagement.Repo.RestaurantRepository;
import com.Shravan.RestaurantManagement.Service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodServiceImpl(FoodRepository foodRepository,
                           RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    // Insert single food
    @Override
    public Food saveFoodItems(Integer restaurantId, Food food) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        food.setRestaurant(restaurant);

        return foodRepository.save(food);
    }

    // Insert multiple foods
    @Override
    @Transactional
    public List<Food> saveMultipleFoodItems(Integer restaurantId, List<Food> foods) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        for (Food food : foods) {
            food.setRestaurant(restaurant);
        }

        return foodRepository.saveAll(foods);
    }

    // Get all foods
    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // Get food by ID
    @Override
    public Food getFoodByID(Integer id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    // Full update
    @Override
    public Food updateFoodById(Integer id, Food food) {

        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        existingFood.setFoodName(food.getFoodName());
        existingFood.setDescription(food.getDescription());
        existingFood.setCategory(food.getCategory());
        existingFood.setPrice(food.getPrice());
        existingFood.setQuantity(food.getQuantity());
        existingFood.setIsAvailable(food.getIsAvailable());
        existingFood.setFoodType(food.getFoodType());

        return foodRepository.save(existingFood);
    }

    // Partial update
    @Override
    public Food partialUpdateFood(Integer id, Food food) {

        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        if (food.getFoodName() != null)
            existingFood.setFoodName(food.getFoodName());

        if (food.getDescription() != null)
            existingFood.setDescription(food.getDescription());

        if (food.getCategory() != null)
            existingFood.setCategory(food.getCategory());

        if (food.getPrice() != null)
            existingFood.setPrice(food.getPrice());

        if (food.getQuantity() != null)
            existingFood.setQuantity(food.getQuantity());

        if (food.getIsAvailable() != null)
            existingFood.setIsAvailable(food.getIsAvailable());

        if (food.getFoodType() != null)
            existingFood.setFoodType(food.getFoodType());

        return foodRepository.save(existingFood);
    }

    // Delete food
    @Override
    public void deleteFoodById(Integer id) {

        if (!foodRepository.existsById(id)) {
            throw new RuntimeException("Food not found");
        }

        foodRepository.deleteById(id);
    }
    @Override
    public List<Food> getFoodsByRestaurantId(Integer restaurantId) {

        return foodRepository.findByRestaurant_RestaurantId(restaurantId);
    }
}