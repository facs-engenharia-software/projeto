package facs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbInsercaoProcesso {

    private DbInsercaoProcesso() {
        throw new IllegalStateException("Utility class only");
    }

    static void inserirProcesso(AdaptadorProcesso processo, Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO processos (numero_do_processo, identificacao_do_orgao, fase_processual, natureza_da_demanda, cpf_cnpj_do_cliente, posicao_do_cliente, registro_do_advogado, status_do_projeto, data_de_ajuizamento, numero_do_contrato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        ) {
            pstmt.setString(1, processo.getNumeroDoProcesso());
            pstmt.setString(2, processo.getIdentificacaoDoOrgao());
            pstmt.setString(3, processo.getFaseProcessual());
            pstmt.setString(4, processo.getNaturezaDaDemanda());
            pstmt.setString(5, processo.getCpfCnpjDoCliente());
            pstmt.setString(6, processo.getPosicaoDoCliente());
            pstmt.setString(7, processo.getRegistroDoAdvogado());
            pstmt.setString(8, processo.getStatusDoProcesso());
            pstmt.setDate(9, Date.valueOf(processo.getDataDeAjuizamento()));
            pstmt.setString(10, processo.getNumeroDoContrato());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
