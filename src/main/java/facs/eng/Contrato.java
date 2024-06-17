package facs.eng;

import java.util.Date;

public class Contrato {

    private long idContrato;
    private String tipoContrato;
    private Date dataCelebracao;
    private String validade;
    private String status;
    private String cpfCnpjCliente;

    public Contrato(long idContrato, String tipoContrato, Date dataCelebracao, String validade, String status) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.dataCelebracao = dataCelebracao;
        this.validade = validade;
        this.status = status;
        this.cpfCnpjCliente = null;
    }

    public Contrato(long idContrato, String tipoContrato, Date dataCelebracao, String validade, String status, String cpfCnpjCliente) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.dataCelebracao = dataCelebracao;
        this.validade = validade;
        this.status = status;
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public long getIdContrato() {
        return this.idContrato;
    }

    public String getTipoContrato() {
        return this.tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        String exito = "Êxito";
        String mensal = "Mensal fixo";
        String fixo = "Inicial fixo";
        String parcelado = "Parcelado por etapa";

        switch (tipoContrato.toLowerCase()){
            case "êxito":
                this.tipoContrato = exito;
            case "exito":
                this.tipoContrato = exito;
            case "mensal":
                this.tipoContrato = mensal;
            case "mensal fixo":
                this.tipoContrato = mensal;
            case "fixo":
                 this.tipoContrato = fixo;
            case "parcelado":
                this.tipoContrato = parcelado;
            case "parcelado por etapa":
                this.tipoContrato = parcelado;
            case "parcelado etapas":
                this.tipoContrato = parcelado;
            case "misto":
                this.tipoContrato = "Misto";
            default:
                throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
        }
    }

    public Date getDataCelebracao() {
        return this.dataCelebracao;
    }

    public void setDataCelebracao(Date dataCelebracao) {
        this.dataCelebracao = dataCelebracao;
    }

    public String getValidade() {
        return this.validade;
    }

    public void setValidade(String validade) {
        if(validade.equalsIgnoreCase("definida")){
            this.validade = validade;
        } else if (validade.equalsIgnoreCase("indefinida")) {
            this.validade = validade;
        } else throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        String valido = "Válido";
        String vencido = "Vencido";
        String rescindido = "Rescindido";

        switch (status.toLowerCase()){
            case "valido":
                this.status = valido;
            case "válido":
                this.status = valido;
            case "vencido":
                this.status = vencido;
            case "rescindido":
                this.status = rescindido;
            default:
                throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
        }

    }

    public String getCpfCnpjCliente() {
        return this.cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

}
