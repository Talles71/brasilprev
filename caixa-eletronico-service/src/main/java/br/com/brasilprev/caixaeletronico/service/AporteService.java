package br.com.brasilprev.caixaeletronico.service;

import br.com.brasilprev.caixaeletronico.model.Aporte;
import br.com.brasilprev.caixaeletronico.repository.IAporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AporteService {


    @Autowired
    IAporteRepository aporteRepository;

    @Autowired
    ProducerService producerService;

    public String realizarAporte(String cpf, String valor, String anos){
        double valorAporteCalculado = 0;

        Optional<Aporte> aporte = aporteRepository.findById(cpf);
        if(aporte.isPresent()){
            try{

                int meses = Integer.parseInt(anos) * 12; //calcula a quantidade de meses dado o ano.
                valorAporteCalculado = Double.parseDouble(valor) / meses; //converte String para double e calcula (valorSaldo / quantidade de meses)
                valorAporteCalculado = Math.round(valorAporteCalculado * 100.0) / 100.0; //arredonda com 2 casas decimais
                aporte.get().setValorAposentadoria(valorAporteCalculado);
                aporteRepository.save(aporte.get());
            } catch (Exception e){
                e.printStackTrace();
            }
        } else  {
            aporteRepository.save(new Aporte(cpf, valorAporteCalculado));
        }

        //Se comunica com o microserviço de beneficiário
        producerService.send(cpf + "-" + valorAporteCalculado + "-" + anos);

        return String.valueOf(valorAporteCalculado);
    }
}
