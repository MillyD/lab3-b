package lublin.wsei.java.cwiczenia.test;

import lublin.wsei.java.cwiczenia.MyDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        MyDB mydb = new MyDB("localhost", "mydb", 3306);
        mydb.setUser("root");
        mydb.setPassword("mysql");
        Connection conn = mydb.getConnection();
        if (conn != null){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coffee_houses");
            System.out.printf("%10s%20s%7s%7s%7s\n","STORE_ID","CITY","COFFEE","MERCH", "TOTAL");
            while (resultSet.next()){
                System.out.printf("%10d%20s%7d%7d%7d\n",
                        resultSet.getInt(1),
                        resultSet.getString("CITY"),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5));
            }
        }
        mydb.closeConnection();
        System.out.println("Połączenie z bazą danych zakończone");
    }
}
