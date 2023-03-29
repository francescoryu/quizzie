package ch.francescoryu.quizzie.backend.animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MorphBackground {

    public static void morphBackground(Button button) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(button.backgroundProperty(),
                        new Background(new BackgroundFill(Color.web("#1a1a42"), null, null)))),

                new KeyFrame(Duration.seconds(1), new KeyValue(button.backgroundProperty(),
                        new Background(new BackgroundFill(Color.web("#CCCCCC"), null, null))))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }

}
