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
        return DbSelecaoContrato.selecionarContrato(numeroDoContrato, this.connection).get(0).formatoOriginal();
    }

    public ArrayList<Contrato> selecionarTodos(String numeroDoContrato) {
        ArrayList<Contrato> resultado = new ArrayList<>();
        for (AdaptadorContrato adaptadorContrato : DbSelecaoContrato.selecionarContrato(numeroDoContrato, this.connection)) {
            resultado.add(adaptadorContrato.formatoOriginal());
        }
        return resultado;
    }

    public void inserir(Contrato contrato) {
        if (contrato != null) {
            AdaptadorContrato adaptadorContrato = new AdaptadorContrato(contrato);
            DbInsercaoContrato.inserirContrato(adaptadorContrato, this.connection);
        }
    }

    public void deletar(Contrato contrato) {
        if (contrato != null) {
            AdaptadorContrato adaptadorContrato = new AdaptadorContrato(contrato);
            DbDelecaoContrato.deletarContrato(adaptadorContrato, this.connection);
        }
    }

    public void atualizar(int op, Contrato contrato, String novoValor) {
        if (contrato != null) {
            AdaptadorContrato adaptadorContrato = new AdaptadorContrato(contrato);
            switch (op) {
                case 1:
                    DbAtualizacaoContrato.atualizarNumeroDoContrato(adaptadorContrato, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoContrato.atualizarTipoDeContrato(adaptadorContrato, novoValor, this.connection);
                    break;
                case 3:
                    DbAtualizacaoContrato.atualizarDataDeCelebracao(adaptadorContrato, novoValor, this.connection);
                    break;
                case 4:
                    DbAtualizacaoContrato.atualizarValidade(adaptadorContrato, novoValor, this.connection);
                    break;
                case 5:
                    DbAtualizacaoContrato.atualizarStatusDoContrato(adaptadorContrato, novoValor, this.connection);
                    break;
                case 6:
                    DbAtualizacaoContrato.atualizarCpfCnpjDoCliente(adaptadorContrato, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
