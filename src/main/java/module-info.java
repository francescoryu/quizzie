module ch.francescoryu.quizzie {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ch.francescoryu.quizzie to javafx.fxml;
    exports ch.francescoryu.quizzie;
}