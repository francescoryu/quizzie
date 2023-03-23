package ch.francescoryu.quizzie.quiz;

import ch.francescoryu.quizzie.database.DatabaseConnection;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateQuiz {
    public static VBox createQuiz() throws SQLException {
        VBox vBox = new VBox();
        vBox.getStylesheets().add(Objects.requireNonNull(CreateQuiz.class.getResource("/css/styles.css")).toExternalForm());
        ArrayList<String> rows = DatabaseConnection.readData("SELECT * FROM quiz");
        ArrayList<Button> buttons = new ArrayList<>();

        for (String row : rows) {
            String[] values = row.split(", ");
            Button button = new Button(values[1]);
            button.setMinWidth(200);
            button.getStyleClass().add("quiz-button");
            buttons.add(button);
            vBox.getChildren().add(button);
        }

        return vBox;
    }
}
