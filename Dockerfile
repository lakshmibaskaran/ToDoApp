FROM openjdk:19
ARG JAR_FILE=*.war
COPY ./target/ToDoApp-0.0.1-SNAPSHOT.war ToDoApp-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "ToDoApp-0.0.1-SNAPSHOT.war"]