package br.com.brasilprev.caixaeletronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CaixaEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaEletronicoApplication.class, args);
	}

}
