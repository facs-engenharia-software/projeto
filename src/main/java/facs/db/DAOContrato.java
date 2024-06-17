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

    public Contrato selecionar(long numeroDoContrato) {
        String numeroDoContratoAdaptado = Long.toString(numeroDoContrato);
        try {
            return DbSelecaoContrato.selecionarContrato(numeroDoContratoAdaptado, this.connection).get(0).formatoOriginal();
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
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

    public void atualizar(int op, String numeroDoContrato, String novoValor) {
        switch (op) {
            case 0:
                DbAtualizacaoContrato.atualizarNumeroDoContrato(numeroDoContrato, novoValor, this.connection);
                break;
            case 1:
                DbAtualizacaoContrato.atualizarTipoDeContrato(numeroDoContrato, novoValor, this.connection);
                break;
            case 2:
                DbAtualizacaoContrato.atualizarDataDeCelebracao(numeroDoContrato, novoValor, this.connection);
                break;
            case 3:
                DbAtualizacaoContrato.atualizarValidade(numeroDoContrato, novoValor, this.connection);
                break;
            case 4:
                DbAtualizacaoContrato.atualizarStatusDoContrato(numeroDoContrato, novoValor, this.connection);
                break;
            case 5:
                DbAtualizacaoContrato.atualizarCpfCnpjDoCliente(numeroDoContrato, novoValor, this.connection);
                break;
            default:
                System.out.println("DEBUG: opção inválida.");
        }
    }
}
