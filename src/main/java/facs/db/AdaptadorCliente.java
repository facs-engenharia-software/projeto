package facs.db;

import facs.eng.Cliente;
import facs.eng.PessoaFisica;
import facs.eng.PessoaJuridica;

public class AdaptadorCliente {
    private String cpfOuCnpjDoCliente;
    private String nome;
    private String nomeDoResponsavel;
    private String endereco;
    private String telefone;

    public AdaptadorCliente(String cpfOuCnpjDoCliente, String nome, String endereco, String telefone) {
        this.cpfOuCnpjDoCliente = cpfOuCnpjDoCliente;
        this.nome = nome;
        this.nomeDoResponsavel = null;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public AdaptadorCliente(String cpfOuCnpjDoCliente, String nome, String nomeDoResponsavel, String endereco, String telefone) {
        this.cpfOuCnpjDoCliente = cpfOuCnpjDoCliente;
        this.nome = nome;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public AdaptadorCliente(PessoaFisica pessoaFisica) {
        this.cpfOuCnpjDoCliente = pessoaFisica.getCpf();
        this.nome = pessoaFisica.getNome();
        this.nomeDoResponsavel = null;
        this.endereco = pessoaFisica.getEndereco();
        this.telefone = pessoaFisica.getTelefone();
    }

    public AdaptadorCliente(PessoaJuridica pessoaJuridica) {
        this.cpfOuCnpjDoCliente = pessoaJuridica.getCnpj();
        this.nome = pessoaJuridica.getNome();
        this.nomeDoResponsavel = pessoaJuridica.getResponsavel();
        this.endereco = pessoaJuridica.getEndereco();
        this.telefone = pessoaJuridica.getTelefone();
    }

    public Cliente formatoOriginal() {
        if (this.nomeDoResponsavel == null) {
            return new PessoaFisica(
                    this.nome,
                    this.endereco,
                    this.telefone,
                    this.cpfOuCnpjDoCliente
            );
        }
        return new PessoaJuridica(
                this.nome,
                this.endereco,
                this.telefone,
                this.cpfOuCnpjDoCliente,
                this.nomeDoResponsavel
        );
    }

    public String getCpfOuCnpjDoCliente() {
        return cpfOuCnpjDoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCpfOuCnpjDoCliente(String cpfOuCnpjDoCliente) {
        this.cpfOuCnpjDoCliente = cpfOuCnpjDoCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
