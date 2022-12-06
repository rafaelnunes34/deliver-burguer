FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/deliverlanches-0.0.1-SNAPSHOT.jar deliverlanches.jar
ENTRYPOINT ["java","-jar","/deliverlanches.jar"]