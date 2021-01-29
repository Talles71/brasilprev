package br.com.brasilprev.beneficiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BeneficiarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioServiceApplication.class, args);
	}

}
