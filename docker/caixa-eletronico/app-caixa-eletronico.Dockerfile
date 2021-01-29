    #docker build frontend/ -t frontend/java
    #docker image build --file ./app-caixa-eletronico.Dockerfile .
#FROM openjdk:11-jdk-alpine
FROM adoptopenjdk/openjdk11:latest
ENV TZ America/Sao_Paulo
RUN mkdir -p /home/brasilprev/caixa-eletronico
COPY ./caixa-eletronico/caixa-eletronico-1.0.0.jar /home/brasilprev/caixa-eletronico
WORKDIR /home/brasilprev/caixa-eletronico
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","caixa-eletronico-1.0.0.jar"]