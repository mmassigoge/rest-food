package org.truenorth.restfood.deliveryapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;
import org.truenorth.restfood.deliveryapi.service.ReviewService;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("restaurant/{restaurantId}/review")
    public ReviewEntity doReview(@PathVariable long restaurantId, @RequestBody ReviewEntity review) throws ReviewServiceException {
        return reviewService.doReview(restaurantId,review);
    }

}
