package ch.francescoryu.quizzie.quiz;

import ch.francescoryu.quizzie.database.DatabaseConnection;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;

public class CreateQuiz {
    public static VBox createQuiz() throws SQLException {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        ArrayList<String> rows = DatabaseConnection.readData("SELECT * FROM quiz");
        ArrayList<Button> buttons = new ArrayList<>();

        for (String row : rows) {
            String[] values = row.split(", ");
            Button button = new Button(values[1]);
            vBox.getChildren().add(button);
            buttons.add(button);
        }

        return vBox;
    }
}
