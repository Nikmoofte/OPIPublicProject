module com.project.Main {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.project.bakkara;
    exports com.project.Main;
    exports com.project.roulette;
    opens com.project.Main to javafx.graphics, javafx.fxml;
    opens com.project.bakkara to javafx.fxml, javafx.graphics;
    opens com.project.roulette to javafx.fxml, javafx.graphics;

}

