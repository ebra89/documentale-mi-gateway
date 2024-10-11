FROM openjdk:17-alpine
EXPOSE 8080
RUN apk add --no-cache bash && apk --no-cache add curl
RUN addgroup -g 2000 -S spring && adduser -G spring -S -u 2000 spring
RUN mkdir -p /var/log/gateway/ && mkdir -p /usr/local/gateway && chown spring:spring /var/log/gateway/
COPY /target/*.jar /usr/local/gateway/application.jar
WORKDIR /usr/local/gateway
USER spring:spring
ENTRYPOINT ["java", "-jar", "application.jar"]