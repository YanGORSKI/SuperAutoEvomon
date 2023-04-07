package Viewers;

import Settings.ScreenOptions;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScreen extends Application {

    private Stage primaryStage;

    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Super Auto Evomon");
        
        // Set the title screen as the initial scene
        TitleScreen titleScreen = new TitleScreen(this);
        Scene scene = new Scene(titleScreen, ScreenOptions.xSize, ScreenOptions.ySize);
        primaryStage.setScene(scene);
    
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}