package facs.db;

import facs.eng.Advogado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoAdvogado {

    private DbInsercaoAdvogado() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirAdvogado(Advogado advogado, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO advogados (registro_do_advogado, nome, endereco) VALUES (?, ?, ?)")
        ) {
            pstmt.setString(1, advogado.getRegistroDoAdvogado());
            pstmt.setString(2, advogado.getNome());
            pstmt.setString(3, advogado.getEndereco());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
