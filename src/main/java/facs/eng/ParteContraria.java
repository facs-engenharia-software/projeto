package facs.eng;

public class ParteContraria {

    private String numProcesso;
    private String nome;
    private String cpfCnpj;

    public ParteContraria(String numProcesso, String nome, String cpfCnpj) {
        this.numProcesso = numProcesso;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
