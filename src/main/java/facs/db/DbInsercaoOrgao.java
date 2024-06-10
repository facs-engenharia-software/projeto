package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoOrgao {

    private DbInsercaoOrgao() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirOrgao(AdaptadorOrgao orgao, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO orgaos (identificacao_do_orgao, nome_do_orgao, vinculacao_hierarquica) VALUES (?, ?, ?)")
        ) {
            pstmt.setString(1, orgao.getIdOrgao());
            pstmt.setString(2, orgao.getNome());
            pstmt.setString(3, orgao.getVinculacaoSuperior());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
