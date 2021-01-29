package br.com.brasilprev.caixaeletronico.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aporte {

    public Aporte() {
    }

    public Aporte(String cpf, double valorAposentadoria) {
        this.cpf = cpf;
        this.valorAposentadoria = valorAposentadoria;
    }

    @Id
    private String cpf;
    private double valorAposentadoria;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorAposentadoria() {
        return valorAposentadoria;
    }

    public void setValorAposentadoria(double valorAposentadoria) {
        this.valorAposentadoria = valorAposentadoria;
    }
}
