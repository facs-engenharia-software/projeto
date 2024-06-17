package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoAdvogado {

    private DbAtualizacaoAdvogado() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarRegistroDoAdvogado(String registroDoAdvogado, String novoValor, Connection connection) {
        atualizar(registroDoAdvogado, novoValor, connection, "UPDATE advogados SET registro_do_advogado = ? WHERE registro_do_advogado = ?");
    }

    static void atualizarNome(String registroDoAdvogado, String novoValor, Connection connection) {
        atualizar(registroDoAdvogado, novoValor, connection, "UPDATE advogados SET nome = ? WHERE registro_do_advogado = ?");
    }

    static void atualizarEndereco(String registroDoAdvogado, String novoValor, Connection connection) {
        atualizar(registroDoAdvogado, novoValor, connection, "UPDATE advogados SET endereco = ? WHERE registro_do_advogado = ?");
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
