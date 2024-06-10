package facs.db;

import facs.eng.Cliente;

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
        return DbSelecaoCliente.selecionarCliente(cpfOuCnpj, this.connection).get(0);
    }

    public ArrayList<Cliente> selecionarTodos(String cpfOuCnpj) {
        return DbSelecaoCliente.selecionarCliente(cpfOuCnpj, this.connection);
    }

    public void inserir(Cliente cliente) {
        if (cliente != null) {
            DbInsercaoCliente.inserirCliente(cliente, this.connection);
        }
    }

    public void deletar(Cliente cliente) {
        if (cliente != null) {
            DbDelecaoCliente.deletarCliente(cliente, this.connection);
        }
    }

    public void atualizar(int op, Cliente cliente, String novoValor) {
        if (cliente != null) {
            switch (op) {
                case 1:
                    DbAtualizacaoCliente.atualizarCpf(cliente, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoCliente.atualizarNome(cliente, novoValor, this.connection);
                    break;
                case 3:
                    DbAtualizacaoCliente.atualizarNomeDoResponsavel(cliente, novoValor, this.connection);
                    break;
                case 4:
                    DbAtualizacaoCliente.atualizarEndereco(cliente, novoValor, this.connection);
                    break;
                case 5:
                    DbAtualizacaoCliente.atualizarTelefone(cliente, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
