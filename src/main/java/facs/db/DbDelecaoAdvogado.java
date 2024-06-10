package facs.db;

import facs.eng.Advogado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbDelecaoAdvogado {

    private DbDelecaoAdvogado() {
        throw new IllegalStateException("Utility class only");
    }

    static void deletarAdvogado(Advogado advogado, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM advogados WHERE registro_do_advogado = ?")) {
            pstmt.setString(1, advogado.getRegistroDoAdvogado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
