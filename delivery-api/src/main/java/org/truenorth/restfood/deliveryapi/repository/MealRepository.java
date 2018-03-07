package org.truenorth.restfood.deliveryapi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truenorth.restfood.deliveryapi.entity.MealEntity;

/**
 * Meals Repository that publish a REST interface
 */
@RepositoryRestResource(collectionResourceRel = "meal", path = "meal")
public interface MealRepository extends CrudRepository<MealEntity, Long> {
}
