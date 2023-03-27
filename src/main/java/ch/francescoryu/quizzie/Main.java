package ch.francescoryu.quizzie;

import ch.francescoryu.quizzie.login.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        Login login = new Login();
        Scene scene = new Scene(login, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}