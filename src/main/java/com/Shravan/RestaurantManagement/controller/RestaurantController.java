package com.Shravan.RestaurantManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Shravan.RestaurantManagement.Modal.Restaurant;
import com.Shravan.RestaurantManagement.Service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    // Constructor injection
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Insert single restaurant
    @PostMapping
    public ResponseEntity<Restaurant> saveRestaurant(
            @Valid @RequestBody Restaurant restaurant) {

        Restaurant savedRestaurant =
                restaurantService.saveRestaurant(restaurant);

        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // Insert multiple restaurants
    @PostMapping("/multiple")
    public ResponseEntity<List<Restaurant>> saveMultipleRestaurants(
            @RequestBody List<@Valid Restaurant> restaurants) {

        List<Restaurant> savedRestaurants =
                restaurantService.saveMultipleRestaurants(restaurants);

        return new ResponseEntity<>(savedRestaurants, HttpStatus.CREATED);
    }

    // Get all restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {

        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    // Get restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    // Full update
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @PathVariable Integer id,
            @Valid @RequestBody Restaurant restaurant) {

        Restaurant updatedRestaurant =
                restaurantService.updateRestaurant(id, restaurant);

        return ResponseEntity.ok(updatedRestaurant);
    }

    // Partial update
    @PatchMapping("/{id}")
    public ResponseEntity<Restaurant> partialUpdateRestaurant(
            @PathVariable Integer id,
            @RequestBody Restaurant restaurant) {

        Restaurant updatedRestaurant =
                restaurantService.partialUpdateRestaurant(id, restaurant);

        return ResponseEntity.ok(updatedRestaurant);
    }

    // Delete restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(
            @PathVariable Integer id) {

        restaurantService.deleteRestaurant(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCity(city));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCityAndIsActive(
            @RequestParam String city,
            @RequestParam Boolean isActive) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCityAndIsActive(city, isActive));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByRating(
            @PathVariable Double rating) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByRating(rating));
    }
 // Search restaurants by name
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByName(
            @PathVariable String name) {

        return ResponseEntity.ok(
                restaurantService.getByRestaurantNameContaining(name));
    }
}