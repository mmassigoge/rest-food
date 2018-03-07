package org.truenorth.restfood.deliveryapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Delivery API Application
 * Provides REST api for delivery services
 */
@SpringBootApplication
public class DeliveryApiApp {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApiApp.class, args);
    }
}
