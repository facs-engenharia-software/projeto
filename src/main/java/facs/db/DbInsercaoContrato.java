package facs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoContrato {

    private DbInsercaoContrato() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirContrato(AdaptadorContrato contrato, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO contratos (numero_do_contrato, tipo_de_contrato, data_de_celebracao, validade, status_do_contrato, cpf_cnpj_do_cliente) VALUES (?, ?, ?, ?, ?, ?)")
        ) {
            pstmt.setString(1, contrato.getNumeroDoContrato());
            pstmt.setString(2, contrato.getTipoDeContrato());
            pstmt.setDate(3, Date.valueOf(contrato.getDataDeCelebracao()));
            pstmt.setString(4, contrato.getValidade());
            pstmt.setString(5, contrato.getStatusDoContrato());
            pstmt.setString(6, contrato.getCpfOuCnpjDoCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
