package facs.db;

import facs.eng.Contrato;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.lang.Long.parseLong;

public class AdaptadorContrato {

    private String numeroDoContrato;
    private String tipoDeContrato;
    private LocalDate dataDeCelebracao;
    private String validade;
    private String statusDoContrato;
    private String cpfOuCnpjDoCliente;

    public AdaptadorContrato(String numeroDoContrato, String tipoDeContrato, LocalDate dataDeCelebracao, String validade, String statusDoContrato, String cpfOuCnpjDoCliente) {
        this.numeroDoContrato = numeroDoContrato;
        this.tipoDeContrato = tipoDeContrato;
        this.dataDeCelebracao = dataDeCelebracao;
        this.validade = validade;
        this.statusDoContrato = statusDoContrato;
        this.cpfOuCnpjDoCliente = cpfOuCnpjDoCliente;
    }

    public AdaptadorContrato(Contrato contrato) {
        this.numeroDoContrato = Long.toString(contrato.getIdContrato());
        this.tipoDeContrato = contrato.getTipoContrato();
        this.dataDeCelebracao = Instant.ofEpochMilli(contrato.getDataCelebracao().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        this.validade = contrato.getValidade();
        this.statusDoContrato = contrato.getValidade();
    }

    public Contrato formatoOriginal() {
        return new Contrato(
                parseLong(this.numeroDoContrato),
                this.tipoDeContrato,
                Date.from(this.dataDeCelebracao.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                this.validade,
                this.statusDoContrato
        );
    }

    public String getNumeroDoContrato() {
        return numeroDoContrato;
    }

    public String getTipoDeContrato() {
        return tipoDeContrato;
    }

    public LocalDate getDataDeCelebracao() {
        return dataDeCelebracao;
    }

    public String getValidade() {
        return validade;
    }

    public String getStatusDoContrato() {
        return statusDoContrato;
    }

    public String getCpfOuCnpjDoCliente() {
        return cpfOuCnpjDoCliente;
    }

    public void setNumeroDoContrato(String numeroDoContrato) {
        this.numeroDoContrato = numeroDoContrato;
    }

    public void setTipoDeContrato(String tipoDeContrato) {
        this.tipoDeContrato = tipoDeContrato;
    }

    public void setDataDeCelebracao(LocalDate dataDeCelebracao) {
        this.dataDeCelebracao = dataDeCelebracao;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setStatusDoContrato(String statusDoContrato) {
        this.statusDoContrato = statusDoContrato;
    }

    public void setCpfOuCnpjDoCliente(String cpfOuCnpjDoCliente) {
        this.cpfOuCnpjDoCliente = cpfOuCnpjDoCliente;
    }
}
