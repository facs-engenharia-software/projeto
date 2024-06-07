package facs.eng;

import java.util.Date;

public class Prazo {

    private static long idPrazo;
    private String descricao;
    private Date dataVencimento;

    public Prazo(String descricao, Date dataVencimento) {
        Prazo.idPrazo = idPrazo++;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
    }

    public long getIdPrazo() {
        return this.idPrazo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }
}
