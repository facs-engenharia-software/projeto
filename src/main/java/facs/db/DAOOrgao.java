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
        return DbSelecaoOrgao.selecionarOrgao(identificacaoDoOrgao, this.connection).get(0).formatoOriginal();
    }

    public ArrayList<Orgao> selecionarTodos(String identificacaoDoOrgao) {
        ArrayList<Orgao> resultado = new ArrayList<>();
        for (AdaptadorOrgao adaptadorOrgao : DbSelecaoOrgao.selecionarOrgao(identificacaoDoOrgao, this.connection)) {
            resultado.add(adaptadorOrgao.formatoOriginal());
        }
        return resultado;
    }

    public void inserir(Orgao orgao) {
        if (orgao != null) {
            AdaptadorOrgao adaptadorOrgao = new AdaptadorOrgao(orgao);
            DbInsercaoOrgao.inserirOrgao(adaptadorOrgao, this.connection);
        }
    }

    public void deletar(Orgao orgao) {
        if (orgao != null) {
            AdaptadorOrgao adaptadorOrgao = new AdaptadorOrgao(orgao);
            DbDelecaoOrgao.deletarOrgao(adaptadorOrgao, this.connection);
        }
    }

    public void atualizar(int op, Orgao orgao, String novoValor) {
        if (orgao != null) {
            AdaptadorOrgao adaptadorOrgao = new AdaptadorOrgao(orgao);
            switch (op) {
                case 1:
                    DbAtualizacaoOrgao.atualizarIdentificacaoDoOrgao(adaptadorOrgao, novoValor, this.connection);
                    break;
                case 2:
                    DbAtualizacaoOrgao.atualizarNomeDoOrgao(adaptadorOrgao, novoValor, this.connection);
                    break;
                case 3:
                    DbAtualizacaoOrgao.atualizarVinculacaoHierarquica(adaptadorOrgao, novoValor, this.connection);
                    break;
                default:
                    System.out.println("DEBUG: opção inválida.");
            }
        }
    }
}
