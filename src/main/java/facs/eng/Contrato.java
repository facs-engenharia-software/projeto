package facs.eng;

import java.util.Date;

public class Contrato {

    private long idContrato;
    private String tipoContrato;
    private Date dataCelebracao;
    private Date dataValidade;
    private String status;

    private Contrato() {}

    public Contrato(long idContrato, String tipoContrato, Date dataCelebracao, Date dataValidade, String status) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.dataCelebracao = dataCelebracao;
        this.dataValidade = dataValidade;
        this.status = status;
    }

    public long getIdContrato() {
        return this.idContrato;
    }

    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }

    public String getTipoContrato() {
        return this.tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getDataCelebracao() {
        return this.dataCelebracao;
    }

    public void setDataCelebracao(Date dataCelebracao) {
        this.dataCelebracao = dataCelebracao;
    }

    public Date getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
