    #docker build frontend/ -t frontend/java
    #docker image build --file ./app-beneficiario.Dockerfile .
#FROM openjdk:11-jdk-alpine
FROM adoptopenjdk/openjdk11:latest
ENV TZ America/Sao_Paulo
RUN mkdir -p /home/brasilprev/beneficiario
COPY ./beneficiario/beneficiario-1.0.0.jar /home/brasilprev/beneficiario
WORKDIR /home/brasilprev/beneficiario
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","beneficiario-1.0.0.jar"]