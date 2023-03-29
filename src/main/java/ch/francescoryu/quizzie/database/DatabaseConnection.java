package ch.francescoryu.quizzie.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static Connection connection = null;

    public static void connectDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:quizzie.db";
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnectDatabase() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(String sqlQuery, Object... values) throws SQLException {
        connectDatabase();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);

            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.execute();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            disconnectDatabase();
        }
    }

    public static ArrayList<String> readData(String sqlQuery) throws SQLException {
        connectDatabase();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<String> rows = new ArrayList<>();
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                count++;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    sb.append(resultSet.getString(i)).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                rows.add(sb.toString());
            }

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            disconnectDatabase();
        }
        return rows;
    }

    public static ArrayList<String> readDataParams(String sqlQuery, List<Object> params) throws SQLException {
        connectDatabase();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<String> rows = new ArrayList<>();
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);

            // Set parameter values
            int paramIndex = 1;
            for (Object param : params) {
                preparedStatement.setObject(paramIndex++, param);
            }

            resultSet = preparedStatement.executeQuery();

            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                count++;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    sb.append(resultSet.getString(i)).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                rows.add(sb.toString());
            }

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            disconnectDatabase();
        }

        return rows;
    }
}