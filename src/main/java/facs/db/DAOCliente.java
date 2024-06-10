package facs.db;

import facs.eng.Cliente;
import facs.eng.Contrato;
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
        return DbSelecaoCliente.selecionarCliente(cpfOuCnpj, this.connection).get(0).formatoOriginal();
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

    public void atualizar(int op, PessoaFisica pessoaFisica, String novoValor) {
        if (pessoaFisica != null) {
            atualizar(op, new AdaptadorCliente(pessoaFisica), novoValor);
        }
    }

    public void atualizar(int op, PessoaJuridica pessoaJuridica, String novoValor) {
        if (pessoaJuridica != null) {
            atualizar(op, new AdaptadorCliente(pessoaJuridica), novoValor);
        }
    }

    public void atualizar(int op, AdaptadorCliente adaptadorCliente, String novoValor) {
        switch (op) {
            case 1:
                DbAtualizacaoCliente.atualizarCpf(adaptadorCliente, novoValor, this.connection);
                break;
            case 2:
                DbAtualizacaoCliente.atualizarNome(adaptadorCliente, novoValor, this.connection);
                break;
            case 3:
                DbAtualizacaoCliente.atualizarNomeDoResponsavel(adaptadorCliente, novoValor, this.connection);
                break;
            case 4:
                DbAtualizacaoCliente.atualizarEndereco(adaptadorCliente, novoValor, this.connection);
                break;
            case 5:
                DbAtualizacaoCliente.atualizarTelefone(adaptadorCliente, novoValor, this.connection);
                break;
            default:
                System.out.println("DEBUG: opção inválida.");
        }
    }
}
