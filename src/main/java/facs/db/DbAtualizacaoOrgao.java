package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoOrgao {

    private DbAtualizacaoOrgao() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarIdentificacaoDoOrgao(String identificacaoDoOrgao, String novoValor, Connection connection) {
        atualizar(identificacaoDoOrgao, novoValor, connection, "UPDATE orgaos SET identificacao_do_orgao = ? WHERE identificacao_do_orgao = ?");
    }

    static void atualizarNomeDoOrgao(String identificacaoDoOrgao, String novoValor, Connection connection) {
        atualizar(identificacaoDoOrgao, novoValor, connection, "UPDATE orgaos SET nome_do_orgao = ? WHERE identificacao_do_orgao = ?");
    }

    static void atualizarVinculacaoHierarquica(String identificacaoDoOrgao, String novoValor, Connection connection) {
        atualizar(identificacaoDoOrgao, novoValor, connection, "UPDATE orgaos SET vinculacao_hierarquica = ? WHERE identificacao_do_orgao = ?");
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
