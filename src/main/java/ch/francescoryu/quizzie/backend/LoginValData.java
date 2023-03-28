package ch.francescoryu.quizzie.backend;

import ch.francescoryu.quizzie.Main;
import ch.francescoryu.quizzie.database.DatabaseConnection;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginValData {
    public static String checkLoginData(String username, String password, Stage stage) throws SQLException {
        String sqlQuery = "SELECT * FROM user WHERE username = ?";
        List<Object> params = new ArrayList<>();
        List<String> resultSet = new ArrayList<>();

        params.add(username);

        DatabaseConnection.connectDatabase();
        resultSet = DatabaseConnection.readDataParams(sqlQuery, params);
        if (resultSet.isEmpty()) {
            return "Invalid username/password";
        }

        else {
            Main.closeStage(stage);
            Stage MenuStage = new Stage();
            MenuController menuController = new MenuController();
            menuController.start(MenuStage);
            return "Valid!";
        }
    }
}
