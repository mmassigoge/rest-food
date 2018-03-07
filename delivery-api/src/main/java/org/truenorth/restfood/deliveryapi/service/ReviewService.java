package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.dto.ReviewDTO;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;

/**
 * Review Service for Restaurant Review processing from customers
 */
public interface ReviewService {

    /**
     * Process a customer review for a restaurant
     * @param restaurantId
     * @param review
     * @return
     * @throws ReviewServiceException
     */
    ReviewDTO doReview(long restaurantId, ReviewDTO review) throws ReviewServiceException;
}
