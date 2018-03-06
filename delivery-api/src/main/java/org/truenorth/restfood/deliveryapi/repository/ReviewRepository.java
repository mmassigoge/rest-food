package org.truenorth.restfood.deliveryapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;

public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
}
