package facs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoContrato {

    private DbAtualizacaoContrato() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarNumeroDoContrato(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, novoValor, connection, "UPDATE contratos SET numero_do_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarTipoDeContrato(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, novoValor, connection, "UPDATE contratos SET tipo_de_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarDataDeCelebracao(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, Date.valueOf(novoValor), connection, "UPDATE contratos SET data_de_celebracao = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarValidade(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, novoValor, connection, "UPDATE contratos SET validade = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarStatusDoContrato(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, novoValor, connection, "UPDATE contratos SET status_do_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarCpfCnpjDoCliente(String numeroDoContrato, String novoValor, Connection connection) {
        atualizar(numeroDoContrato, novoValor, connection, "UPDATE contratos SET cpf_cnpj_do_cliente = ? WHERE numero_do_contrato = ?");
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

    private static void atualizar(String chave, Date novoValor, Connection connection, String query) {
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, novoValor);
            pstmt.setString(2, chave);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
