FROM openjdk:21-jdk-bookworm
ARG JAR_FILE=out/artifacts/api_spring_book/*.jar
COPY ./out/artifacts/api_spring_book_jar/api_spring_book.jar app.jar
LABEL authors="satoshimitsumori"
ENTRYPOINT ["java", "-jar", "/app.jar"]