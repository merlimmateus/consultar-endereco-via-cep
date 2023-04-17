FROM openjdk:11

ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk

WORKDIR /app

COPY target/cep-frete-service-0.0.1-SNAPSHOT.jar /app/cepfreteservice.jar

EXPOSE 8080

CMD ["java", "-jar", "cepfreteservice.jar"]