FROM openjdk:17-jdk-slim
WORKDIR /app
COPY SupermarketSystem.jar /app/SupermarketSystem.jar
ENTRYPOINT ["java", "-jar", "SupermarketSystem.jar"]