FROM openjdk:8
COPY ./target/catalog-0.0.1-SNAPSHOT.war catalog-0.0.1-SNAPSHOT.war
CMD ["java","-jar","catalog-0.0.1-SNAPSHOT.war"]