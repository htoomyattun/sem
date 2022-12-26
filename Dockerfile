FROM openjdk:latest
COPY ./target/seMethods-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-jar-with-dependencies.jar"]