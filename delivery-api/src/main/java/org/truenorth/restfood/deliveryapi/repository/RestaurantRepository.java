package org.truenorth.restfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;

@RepositoryRestResource(collectionResourceRel = "restaurant", path = "restaurant")
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
}
