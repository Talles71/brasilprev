package br.com.brasilprev.beneficiario.controller;

import br.com.brasilprev.beneficiario.model.Beneficiario;
import br.com.brasilprev.beneficiario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/beneficiario")
@RestController
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @CrossOrigin("*")
    @GetMapping("/consultar/{cpf}")
    @ResponseBody
    public ResponseEntity<Beneficiario> listarBeneficiario(@PathVariable String cpf){
        Beneficiario beneficiario = beneficiarioService.consultarBeneficiario(cpf);
        if(beneficiario == null){
            return new ResponseEntity<Beneficiario>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Beneficiario>(beneficiario, HttpStatus.OK);

    }

    @PutMapping("/cadastrar")
    @ResponseBody
    @CrossOrigin( origins = "*")
    public ResponseEntity<HashMap<String, String>> cadastrarBeneficiario(@RequestBody Beneficiario beneficiario){

        HashMap<String, String> response = new HashMap<>();

        try{
            beneficiarioService.cadastrarBeneficiario(beneficiario);
        } catch (Exception e){
            e.printStackTrace();
            response.put("codigo", "99");
            response.put("mensagem", "Ocorreu um erro ao tentar cadastrar o Beneficiário, tente novamente!");
            response.put("exception", e.getLocalizedMessage());
        }
        response.put("codigo", "0");
        response.put("mensagem", "Beneficiário " + beneficiario.getNome() + " cadastrado com sucesso !");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
