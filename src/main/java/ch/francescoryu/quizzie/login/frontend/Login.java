package ch.francescoryu.quizzie.login.frontend;

import ch.francescoryu.quizzie.login.backend.LoginValData;
import ch.francescoryu.quizzie.quiz.CreateQuiz;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.Objects;

public class Login extends VBox {
    public Login() {
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

        Button loginButton = new Button("Login");
        loginButton.setOnAction(actionEvent -> {
            try {
                LoginValData.checkLoginData(usernameInput.getText(), passwordField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        //------------------------------------------------------------

        VBox fieldset = new VBox();
        fieldset.setStyle("-fx-border-color: #CCCCCC;");
        fieldset.setSpacing(10);
        fieldset.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordField, loginButton);
        fieldset.setAlignment(Pos.CENTER);

        //Set Margin for fieldset
        Insets margin = new Insets(5, 15, 5, 15);
        VBox.setMargin(fieldset, margin);

        //Set Padding for fieldset
        fieldset.setPadding(new Insets(15, 15, 15, 15));

        getChildren().addAll(loginLabel, fieldset, text);
        setSpacing(5);
        setStyle("-fx-background-color: #30304D;");
        setAlignment(Pos.TOP_CENTER);
    }
}
