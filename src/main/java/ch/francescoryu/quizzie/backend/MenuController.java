package ch.francescoryu.quizzie.backend;

import ch.francescoryu.quizzie.frontend.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MenuController extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        Menu menu = new Menu(stage);
        Scene scene = new Scene(menu, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}
