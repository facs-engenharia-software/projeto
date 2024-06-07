package facs.eng;

public class Orgao {

    private String nome;
    private String vinculacaoSuperior;

    public Orgao(String nome, String vinculacaoSuperior) {
        this.nome = nome;
        this.vinculacaoSuperior = vinculacaoSuperior;
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
