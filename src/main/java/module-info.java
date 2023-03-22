module ch.francescoryu.quizzie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens ch.francescoryu.quizzie to javafx.fxml;
    exports ch.francescoryu.quizzie;
}