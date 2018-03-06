package org.truenorth.restfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.restfood.deliveryapi.entity.MealEntity;

@RepositoryRestResource(collectionResourceRel = "meal", path = "meal")
public interface MealRepository extends CrudRepository<MealEntity, Long> {
}
