package facs.db;

import facs.eng.Orgao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoOrgao {

    private DbInsercaoOrgao() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirOrgao(Orgao orgao, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO orgaos (identificacao_do_orgao, vinculacao_hierarquica) VALUES (?, ?)")
        ) {
            pstmt.setString(1, orgao.getIdentificacaoDoOrgao());
            pstmt.setString(2, orgao.getVinculacaoHierarquica());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
