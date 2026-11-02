package com.Shravan.RestaurantManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Shravan.RestaurantManagement.Modal.Food;
import com.Shravan.RestaurantManagement.Service.FoodService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // Insert single food
    @PostMapping("/{restaurantId}")
    public ResponseEntity<Food> saveFoodItems(
            @PathVariable Integer restaurantId,
            @Valid @RequestBody Food food) {

        Food savedFood = foodService.saveFoodItems(restaurantId, food);

        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    // Insert multiple foods
    @PostMapping("/multiple/{restaurantId}")
    public ResponseEntity<List<Food>> saveMultipleFoodItems(
            @PathVariable Integer restaurantId,
            @RequestBody List<@Valid Food> foods) {

        List<Food> savedFoods =
                foodService.saveMultipleFoodItems(restaurantId, foods);

        return new ResponseEntity<>(savedFoods, HttpStatus.CREATED);
    }

    // Get all foods
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {

        return ResponseEntity.ok(foodService.getAllFoods());
    }

    // Get food by ID
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodByID(@PathVariable Integer id) {

        return ResponseEntity.ok(foodService.getFoodByID(id));
    }

    // Get foods by restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getFoodsByRestaurantId(
            @PathVariable Integer restaurantId) {

        return ResponseEntity.ok(
                foodService.getFoodsByRestaurantId(restaurantId));
    }

    // Full update
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodById(
            @PathVariable Integer id,
            @Valid @RequestBody Food food) {

        Food updatedFood = foodService.updateFoodById(id, food);

        return ResponseEntity.ok(updatedFood);
    }

    // Partial update
    @PatchMapping("/{id}")
    public ResponseEntity<Food> partialUpdateFood(
            @PathVariable Integer id,
            @RequestBody Food food) {

        Food updatedFood = foodService.partialUpdateFood(id, food);

        return ResponseEntity.ok(updatedFood);
    }

    // Delete food
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodById(@PathVariable Integer id) {

        foodService.deleteFoodById(id);

        return ResponseEntity.ok("Food deleted successfully");
    }
}