package facs.db;

import facs.eng.Advogado;

import java.sql.Connection;
import java.util.ArrayList;

public class DAOAdvogado {
    Connection connection;

    private DAOAdvogado(Connection connection) {
        this.connection = connection;
    }

    public static DAOAdvogado criarDAO(Connection connection) {
        if (connection == null) {
            return null;
        }
        return new DAOAdvogado(connection);
    }

    public Advogado selecionar(String registroDoAdvogado) {
        try {
            return DbSelecaoAdvogado.selecionarAdvogado(registroDoAdvogado, this.connection).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public ArrayList<Advogado> selecionarTodos(String registroDoAdvogado) {
        ArrayList<Advogado> resultado = new ArrayList<>();
        for (Advogado advogado : DbSelecaoAdvogado.selecionarAdvogado(registroDoAdvogado, this.connection)) {
            resultado.add(advogado);
        }
        return resultado;
    }

    public void inserir(Advogado advogado) {
        if (advogado != null) {
            DbInsercaoAdvogado.inserirAdvogado(advogado, this.connection);
        }
    }

    public void deletar(Advogado advogado) {
        if (advogado != null) {
            DbDelecaoAdvogado.deletarAdvogado(advogado, this.connection);
        }
    }

    public void atualizar(int op, String registroDoAdvogado, String novoValor) {
        switch (op) {
            case 0:
                DbAtualizacaoAdvogado.atualizarRegistroDoAdvogado(registroDoAdvogado, novoValor, this.connection);
                break;
            case 1:
                DbAtualizacaoAdvogado.atualizarNome(registroDoAdvogado, novoValor, this.connection);
                break;
            case 2:
                DbAtualizacaoAdvogado.atualizarEndereco(registroDoAdvogado, novoValor, this.connection);
                break;
            default:
                System.out.println("DEBUG: opção inválida.");
        }
    }
}
