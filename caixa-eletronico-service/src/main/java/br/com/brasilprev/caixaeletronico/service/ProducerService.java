package br.com.brasilprev.caixaeletronico.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class ProducerService {
    private static final Logger log = LoggerFactory.getLogger(ProducerService.class);

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(String message){
        log.info("Tópico: {}", topicName);
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
