package facs.db;

import facs.eng.Orgao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DbSelecaoOrgao {

    private DbSelecaoOrgao(){
        throw new IllegalStateException("Utility class only");
    }

    static ArrayList<Orgao> selecionarOrgao(String identificacaoDoOrgao, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM orgaos WHERE identificacao_do_orgao = ?")) {
            pstmt.setString(1, identificacaoDoOrgao);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Orgao> listaDeResultados = new ArrayList<>();
            while (rs.next()) {
                listaDeResultados.add(
                        new Orgao(
                                rs.getString("identificacao_do_orgao"),
                                rs.getString("vinculacao_hierarquica")
                        )
                );
            }
            return listaDeResultados;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
