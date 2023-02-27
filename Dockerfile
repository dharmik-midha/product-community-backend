FROM openjdk:17
EXPOSE 8080
ADD target/pcf.jar pcf.jar
ENTRYPOINT ["java","-jar","/pcf.jar"]