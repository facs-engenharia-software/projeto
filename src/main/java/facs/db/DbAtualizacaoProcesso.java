package facs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DbAtualizacaoProcesso {

    DbAtualizacaoProcesso() {
        throw new IllegalStateException("Utility class only");
    }

    static void atualizarNumeroDoProcesso(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET numero_do_processo = ? WHERE numero_do_processo = ?");
    }

    static void atualizarIdentificacaoDoOrgao(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET identificacao_do_orgao = ? WHERE numero_do_processo = ?");
    }

    static void atualizarFaseProcessual(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET fase_processual = ? WHERE numero_do_processo = ?");
    }

    static void atualizarNaturezaDaDemanda(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET natureza_da_demanda = ? WHERE numero_do_processo = ?");
    }

    static void atualizarCpfCnpjDoCliente(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET cpf_cnpj_do_cliente = ? WHERE numero_do_processo = ?");
    }

    static void atualizarPosicaoDoCliente(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET posicao_do_cliente = ? WHERE numero_do_processo = ?");
    }

    static void atualizarRegistroDoAdvogado(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET registro_do_advogado = ? WHERE numero_do_processo = ?");
    }

    static void atualizarStatusDoProcesso(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET status_do_processo = ? WHERE numero_do_processo = ?");
    }

    static void atualizarDataDeAjuizamento(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), Date.valueOf(novoValor), connection, "UPDATE processos SET data_de_ajuizamento = ? WHERE numero_do_processo = ?");
    }

    static void atualizarNumeroDoContrato(AdaptadorProcesso processo, String novoValor, Connection connection) {
        atualizar(processo.getNumeroDoProcesso(), novoValor, connection, "UPDATE processos SET numero_do_contrato = ? WHERE numero_do_processo = ?");
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

    private static void atualizar(String chave, Date novoValor, Connection connection, String query) {
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, novoValor);
            pstmt.setString(2, chave);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
