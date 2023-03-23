package ch.francescoryu.quizzie.menu;

import ch.francescoryu.quizzie.quiz.CreateQuiz;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
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
        createButtonBox.setMinWidth(250);
        createButtonBox.setAlignment(Pos.TOP_CENTER);

        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.TOP_CENTER);

        Label createQuizLabel = new Label("Create Area");
        leftBox.getChildren().addAll(createQuizLabel, createButtonBox);
        //--------------------------------------------
        VBox quizButtonBox = CreateQuiz.createQuiz();
        quizButtonBox.setAlignment(Pos.TOP_CENTER);
        quizButtonBox.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        quizButtonBox.setSpacing(5);
        ScrollPane scrollPane = new ScrollPane(quizButtonBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        scrollPane.setFitToWidth(true);

        VBox rightBox = new VBox();

        Label selectQuizLabel = new Label("Select Quiz");
        rightBox.getChildren().addAll(selectQuizLabel, scrollPane);
        rightBox.setAlignment(Pos.TOP_CENTER);
        //--------------------------------------------
        HBox contentBox = new HBox();
        contentBox.getChildren().addAll(leftBox, rightBox);
        HBox.setHgrow(leftBox, Priority.ALWAYS);
        HBox.setHgrow(rightBox, Priority.ALWAYS);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setFillHeight(true);
        //--------------------------------------------
        getStyleClass().add("menu-container");
        getChildren().addAll(hBox, contentBox);
        setVgrow(contentBox, Priority.ALWAYS);
        setPrefSize(700, 500);
    }
}
