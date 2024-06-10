package facs.db;

import facs.eng.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbDelecaoCliente {

    private DbDelecaoCliente() {
        throw new IllegalStateException("Utility class only");
    }

    static void deletarCliente(AdaptadorCliente cliente, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM clientes WHERE cpf_cnpj_do_cliente = ?")) {
            pstmt.setString(1, cliente.getCpfOuCnpjDoCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
