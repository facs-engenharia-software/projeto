package facs.eng;

public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String responsavel;

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String responsavel){
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.responsavel = responsavel;
    }

    @Override
    public String getIdReceitaFederal() {
        return this.cnpj;
    }

    @Override
    public void setIdReceitaFederal(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
