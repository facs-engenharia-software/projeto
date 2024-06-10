package facs.db;

import facs.eng.Contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DbSelecaoContrato {

    private DbSelecaoContrato(){
        throw new IllegalStateException("Utility class only");
    }

    static ArrayList<Contrato> selecionarContrato(String numeroDoContrato, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contratos WHERE numero_do_contrato = ?")) {
            pstmt.setString(1, numeroDoContrato);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Contrato> listaDeResultados = new ArrayList<>();
            while (rs.next()) {
                listaDeResultados.add(
                        new Contrato(
                                rs.getString("numero_do_contrato"),
                                rs.getString("tipo_de_contrato"),
                                rs.getDate("data_de_celebracao").toLocalDate(),
                                rs.getString("validade"),
                                rs.getString("status_do_contrato"),
                                rs.getString("cpf_cnpj_do_cliente")
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
