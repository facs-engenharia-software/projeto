package facs.eng;

import java.util.Date;

public class Andamento {

    private final long idAndamento;
    private Date data;
    private String descricao;

    public Andamento(long idAndamento, String descricao) {
        this.idAndamento = idAndamento;
        this.data = new Date();
        this.descricao = descricao;
    }

    public long getIdAndamento() {
        return this.idAndamento;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
