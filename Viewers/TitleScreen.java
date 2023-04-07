package Viewers;

import Settings.ScreenOptions;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TitleScreen extends StackPane {

    private MainMenu menu;
    private GameScreen gameScreen;

    public TitleScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.setStyle("-fx-background-color: black");
        this.setPrefSize(ScreenOptions.xSize, ScreenOptions.ySize);

        menu = new MainMenu(gameScreen);

        ImageView titleImage = new ImageView(new Image("Resources/Text/Evomon Title.png"));
        titleImage.setFitWidth(this.getPrefWidth() * 0.99);
        titleImage.setFitHeight(this.getPrefHeight() * 0.4);
        titleImage.setX(this.getPrefWidth() * 0.01);
        titleImage.setY(this.getPrefHeight() * 0.01);

        Label startLabel = new Label("Press Enter to Start");
        startLabel.setStyle("-fx-font-family: Consolas; -fx-font-size: 20; -fx-text-fill: white;");
        startLabel.setTranslateY(50);

        VBox vBox = new VBox(titleImage, startLabel);
        vBox.setAlignment(Pos.CENTER);
        this.getChildren().add(vBox);
        
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    getChildren().clear();
                    getChildren().add(menu);
                    menu.requestFocus();
                }
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getChildren().clear();
                getChildren().add(menu);
                menu.requestFocus();
            }
        });

        this.requestFocus();
    }
}