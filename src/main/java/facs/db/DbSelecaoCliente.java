package facs.db;

import facs.eng.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DbSelecaoCliente {

    private DbSelecaoCliente(){
        throw new IllegalStateException("Utility class only");
    }

    static ArrayList<AdaptadorCliente> selecionarCliente(String cpfOuCnpj, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM clientes WHERE cpf_cnpj_do_cliente = ?")) {
            pstmt.setString(1, cpfOuCnpj);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<AdaptadorCliente> listaDeResultados = new ArrayList<>();
            while (rs.next()) {
                listaDeResultados.add(
                        new AdaptadorCliente(
                                rs.getString("cpf_cnpj_do_cliente"),
                                rs.getString("nome"),
                                rs.getString("nome_do_responsavel"),
                                rs.getString("endereco"),
                                rs.getString("telefone")
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