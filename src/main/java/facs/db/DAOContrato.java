package facs.db;

import facs.eng.Contrato;

import java.sql.Connection;
import java.util.ArrayList;

public class DAOContrato {
    Connection connection;

    private DAOContrato(Connection connection) {
        this.connection = connection;
    }

    public static DAOContrato criarDAO(Connection connection) {
        if (connection == null) {
            return null;
        }
        return new DAOContrato(connection);
    }

    public Contrato selecionar(String numeroDoContrato) {
        return DbSelecaoContrato.selecionarContrato(numeroDoContrato, this.connection).get(0);
    }

    public ArrayList<Contrato> selecionarTodos(String numeroDoContrato) {
        return DbSelecaoContrato.selecionarContrato(numeroDoContrato, this.connection);
    }

    public void inserir(Contrato contrato) {
        if (contrato != null) {
            DbInsercaoContrato.inserirContrato(contrato, this.connection);
        }
    }

    public void deletar(Contrato contrato) {
        if (contrato != null) {
            DbDelecaoContrato.deletarContrato(contrato, this.connection);
        }
    }

    public void atualizar(int op, Contrato contrato, String novoValor) {
        if (contrato != null) {
            switch (op) {
                case 1:
                    DbAtualizacaoContrato.atualizarNumeroDoContrato(contrato, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoContrato.atualizarTipoDeContrato(contrato, novoValor, this.connection);
                    break;
                case 3:
                    DbAtualizacaoContrato.atualizarDataDeCelebracao(contrato, novoValor, this.connection);
                    break;
                case 4:
                    DbAtualizacaoContrato.atualizarValidade(contrato, novoValor, this.connection);
                    break;
                case 5:
                    DbAtualizacaoContrato.atualizarStatusDoContrato(contrato, novoValor, this.connection);
                    break;
                case 6:
                    DbAtualizacaoContrato.atualizarCpfCnpjDoCliente(contrato, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
