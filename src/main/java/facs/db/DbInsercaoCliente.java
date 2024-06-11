package facs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoCliente {

    private DbInsercaoCliente() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirCliente(AdaptadorCliente cliente, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO clientes (cpf_cnpj_do_cliente, nome, nome_do_responsavel, endereco, telefone) VALUES (?, ?, ?, ?, ?)")
        ) {
            pstmt.setString(1, cliente.getCpfOuCnpjDoCliente());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getNomeDoResponsavel());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
