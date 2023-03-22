package ch.francescoryu.quizzie.menu;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class Menu extends VBox {
    public Menu() {
        Button button = new Button("TEST");
        this.getChildren().add(button);
        this.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        this.getStyleClass().add("background");
        this.isVisible();
    }
}
