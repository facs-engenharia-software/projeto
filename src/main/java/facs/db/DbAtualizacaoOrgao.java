package facs.db;

import facs.eng.Orgao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoOrgao {

    private DbAtualizacaoOrgao() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarIdentificacaoDoOrgao(Orgao orgao, String novoValor, Connection connection) {
        atualizar(orgao.getNome(), novoValor, connection, "UPDATE orgaos SET identificacao_do_orgao = ? WHERE identificacao_do_orgao = ?");
    }

    static void atualizarVinculacaoHierarquica(Orgao orgao, String novoValor, Connection connection) {
        atualizar(orgao.getNome(), novoValor, connection, "UPDATE orgaos SET vinculacao_hierarquica = ? WHERE identificacao_do_orgao = ?");
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
