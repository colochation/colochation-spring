package cat.omnes.colochation.colochationback.infrastructure.mysql;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static final String URL = "jdbc:mysql://mysql:3306/colochation";
    private static final String USER = "root";
    private static final String PASSWORD = "pwd";

    private Connection connection;

    public MySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données MySQL!");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données MySQL!");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
