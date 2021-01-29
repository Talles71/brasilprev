package br.com.brasilprev.caixaeletronico.controller;

import br.com.brasilprev.caixaeletronico.service.AporteService;
import br.com.brasilprev.caixaeletronico.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aporte")
public class AporteController {


    @Autowired
    AporteService aporteService;

    @CrossOrigin("*")
    @PostMapping("/efetuar/{cpf}&{valor}&{anos}")
    @ResponseBody
    public ResponseEntity<String> aportar(@PathVariable String cpf, @PathVariable String valor, @PathVariable String anos){

        String valorCalculado = aporteService.realizarAporte(cpf, valor, anos);

        return new ResponseEntity<>(valorCalculado, HttpStatus.OK);
    }
}
