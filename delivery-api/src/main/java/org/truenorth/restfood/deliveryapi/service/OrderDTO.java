package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.MealEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private long[] meals;
    private String address;
    private double latitud;
    private double longitud;

    public long[] getMeals() {
        return meals;
    }

    public void setMeals(long[] meals) {
        this.meals = meals;
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
