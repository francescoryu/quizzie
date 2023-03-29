package ch.francescoryu.quizzie;

import ch.francescoryu.quizzie.frontend.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        Login login = new Login(stage);
        Scene scene = new Scene(login, 500, 420);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }

    public static void closeStage(Stage stage) {
        stage.close();
    }
}