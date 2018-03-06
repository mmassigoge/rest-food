package org.truenorth.resfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.resfood.deliveryapi.entity.RestaurantEntity;

@RepositoryRestResource(collectionResourceRel = "restaurant", path = "restaurant")
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
}
