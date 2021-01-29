package br.com.brasilprev.beneficiario.service;

import br.com.brasilprev.beneficiario.model.Beneficiario;
import br.com.brasilprev.beneficiario.repository.IBeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    IBeneficiarioRepository beneficiarioRepository;

    public void cadastrarBeneficiario(Beneficiario beneficiario){
        beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario consultarBeneficiario(String cpf){
        Optional<Beneficiario> resultado = beneficiarioRepository.findById(cpf);
        if(resultado.isPresent()){
            return resultado.get();
        } else {
            return null;
        }
    }

    public void atualizaValorAposentadoria(String cpf, double valor, int anos){
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(cpf);
        beneficiario.get().setValorTotalSaldoAposentadoria(valor);
        beneficiario.get().setQuantidadeAnosParaAposentadoria(anos);
        beneficiarioRepository.save(beneficiario.get());
    }
}
