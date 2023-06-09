package ch.francescoryu.quizzie.frontend;

import ch.francescoryu.quizzie.backend.LoginValData;
import ch.francescoryu.quizzie.backend.animation.MorphBackground;
import ch.francescoryu.quizzie.backend.quiz.CreateQuiz;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

public class Login extends VBox {
    public Login(Stage loginStage) {
        getStylesheets().add(Objects.requireNonNull(CreateQuiz.class.getResource("/css/styles.css")).toExternalForm());

        //------------------------------------------------------------
        Label loginLabel = new Label("Login");
        Text text = new Text("Master your Quizzes");
        text.getStyleClass().add("plain-text");
        //------------------------------------------------------------

        Label usernameLabel = new Label("Username");
        usernameLabel.getStyleClass().add("login-label");
        TextField usernameInput = new TextField();

        Label passwordLabel = new Label("Password");
        passwordLabel.getStyleClass().add("login-label");
        PasswordField passwordField = new PasswordField();

        Text messageLogin = new Text();
        messageLogin.setVisible(false);
        messageLogin.getStyleClass().add("plain-text");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(actionEvent -> {
            try {
                messageLogin.setVisible(true);
                messageLogin.setText(LoginValData.checkLoginData(usernameInput.getText(), passwordField.getText(), loginStage));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        //------------------------------------------------------------

        VBox fieldset = new VBox();
        fieldset.getStyleClass().add("fieldset");
        fieldset.setSpacing(10);
        fieldset.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordField, messageLogin, loginButton);
        fieldset.setAlignment(Pos.CENTER);

        //Set Margin for fieldset
        Insets margin = new Insets(5, 15, 5, 15);
        VBox.setMargin(fieldset, margin);

        //Set Padding for fieldset
        fieldset.setPadding(new Insets(15, 15, 15, 15));

        getChildren().addAll(loginLabel, fieldset, text);
        setSpacing(5);
        setStyle("-fx-background-color: #439A97;");
        setAlignment(Pos.TOP_CENTER);
    }
}
