module lublin.wsei.java.lab3b {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lublin.wsei.java.lab3b to javafx.fxml;
    exports lublin.wsei.java.lab3b;
}