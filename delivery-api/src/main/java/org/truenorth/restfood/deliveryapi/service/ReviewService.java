package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;

public interface ReviewService {
    ReviewEntity doReview(long restaurantId, ReviewEntity review) throws ReviewServiceException;
}
