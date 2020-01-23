# build from the Maven image
# which has a maven environment configured already
FROM maven:latest

# copy our application in
COPY . /EventBookingSystem

# change the working directory to where we are building
# the application
WORKDIR /EventBookingSystem

# use maven to build the application
RUN mvn clean package

# create a new build stage from the Java image
# which has java installed already
FROM openjdk:8-jdk-alpine

# change the working directory to where the application
# is going to be installed
WORKDIR /EventBookingSystem

# copy the JAR file that was created in the previous
# build stage to the application folder in this build stage
COPY --from=0 /EventBookingSystem/target/*.jar app.jar

# create an entrypoint to run the application
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
