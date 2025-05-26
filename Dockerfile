FROM openjdk:17-jdk

ADD https://dtdg.co/latest-java-tracer dd-java-agent.jar

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar" ,"-jar", "app.jar"]