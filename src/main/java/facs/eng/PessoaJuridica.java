package facs.eng;

public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String responsavel;

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String responsavel){
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.responsavel = responsavel;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
