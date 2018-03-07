# rest-food
Restaurant delivery system

Description
Rest API for restaurant/delivery

Architecture
delivery-api: Expose Rest API, process calls and persist entities. Notifications are send as json to a kafka topic to be processed by message-system.
message-system: Process notifications to restaurants and customers. Consumes json notifications from kafka topic
common-library: Common classes used for communication purpose between modules

To do List
+Add security to delivery-api
+Implements SMS service, now is mocked
+Integration Tests
+More Unit Test coverage

Requirements
+java 8
+maven
+git
+kafka: the system needs to send and consume messages from a kafka topic
+email account with smtp service: notification are send to restaurant by email
+postman (with V2.1 import cappabilities)

How To
Install and run kafka (if you already have one skip this): https://kafka.apache.org/
Clone repo: 'git clone git@github.com:mmassigoge/rest-food.git'
Install common-library:
	move to module folder
	install: mvn clean install
	
Configure, package and run delivery-api
	move to module folder
	configure src\main\resources\application.properties (default should be ok)
	package: mvn clean package
	run: mvn spring-boot:run
	
Configure, package and run notification-service
	move to module folder
	configure src\main\resources\application.properties
		email: current config is prepared for an gmail email account, you should provide a gmail address without 2-Step Verification
	package: mvn clean package
	run: mvn spring-boot:run

Open Postman and import collections:
	import TrueNorth Example.postman_collection.json located at repo root
	update restaurant email on step 3
	execute in the exact specified order from 1 to 10
	Optional: you can import "TrueNorth.postman_collection.json" with more calls, please check after some POST and DELETE if ids are still available or need to be updated
	