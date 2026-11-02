package com.Shravan.RestaurantManagement.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @NotBlank(message = "Food name is required")
    private String foodName;

    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer quantity;

    @NotNull(message = "Availability is required")
    private Boolean isAvailable;

    @NotBlank(message = "Food type is required")
    private String foodType;

    @ManyToOne
    @JoinColumn(name = "Resurant_Id", referencedColumnName = "RestaurantId")
    private Restaurant restaurant;

    public Food() {
    }

    public Food(Integer foodId, String foodName, String description,
                String category, Double price, Integer quantity,
                Boolean isAvailable, String foodType, Restaurant restaurant) {

        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
        this.foodType = foodType;
        this.restaurant = restaurant;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Food [foodId=" + foodId
                + ", foodName=" + foodName
                + ", description=" + description
                + ", category=" + category
                + ", price=" + price
                + ", quantity=" + quantity
                + ", isAvailable=" + isAvailable
                + ", foodType=" + foodType + "]";
    }
}