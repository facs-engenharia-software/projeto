package facs.db;

import facs.eng.Orgao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbDelecaoOrgao {

    private DbDelecaoOrgao() {
        throw new IllegalStateException("Utility class only");
    }

    static void deletarOrgao(Orgao orgao, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM orgaos WHERE identificacao_do_orgao = ?")) {
            pstmt.setString(1, orgao.getIdentificacaoDoOrgao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
