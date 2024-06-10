package facs.db;

import facs.eng.Advogado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DbSelecaoAdvogado {

    private DbSelecaoAdvogado(){
        throw new IllegalStateException("Utility class only");
    }

    static ArrayList<Advogado> selecionarAdvogado(String registroDoAdvogado, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogados WHERE registro_do_advogado = ?")) {
            pstmt.setString(1, registroDoAdvogado);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Advogado> listaDeResultados = new ArrayList<>();
            while (rs.next()) {
                listaDeResultados.add(
                        new Advogado(
                                rs.getString("registro_do_advogado"),
                                rs.getString("nome"),
                                rs.getString("endereco")
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
