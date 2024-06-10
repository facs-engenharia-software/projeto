package facs.db;

import facs.eng.Advogado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoAdvogado {

    private DbAtualizacaoAdvogado() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarRegistroDoAdvogado(Advogado advogado, String novoValor, Connection connection) {
        atualizar(advogado.getRegistroDoAdvogado(), novoValor, connection, "UPDATE advogados SET registro_do_advogado = ? WHERE registro_do_advogado = ?");
    }

    static void atualizarNome(Advogado advogado, String novoValor, Connection connection) {
        atualizar(advogado.getRegistroDoAdvogado(), novoValor, connection, "UPDATE advogados SET nome = ? WHERE registro_do_advogado = ?");
    }

    static void atualizarEndereco(Advogado advogado, String novoValor, Connection connection) {
        atualizar(advogado.getRegistroDoAdvogado(), novoValor, connection, "UPDATE advogados SET endereco = ? WHERE registro_do_advogado = ?");
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
