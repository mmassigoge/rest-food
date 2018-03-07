package org.truenorth.restfood.deliveryapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;

/**
 * Orders Repository
 */
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
