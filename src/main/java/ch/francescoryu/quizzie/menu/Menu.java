package ch.francescoryu.quizzie.menu;

import ch.francescoryu.quizzie.database.DatabaseConnection;
import ch.francescoryu.quizzie.quiz.CreateQuiz;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        createButtonBox.setStyle("-fx-border-color: white");
        createButtonBox.setAlignment(Pos.TOP_CENTER);
        //--------------------------------------------
        ScrollPane scrollPane = new ScrollPane(CreateQuiz.createQuiz());
        scrollPane.setStyle("-fx-background-color: transparent;");
        //--------------------------------------------
        HBox contentBox = new HBox();
        contentBox.getChildren().addAll(scrollPane, createButtonBox);
        contentBox.setHgrow(scrollPane, Priority.ALWAYS);
        contentBox.setHgrow(createButtonBox, Priority.ALWAYS);
        //--------------------------------------------

        getStyleClass().add("menu-container");
        getChildren().addAll(hBox, contentBox);
        setVgrow(contentBox, Priority.ALWAYS);
        setPrefSize(700, 500);
    }


}
