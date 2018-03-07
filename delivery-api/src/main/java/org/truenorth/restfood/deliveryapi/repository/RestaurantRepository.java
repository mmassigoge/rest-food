package org.truenorth.restfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;

import java.util.List;


/**
 * Restaurants Repository that publish a REST interface
 */
@RepositoryRestResource(collectionResourceRel = "restaurant", path = "restaurant")
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findByRatingGreaterThanEqual(@Param("rating") double rating);
}
