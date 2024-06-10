package facs.db;

import facs.eng.Processo;

import java.time.LocalDate;

public class AdaptadorProcesso {
    private String numeroDoProcesso;
    private String identificacaoDoOrgao;
    private String faseProcessual;
    private String naturezaDaDemanda;
    private String cpfCnpjDoCliente;
    private String posicaoDoCliente;
    private String registroDoAdvogado;
    private String statusDoProcesso;
    private LocalDate dataDeAjuizamento;
    private String numeroDoContrato;

    public AdaptadorProcesso(String numeroDoProcesso, String identificacaoDoOrgao, String faseProcessual,
                             String naturezaDaDemanda, String cpfCnpjDoCliente, String posicaoDoCliente,
                             String registroDoAdvogado, String statusDoProcesso, LocalDate dataDeAjuizamento,
                             String numeroDoContrato) {
        this.numeroDoProcesso = numeroDoProcesso;
        this.identificacaoDoOrgao = identificacaoDoOrgao;
        this.faseProcessual = faseProcessual;
        this.naturezaDaDemanda = naturezaDaDemanda;
        this.cpfCnpjDoCliente = cpfCnpjDoCliente;
        this.posicaoDoCliente = posicaoDoCliente;
        this.registroDoAdvogado = registroDoAdvogado;
        this.statusDoProcesso = statusDoProcesso;
        this.dataDeAjuizamento = dataDeAjuizamento;
        this.numeroDoContrato = numeroDoContrato;
    }

    public String getNumeroDoProcesso() {
        return numeroDoProcesso;
    }

    public void setNumeroDoProcesso(String numeroDoProcesso) {
        this.numeroDoProcesso = numeroDoProcesso;
    }

    public String getIdentificacaoDoOrgao() {
        return identificacaoDoOrgao;
    }

    public void setIdentificacaoDoOrgao(String identificacaoDoOrgao) {
        this.identificacaoDoOrgao = identificacaoDoOrgao;
    }

    public String getFaseProcessual() {
        return faseProcessual;
    }

    public void setFaseProcessual(String faseProcessual) {
        this.faseProcessual = faseProcessual;
    }

    public String getNaturezaDaDemanda() {
        return naturezaDaDemanda;
    }

    public void setNaturezaDaDemanda(String naturezaDaDemanda) {
        this.naturezaDaDemanda = naturezaDaDemanda;
    }

    public String getCpfCnpjDoCliente() {
        return cpfCnpjDoCliente;
    }

    public void setCpfCnpjDoCliente(String cpfCnpjDoCliente) {
        this.cpfCnpjDoCliente = cpfCnpjDoCliente;
    }

    public String getPosicaoDoCliente() {
        return posicaoDoCliente;
    }

    public void setPosicaoDoCliente(String posicaoDoCliente) {
        this.posicaoDoCliente = posicaoDoCliente;
    }

    public String getRegistroDoAdvogado() {
        return registroDoAdvogado;
    }

    public void setRegistroDoAdvogado(String registroDoAdvogado) {
        this.registroDoAdvogado = registroDoAdvogado;
    }

    public String getStatusDoProcesso() {
        return statusDoProcesso;
    }

    public void setStatusDoProcesso(String statusDoProcesso) {
        this.statusDoProcesso = statusDoProcesso;
    }

    public LocalDate getDataDeAjuizamento() {
        return dataDeAjuizamento;
    }

    public void setDataDeAjuizamento(LocalDate dataDeAjuizamento) {
        this.dataDeAjuizamento = dataDeAjuizamento;
    }

    public String getNumeroDoContrato() {
        return numeroDoContrato;
    }

    public void setNumeroDoContrato(String numeroDoContrato) {
        this.numeroDoContrato = numeroDoContrato;
    }
}
