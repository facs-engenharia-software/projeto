package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbDelecaoContrato {

    private DbDelecaoContrato() {
        throw new IllegalStateException("Utility class only");
    }

    static void deletarContrato(AdaptadorContrato contrato, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM contratos WHERE numero_do_contrato = ?")) {
            pstmt.setString(1, contrato.getNumeroDoContrato());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
