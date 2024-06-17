package facs.db;

import facs.eng.Cliente;
import facs.eng.PessoaFisica;
import facs.eng.PessoaJuridica;

import java.sql.Connection;
import java.util.ArrayList;

public class DAOCliente {
    Connection connection;

    private DAOCliente(Connection connection) {
        this.connection = connection;
    }

    public static DAOCliente criarDAO(Connection connection) {
        if (connection == null) {
            return null;
        }
        return new DAOCliente(connection);
    }

    public Cliente selecionar(String cpfOuCnpj) {
        try {
            return DbSelecaoCliente.selecionarCliente(cpfOuCnpj, this.connection).get(0).formatoOriginal();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public ArrayList<Cliente> selecionarTodos(String cpfOuCnpj) {
        ArrayList<Cliente> resultado = new ArrayList<>();
        for (AdaptadorCliente adaptadorCliente : DbSelecaoCliente.selecionarCliente(cpfOuCnpj, this.connection)) {
            resultado.add(adaptadorCliente.formatoOriginal());
        }
        return resultado;
    }

    public void inserir(PessoaFisica pessoaFisica) {
        if (pessoaFisica != null) {
            inserir(new AdaptadorCliente(pessoaFisica));
        }
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        if (pessoaJuridica != null) {
            inserir(new AdaptadorCliente(pessoaJuridica));
        }
    }

    public void inserir(AdaptadorCliente adaptadorCliente) {
        DbInsercaoCliente.inserirCliente(adaptadorCliente, this.connection);
    }

    public void deletar(PessoaFisica pessoaFisica) {
        if (pessoaFisica != null) {
            deletar(new AdaptadorCliente(pessoaFisica));
        }
    }

    public void deletar(PessoaJuridica pessoaJuridica) {
        if (pessoaJuridica != null) {
            deletar(new AdaptadorCliente(pessoaJuridica));
        }
    }

    public void deletar(AdaptadorCliente adaptadorCliente) {
        DbDelecaoCliente.deletarCliente(adaptadorCliente, this.connection);
    }

    public void atualizar(int op, String cpf, String novoValor) {
        switch (op) {
            case 0:
                DbAtualizacaoCliente.atualizarCpf(cpf, novoValor, this.connection);
                break;
            case 1:
                DbAtualizacaoCliente.atualizarNome(cpf, novoValor, this.connection);
                break;
            case 2:
                DbAtualizacaoCliente.atualizarEndereco(cpf, novoValor, this.connection);
                break;
            case 3:
                DbAtualizacaoCliente.atualizarTelefone(cpf, novoValor, this.connection);
                break;
            case 4:
                DbAtualizacaoCliente.atualizarNomeDoResponsavel(cpf, novoValor, this.connection);
                break;
            default:
                System.out.println("DEBUG: opção inválida.");
        }
    }
}
