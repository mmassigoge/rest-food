package org.truenorth.restfood.deliveryapi;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;
import org.truenorth.restfood.deliveryapi.repository.RestaurantRepository;
import org.truenorth.restfood.deliveryapi.repository.ReviewRepository;
import org.truenorth.restfood.deliveryapi.service.ReviewServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceImplTest {

    @InjectMocks
    ReviewServiceImpl reviewService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Mock
    ReviewRepository reviewRepository;

    @Test(expected = ReviewServiceException.class)
    public void doReviewNull() throws ReviewServiceException {
        when(restaurantRepository.findOne(1l)).thenReturn(new RestaurantEntity());
        reviewService.doReview(1,null);
    }

    @Test(expected = ReviewServiceException.class)
    public void doReviewRestaurantNotFound() throws ReviewServiceException {
        when(restaurantRepository.findOne(1l)).thenReturn(null);
        reviewService.doReview(0,null);
    }


    @Test(expected = ReviewServiceException.class)
    public void doReviewInvalidReview() throws ReviewServiceException {
        when(restaurantRepository.findOne(1l)).thenReturn(new RestaurantEntity());
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setRating(6);
        reviewService.doReview(1,reviewEntity);
    }

    @Test(expected = ReviewServiceException.class)
    public void doReviewSuccess() throws ReviewServiceException {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        when(restaurantRepository.findOne(1l)).thenReturn(restaurantEntity);
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setRating(2.5f);
        reviewService.doReview(1,reviewEntity);
        assertEquals(2.5f,restaurantEntity.getRating(),0);
    }
}
