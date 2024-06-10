package facs.db;

import facs.eng.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoCliente {

    DbAtualizacaoCliente() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarCpf(Cliente cliente, String novoValor, Connection connection) {
        atualizar(cliente.getCpfOuCnpjDoCliente(), novoValor, connection, "UPDATE clientes SET cpf_cnpj_do_cliente = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarNome(Cliente cliente, String novoValor, Connection connection) {
        atualizar(cliente.getCpfOuCnpjDoCliente(), novoValor, connection, "UPDATE clientes SET nome = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarNomeDoResponsavel(Cliente cliente, String novoValor, Connection connection) {
        atualizar(cliente.getCpfOuCnpjDoCliente(), novoValor, connection, "UPDATE clientes SET nome_do_responsavel = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarEndereco(Cliente cliente, String novoValor, Connection connection) {
        atualizar(cliente.getCpfOuCnpjDoCliente(), novoValor, connection, "UPDATE clientes SET endereco = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarTelefone(Cliente cliente, String novoValor, Connection connection) {
        atualizar(cliente.getCpfOuCnpjDoCliente(), novoValor, connection, "UPDATE clientes SET telefone = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    private static void atualizar(String chave, String novoValor, Connection connection, String query) {
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, novoValor);
            pstmt.setString(2, chave);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
