FROM alpine:3.15
RUN apk add --no-cache openjdk17
COPY build/libs/ingress-0.0.1.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/ingress-0.0.1.jar"]
