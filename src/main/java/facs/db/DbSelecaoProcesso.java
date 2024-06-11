package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DbSelecaoProcesso {

    private DbSelecaoProcesso(){
        throw new IllegalStateException("Utility class only");
    }

    static ArrayList<AdaptadorProcesso> selecionarProcesso(String numeroDoProcesso, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processos WHERE numero_do_processo = ?")) {
            pstmt.setString(1, numeroDoProcesso);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<AdaptadorProcesso> listaDeResultados = new ArrayList<>();
            while (rs.next()) {
                listaDeResultados.add(
                        new AdaptadorProcesso(
                                rs.getString("numero_do_processo"),
                                rs.getString("identificacao_do_orgao"),
                                rs.getString("fase_processual"),
                                rs.getString("natureza_da_demanda"),
                                rs.getString("cpf_cnpj_do_cliente"),
                                rs.getString("posicao_do_cliente"),
                                rs.getString("registro_do_advogado"),
                                rs.getString("status_do_processo"),
                                rs.getDate("data_de_ajuizamento").toLocalDate(),
                                rs.getString("numero_do_contrato")
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
