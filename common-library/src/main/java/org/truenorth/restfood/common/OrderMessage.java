package org.truenorth.restfood.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Common order message object for Orders
 */
public class OrderMessage {
    private Long id;
    private RestaurantMessage restaurant;
    private List<MealMessage> meals = new ArrayList<>();
    private double totalCost;
    private String address;
    private double latitud;
    private double longitud;
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantMessage getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantMessage restaurant) {
        this.restaurant = restaurant;
    }

    public List<MealMessage> getMeals() {
        return meals;
    }

    public void setMeals(List<MealMessage> meals) {
        this.meals = meals;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
