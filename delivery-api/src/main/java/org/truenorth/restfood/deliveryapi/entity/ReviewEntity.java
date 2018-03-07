package org.truenorth.restfood.deliveryapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.truenorth.restfood.deliveryapi.dto.ReviewDTO;

import javax.persistence.*;

@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String review;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double rating;
    @ManyToOne(optional = false)
    private RestaurantEntity restaurant;

    public ReviewEntity() {
    }

    public ReviewEntity(ReviewDTO reviewDto) {
        this();
        this.name = reviewDto.getName();
        this.review = reviewDto.getReview();
        this.rating = reviewDto.getRating();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
}
