package facs.eng;

public class Orgao {

    private long idOrgao;
    private String nome;
    private String vinculacaoSuperior;

    public Orgao(long idOrgao, String nome, String vinculacaoSuperior) {
        this.idOrgao = idOrgao;
        this.nome = nome;
        this.vinculacaoSuperior = vinculacaoSuperior;
    }

    public long getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(long idOrgao) {
        this.idOrgao = idOrgao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVinculacaoSuperior() {
        return this.vinculacaoSuperior;
    }

    public void setVinculacaoSuperior(String vinculacaoSuperior) {
        this.vinculacaoSuperior = vinculacaoSuperior;
    }

}
