package facs.eng;

import facs.db.DbConexao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DbPoolDeConexoes {
    private List<Connection> poolDeConexoes = new ArrayList<>();
    private List<Connection> poolUtilizado = new ArrayList<>();
    private static final int POOL_TAMANHO = 5;

    private static DbPoolDeConexoes instancia = null;

    private DbPoolDeConexoes() {
        Connection connection;
        for (int i = 0; i < POOL_TAMANHO; i++) {
            connection = DbConexao.conectar();
            if (connection == null) {
                poolDeConexoes.clear();
                instancia = null;
                break;
            }
            poolDeConexoes.add(connection);
        }
    }

    public static DbPoolDeConexoes criar() {
        if (instancia == null) {
            instancia = new DbPoolDeConexoes();
        }
        return instancia;
    }

    public Connection receberConexao() {
        if (poolDeConexoes.isEmpty()) {
            System.out.println("DEBUG: Pool de conexões vazia.");
            return null;
        }
        Connection connection = poolDeConexoes
                .remove(poolDeConexoes.size() - 1);
        poolUtilizado.add(connection);
        return connection;
    }

    public boolean liberarConexao(Connection connection) {
        if (!poolUtilizado.contains(connection)) {
            System.out.println("DEBUG: Conexão não pertence ao pool.");
            return false;
        }
        poolDeConexoes.add(connection);
        return poolUtilizado.remove(connection);
    }
}
