package lublin.wsei.java.cwiczenia;

import java.sql.*;
import java.util.Properties;

public class MyDB {

    private String serverName;
    private String database;
    private Number portNumber;
    private String user;
    private String password;
    private Connection conn = null;
    private Statement statement = null;

    public MyDB(String serverName, String database, Number portNumber) {
        this.serverName = serverName;
        this.database = database;
        this.portNumber = portNumber;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void connect(){
        Properties connectionProps = new Properties();
        connectionProps.put("user","root");
        connectionProps.put("password","mysql");
        connectionProps.put("serverTimezone","Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + database;

        try{
            conn = DriverManager.getConnection(jdbcString,connectionProps);
            statement = conn.createStatement();
        }
        catch (SQLException e){
            System.out.println("Błąd podłączenia do bazy: " + jdbcString);
            System.out.println("Komunikat błędu: " + e.getMessage());
        }
        System.out.println("Connected to database: " + database);
    }

    public Connection getConnection() {
        if(conn == null)
            connect();
        return conn;
    }
    public void closeConnection(){
        if (conn != null)
            try{
                conn.close();
            }
        catch (SQLException e){
            System.out.println("Błąd ptzy zamykaniu połączenia bazodanowego: " + e.getMessage());
        }
    }

    public ResultSet selectData (String selectStatement){
        if((conn != null) && (statement != null)){
            try{
                return statement.executeQuery(selectStatement);
            }
            catch (SQLException e){
                System.out.println("Błąd realizacji zapytania: " + selectStatement + ", " + e.getMessage());
            }
        }
        return null;
    }
}
