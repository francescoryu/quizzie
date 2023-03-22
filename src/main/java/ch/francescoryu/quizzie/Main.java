package ch.francescoryu.quizzie;

import ch.francescoryu.quizzie.database.DatabaseConnection;
import ch.francescoryu.quizzie.menu.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        Menu menu = new Menu();
        Scene scene = new Scene(menu, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        /*String sql = "INSERT INTO question (quiz_id, text) VALUES (?, ?)";
        DatabaseConnection.insertData(sql, 1, "TEST");*/
        launch();
    }
}