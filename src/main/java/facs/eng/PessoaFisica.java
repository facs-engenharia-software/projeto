package facs.eng;

public class PessoaFisica extends Cliente{

    private String cpf;

    protected PessoaFisica(String nome, String endereco, String telefone, String cpf){
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
