# rest-food
Restaurant delivery system

## Description
Rest API for restaurant/delivery

## Architecture
+ delivery-api: Expose Rest API, process calls and persist entities. Notifications are send as json to a kafka topic to be processed by message-system.
+ message-system: Process notifications to restaurants and customers. Consumes json notifications from kafka topic
+ common-library: Common classes used for communication purpose between modules

## To do List
+ Add security to delivery-api
+ Implements SMS service, now is mocked
+ Integration Tests
+ Enhance Unit Test coverage

## Requirements
+ java 8
+ maven
+ git
+ kafka: the system needs to send and consume messages from a kafka topic
+ email account with smtp service: notification are send to restaurant by email
+ postman (with V2.1 import cappabilities)

## How To
1. Install and run kafka (if you already have one skip this): https://kafka.apache.org/
2. Clone repo: 'git clone git@github.com:mmassigoge/rest-food.git'
3. Install common-library:
   1. move to module folder
   2. install: mvn clean install
	
4. Configure, package and run delivery-api
   1. move to module folder
   2. configure src\main\resources\application.properties (default should be ok)
   3. package: mvn clean package
   4. run: mvn spring-boot:run
	
5. Configure, package and run notification-service
   1. move to module folder
   2. configure src\main\resources\application.properties
      - email: current config is prepared for gmail, you need to provide a gmail address without 2-Step Verification
   3. package: mvn clean package
   4. run: mvn spring-boot:run

6. Open Postman and import collections:
   1. import "TrueNorth Example.postman_collection.json" located at repo root
   2. update restaurant email on step 3
   3. execute in the exact specified order from 1 to 10
   4. Optional: you can import "TrueNorth.postman_collection.json" with more calls, please check after some POST and DELETE if ids are still available or need to be updated
