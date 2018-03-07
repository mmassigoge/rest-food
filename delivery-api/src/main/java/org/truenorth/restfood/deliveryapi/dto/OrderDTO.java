package org.truenorth.restfood.deliveryapi.dto;

import org.truenorth.restfood.deliveryapi.entity.MealEntity;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Order DTO
 */
public class OrderDTO {
    /**
     * Expect a list of meals ids
     */
    @NotNull
    private long[] meals;
    @NotNull
    private String address;
    @NotNull
    private double latitud;
    @NotNull
    private double longitud;
    @NotNull
    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
