package facs.db;

import facs.eng.Orgao;

import java.sql.Connection;
import java.util.ArrayList;

public class DAOOrgao {
    Connection connection;

    private DAOOrgao(Connection connection) {
        this.connection = connection;
    }

    public static DAOOrgao criarDAO(Connection connection) {
        if (connection == null) {
            return null;
        }
        return new DAOOrgao(connection);
    }

    public Orgao selecionar(String identificacaoDoOrgao) {
        return DbSelecaoOrgao.selecionarOrgao(identificacaoDoOrgao, this.connection).get(0);
    }

    public ArrayList<Orgao> selecionarTodos(String identificacaoDoOrgao) {
        return DbSelecaoOrgao.selecionarOrgao(identificacaoDoOrgao, this.connection);
    }

    public void inserir(Orgao orgao) {
        if (orgao != null) {
            DbInsercaoOrgao.inserirOrgao(orgao, this.connection);
        }
    }

    public void deletar(Orgao orgao) {
        if (orgao != null) {
            DbDelecaoOrgao.deletarOrgao(orgao, this.connection);
        }
    }

    public void atualizar(int op, Orgao orgao, String novoValor) {
        if (orgao != null) {
            switch (op) {
                case 1:
                    DbAtualizacaoOrgao.atualizarIdentificacaoDoOrgao(orgao, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoOrgao.atualizarVinculacaoHierarquica(orgao, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
