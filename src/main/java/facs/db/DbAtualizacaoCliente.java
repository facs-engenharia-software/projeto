package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoCliente {

    DbAtualizacaoCliente() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarCpf(String cpf, String novoValor, Connection connection) {
        atualizar(cpf, novoValor, connection, "UPDATE clientes SET cpf_cnpj_do_cliente = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarNome(String cpf, String novoValor, Connection connection) {
        atualizar(cpf, novoValor, connection, "UPDATE clientes SET nome = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarNomeDoResponsavel(String cpf, String novoValor, Connection connection) {
        atualizar(cpf, novoValor, connection, "UPDATE clientes SET nome_do_responsavel = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarEndereco(String cpf, String novoValor, Connection connection) {
        atualizar(cpf, novoValor, connection, "UPDATE clientes SET endereco = ? WHERE cpf_cnpj_do_cliente = ?");
    }

    static void atualizarTelefone(String cpf, String novoValor, Connection connection) {
        atualizar(cpf, novoValor, connection, "UPDATE clientes SET telefone = ? WHERE cpf_cnpj_do_cliente = ?");
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
