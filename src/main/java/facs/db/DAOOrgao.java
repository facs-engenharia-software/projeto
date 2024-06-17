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
        try {
            return DbSelecaoOrgao.selecionarOrgao(identificacaoDoOrgao, this.connection).get(0).formatoOriginal();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
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

    public void atualizar(int op, String identificacaoDoOrgao, String novoValor) {
        switch (op) {
            case 0:
                DbAtualizacaoOrgao.atualizarIdentificacaoDoOrgao(identificacaoDoOrgao, novoValor, this.connection);
                break;
            case 1:
                DbAtualizacaoOrgao.atualizarNomeDoOrgao(identificacaoDoOrgao, novoValor, this.connection);
                break;
            case 2:
                DbAtualizacaoOrgao.atualizarVinculacaoHierarquica(identificacaoDoOrgao, novoValor, this.connection);
                break;
            default:
                System.out.println("DEBUG: opção inválida.");
        }
    }
}
