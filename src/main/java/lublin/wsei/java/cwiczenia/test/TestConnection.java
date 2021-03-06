package lublin.wsei.java.cwiczenia.test;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String serverName = "localhost";
        String database = "mydb";
        Number portNumber = 3306;
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user","root");
        connectionProps.put("password","mysql");
        connectionProps.put("sererTimezone","Europe/Warsaw");

        conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + database, connectionProps);

        System.out.println("Connected to database");

    }
}
