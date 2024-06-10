package facs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoContrato {

    private DbAtualizacaoContrato() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarNumeroDoContrato(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), novoValor, connection, "UPDATE contratos SET numero_do_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarTipoDeContrato(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), novoValor, connection, "UPDATE contratos SET tipo_de_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarDataDeCelebracao(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), Date.valueOf(novoValor), connection, "UPDATE contratos SET data_de_celebracao = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarValidade(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), novoValor, connection, "UPDATE contratos SET validade = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarStatusDoContrato(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), novoValor, connection, "UPDATE contratos SET status_do_contrato = ? WHERE numero_do_contrato = ?");
    }

    static void atualizarCpfCnpjDoCliente(AdaptadorContrato contrato, String novoValor, Connection connection) {
        atualizar(contrato.getNumeroDoContrato(), novoValor, connection, "UPDATE contratos SET cpf_cnpj_do_cliente = ? WHERE numero_do_contrato = ?");
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
