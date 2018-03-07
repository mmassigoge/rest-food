package org.truenorth.restfood.deliveryapi.dto;

import javax.validation.constraints.NotNull;

public class ReviewDTO {

    @NotNull
    private String name;
    @NotNull
    private String review;
    @NotNull
    private double rating;

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
}
