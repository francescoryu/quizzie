package ch.francescoryu.quizzie.login.backend;

import ch.francescoryu.quizzie.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginValData {
    public static String checkLoginData(String username, String password) throws SQLException {
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
            System.out.println(resultSet);
            return "RESULTS";
        }
    }
}
