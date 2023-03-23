package ch.francescoryu.quizzie.menu;

import ch.francescoryu.quizzie.database.DatabaseConnection;
import ch.francescoryu.quizzie.quiz.CreateQuiz;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Menu extends VBox {
    public Menu() throws SQLException {
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        //--------------------------------------------
        Label welcomeLabel = new Label("Welcome");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().addAll(welcomeLabel);
        //--------------------------------------------
        Button createQuizButton = new Button("Create");
        VBox createButtonBox = new VBox(createQuizButton);
        createButtonBox.setMinWidth(300);
        createButtonBox.setStyle("-fx-border-color: white");
        createButtonBox.setAlignment(Pos.TOP_CENTER);
        //--------------------------------------------
        VBox quizButtonBox = CreateQuiz.createQuiz();
        quizButtonBox.setStyle("-fx-border-color: red");
        quizButtonBox.setAlignment(Pos.TOP_CENTER);
        ScrollPane scrollPane = new ScrollPane(quizButtonBox);
        scrollPane.setFitToWidth(true);
        //--------------------------------------------
        HBox contentBox = new HBox();
        contentBox.getChildren().addAll(scrollPane, createButtonBox);
        HBox.setHgrow(createButtonBox, Priority.ALWAYS);
        HBox.setHgrow(scrollPane, Priority.ALWAYS);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setFillHeight(true);
        //--------------------------------------------
        getStyleClass().add("menu-container");
        getChildren().addAll(hBox, contentBox);
        setVgrow(contentBox, Priority.ALWAYS);
        setPrefSize(700, 500);
    }


}
