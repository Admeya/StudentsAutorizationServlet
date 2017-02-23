package models.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Ирина on 23.02.2017.
 */
public class Connector {
    private static final String USER = "postgres";//Логин пользователя
    private static final String PASSWORD = "root";//Пароль пользователя
    private static final String URL = "jdbc:postgresql://localhost:5432/Students?useUnicode=yes&characterEncoding=UTF-8";//URL адрес
    private static final String DRIVER = "org.postgresql.Driver";//Имя драйвера

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties p = new Properties();
        p.put("user", USER);
        p.put("password", PASSWORD);
        p.put("characterEncoding", "UTF-8");

        return DriverManager.getConnection(URL, p);
    }
}
