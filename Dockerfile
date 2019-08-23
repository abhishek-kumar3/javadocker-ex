FROM openjdk:8

ADD spring-docker-ex-*.jar docker-demo.jar

EXPOSE 8080

CMD ["java","-jar","docker-demo.jar"]
