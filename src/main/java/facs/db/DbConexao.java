package facs.db;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConexao {

    private DbConexao(){
        throw new IllegalStateException("Utility class only");
    }

    public static Connection conectar() {
        Dotenv dotenv = Dotenv.load();
//        String dbUrl = "jdbc:" + dotenv.get("DB_URL") +
//                ":" + dotenv.get("DB_PORT") +
//                "/" + dotenv.get("DB_NAME") +
//                "?user=" + dotenv.get("DB_USER") +
//                "&password=" + dotenv.get("DB_PW");
        String dbUrl = dotenv.get("DB_URL");
        try {
            return DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            Logger.getLogger("context", String.valueOf(e));
            return null;
        }
    }

}