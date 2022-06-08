package lublin.wsei.java.cwiczenia.test;

import lublin.wsei.java.cwiczenia.MyDB;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB mydb = new MyDB("localhost", "mydb", 3306);
        mydb.setUser("root");
        mydb.setPassword("mysql");
        Connection conn = mydb.getConnection();
        if (conn != null){
            System.out.println("Połączenie z bazą danych nawiązane");
        }
    }
}
