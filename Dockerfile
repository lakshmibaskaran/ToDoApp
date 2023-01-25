FROM openjdk:19
ARG JAR_FILE=*.jar
COPY ./target/ToDoApp-0.0.1-SNAPSHOT.jar ToDoApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "ToDoApp-0.0.1-SNAPSHOT.jar"]