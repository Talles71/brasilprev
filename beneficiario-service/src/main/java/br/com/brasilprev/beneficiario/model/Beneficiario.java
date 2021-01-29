package br.com.brasilprev.beneficiario.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficiario {

    private String nome;
    @Id
    private String cpf;
    private String email;
    private double valorTotalSaldoAposentadoria;
    private int quantidadeAnosParaAposentadoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValorTotalSaldoAposentadoria() {
        return valorTotalSaldoAposentadoria;
    }

    public void setValorTotalSaldoAposentadoria(double valorTotalSaldoAposentadoria) {
        this.valorTotalSaldoAposentadoria = valorTotalSaldoAposentadoria;
    }

    public int getQuantidadeAnosParaAposentadoria() {
        return quantidadeAnosParaAposentadoria;
    }

    public void setQuantidadeAnosParaAposentadoria(int quantidadeAnosParaAposentadoria) {
        this.quantidadeAnosParaAposentadoria = quantidadeAnosParaAposentadoria;
    }
}
