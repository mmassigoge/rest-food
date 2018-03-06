package org.truenorth.restfood.deliveryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;
import org.truenorth.restfood.deliveryapi.repository.RestaurantRepository;
import org.truenorth.restfood.deliveryapi.repository.ReviewRepository;

import java.util.OptionalDouble;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public ReviewEntity doReview(long restaurantId, ReviewEntity review) throws ReviewServiceException {
        RestaurantEntity restaurantEntity = restaurantRepository.findOne(restaurantId);
        if (restaurantEntity != null) {
            if (validateReview(review)) {
                try {
                    review.setRestaurant(restaurantEntity);
                    review = reviewRepository.save(review);
                    restaurantEntity.getReviews().add(review);
                    OptionalDouble optionalRating = restaurantEntity
                            .getReviews()
                            .stream()
                            .filter(reviewEntity -> 0 <= reviewEntity.getRating() && reviewEntity.getRating() <= 5)
                            .mapToDouble(reviewEntity -> reviewEntity.getRating())
                            .average();
                    restaurantEntity.setRating(optionalRating.orElse(0));
                } catch (Exception e) {
                    throw new ReviewServiceException("Review process failed " + e.getMessage(), e);
                }

            }
            restaurantRepository.save(restaurantEntity);
        } else {
            throw new ReviewServiceException("Restaurant not found with id: " + restaurantId);
        }
        return review;
    }

    private boolean validateReview(ReviewEntity review) throws ReviewServiceException {
        if(review!=null){
            if(0 <= review.getRating() && review.getRating() <= 5){
                return true;
            }else{
                throw new ReviewServiceException("Review rating should be a value between 0 and 5 but: " + review.getRating());
            }
        }else{
            throw new ReviewServiceException("Review is null or empty: " + review);
        }
    }
}
