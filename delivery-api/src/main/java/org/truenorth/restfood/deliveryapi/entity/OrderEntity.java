package org.truenorth.restfood.deliveryapi.entity;

import org.truenorth.restfood.deliveryapi.service.OrderDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false)
    private RestaurantEntity restaurant;
    @ManyToMany
    private List<MealEntity> meals = new ArrayList<>();
    private double totalCost;
    private String address;
    private double latitud;
    private double longitud;

    public OrderEntity(){}

    public OrderEntity(OrderDTO orderDTO){
        this.latitud = orderDTO.getLatitud();
        this.longitud = orderDTO.getLongitud();
        this.address = orderDTO.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    public List<MealEntity> getMeals() {
        return meals;
    }

    public void setMeals(List<MealEntity> meals) {
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
}
