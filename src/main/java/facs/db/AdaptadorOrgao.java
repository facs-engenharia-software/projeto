package facs.db;

import facs.eng.Orgao;

import static java.lang.Long.parseLong;

public class AdaptadorOrgao {

    private String idOrgao;
    private String nome;
    private String vinculacaoSuperior;

    public AdaptadorOrgao(String idOrgao, String nome, String vinculacaoSuperior) {
        this.idOrgao = idOrgao;
        this.nome = nome;
        this.vinculacaoSuperior = vinculacaoSuperior;
    }

    public AdaptadorOrgao(Orgao orgao) {
        this.idOrgao = Long.toString(orgao.getIdOrgao());
        this.nome = orgao.getNome();
        this.vinculacaoSuperior = orgao.getVinculacaoSuperior();
    }

    public Orgao formatoOriginal() {
        return new Orgao(
                parseLong(this.idOrgao),
                this.nome,
                this.vinculacaoSuperior
        );
    }

    public String getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(String idOrgao) {
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
