package facs.eng;

public class PessoaFisica extends Cliente{

    private String cpf;

    public PessoaFisica(String nome, String endereco, String telefone, String cpf){
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    @Override
    public String getIdReceitaFederal() {
        return this.cpf;
    }

    @Override
    public void setIdReceitaFederal(String cpf) {
        this.cpf = cpf;
    }
}
