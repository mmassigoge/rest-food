package org.truenorth.restfood.deliveryapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.truenorth.restfood.deliveryapi.dto.ReviewDTO;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;
import org.truenorth.restfood.deliveryapi.service.ReviewService;

import javax.validation.Valid;

/**
 * REST Controller that process reviews
 */
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /**
     * Process a review for a restaurant
     * @param restaurantId
     * @param review
     * @return
     * @throws ReviewServiceException
     */
    @PostMapping("restaurant/{restaurantId}/review")
    public ReviewDTO doReview(@PathVariable long restaurantId, @Valid @RequestBody ReviewDTO review) throws ReviewServiceException {
        return reviewService.doReview(restaurantId,review);
    }

}
