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
        return DbSelecaoAdvogado.selecionarAdvogado(registroDoAdvogado, this.connection).get(0);
    }

    public ArrayList<Advogado> selecionarTodos(String registroDoAdvogado) {
        return DbSelecaoAdvogado.selecionarAdvogado(registroDoAdvogado, this.connection);
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

    public void atualizar(int op, Advogado advogado, String novoValor) {
        if (advogado != null) {
            switch (op) {
                case 1:
                    DbAtualizacaoAdvogado.atualizarRegistroDoAdvogado(advogado, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoAdvogado.atualizarNome(advogado, novoValor, this.connection);
                    break;
                case 3:
                    DbAtualizacaoAdvogado.atualizarEndereco(advogado, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
