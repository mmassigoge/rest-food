package org.truenorth.resfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.resfood.deliveryapi.entity.MealEntity;
import org.truenorth.resfood.deliveryapi.entity.RestaurantEntity;

@RepositoryRestResource(collectionResourceRel = "meal", path = "meal")
public interface MealRepository extends CrudRepository<MealEntity, Long> {
}
