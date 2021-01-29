package br.com.brasilprev.beneficiario.service;

import br.com.brasilprev.beneficiario.model.Beneficiario;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerBeneficiarioService {
    @Value("${topic.name.consumer")
    private String topicName;

    @Autowired
    BeneficiarioService beneficiarioService;

    private static final Logger log = LoggerFactory.getLogger(ConsumerBeneficiarioService.class);

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partição: {}", payload.partition());
        log.info("Valor: {}", payload.value());

        String[] split = payload.value().split("-");
        String cpf = split[0];
        double valor = Double.parseDouble(split[1]);
        int anos = Integer.parseInt(split[2]);
        beneficiarioService.atualizaValorAposentadoria(cpf, valor, anos);



    }
}
