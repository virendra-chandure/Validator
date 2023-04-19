# Introduction

Validator application which checks the following rules:
1. If topic == A, then name will be “a”and description will be more than 10 and less than 100 chars
2. If topic == B, then name will be “x” and description will be less than 40 chars

Note: Youc can add more topics D, E, F … In the future and combinations of validation rules on name and description in TopicValidator.java

**Sample implementation:** This is a sample GITB-compliant validation service that validates a provided text against 
an (also provided) expected value. The user of the service can also select whether he/she wants to have a mismatch 
reported as an error or a warning. Finally, an information message is also returned in case values match but when 
ignoring casing.

The service is implemented in Java, using the [Spring Boot framework](https://spring.io/projects/spring-boot). It is 
built and packaged using [Apache Maven](https://maven.apache.org/).

# Prerequisites

The following prerequisites are required:
* To build: JDK 14+, Maven 3.2+.
* To run: JRE 14+.

# Building and running

1. Build using `mvn clean install`.
2. Once built you can run the Application.java
