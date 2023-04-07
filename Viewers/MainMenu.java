package Viewers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

import Models.Evomon;
import Models.EvomonList;
import Settings.ScreenOptions;

public class MainMenu extends StackPane {
    private GameScreen gameScreen;
    private int currentOption = 0;
    private String[] options = {"Play", "Options", "Exit"};
    private Text[] optionTexts;

    public MainMenu(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        ImageView imageView = new ImageView(new Image("file:Resources/Text/Evomon Title.png"));
        imageView.setFitWidth(ScreenOptions.xSize * 0.99);
        imageView.setFitHeight(ScreenOptions.ySize * 0.40);

        VBox vbox = new VBox(30, imageView);
        vbox.setAlignment(Pos.CENTER);

        optionTexts = new Text[options.length];
        for (int i = 0; i < options.length; i++) {
            Text optionText = new Text(options[i]);
            optionText.setFont(Font.font("Consolas", FontWeight.BOLD, 30));
            optionText.setFill(Color.WHITE);

            int optionIndex = i;
            
            optionText.setOnMouseEntered(e -> {
                optionText.setFill(Color.GREEN);
            });
            optionText.setOnMouseExited(e -> {
                optionText.setFill(Color.WHITE);
                currentOption = -1; // reset currentOption
            });
            optionText.setOnMouseClicked(e -> {
                selectOption(optionIndex);
            });
            
            optionTexts[optionIndex] = optionText;
            vbox.getChildren().add(optionText);
        }

        getChildren().addAll(vbox);
        setPrefSize(ScreenOptions.xSize, ScreenOptions.ySize);
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                currentOption--;
                if (currentOption < 0) {
                    currentOption = options.length - 1;
                }
                updateButtonColors();
            } else if (e.getCode() == KeyCode.DOWN) {
                currentOption++;
                if (currentOption >= options.length) {
                    currentOption = 0;
                }
                updateButtonColors();
            } else if (e.getCode() == KeyCode.ENTER) {
                selectOption(currentOption);
            }
        });
    }
    
    private void updateButtonColors() {
        for (int i = 0; i < options.length; i++) {
            Text optionText = optionTexts[i];
            if (currentOption == i) {
                optionText.setFill(Color.GREEN);
            } else {
                optionText.setFill(Color.WHITE);
            }
        }
        if (currentOption == -1) {
            for (Text optionText : optionTexts) {
                optionText.setFill(Color.WHITE);
            }
        }
    }
    
    private void selectOption(int optionIndex) {
        //FOR TESTING ONLY
        //THE BATTLESCREEN WILL RECEIVE THE TEAM FROM THE SHOP SCREEN
        ArrayList<Evomon> playerTeam = new ArrayList<Evomon>();
        Evomon breezowl = new Evomon(EvomonList.BREEZOWL);
        Evomon scarfur2 = new Evomon(EvomonList.SCARFUR);
        Evomon breezowl3 = new Evomon(EvomonList.BREEZOWL);
        Evomon scarfur4 = new Evomon(EvomonList.SCARFUR);
        Evomon breezowl4 = new Evomon(EvomonList.BREEZOWL);
        playerTeam.add(breezowl);
        playerTeam.add(scarfur2);
        playerTeam.add(breezowl3);
        playerTeam.add(scarfur4);
        playerTeam.add(breezowl4);
        
        ArrayList<Evomon> enemyTeam = new ArrayList<Evomon>();
        Evomon scarfur = new Evomon(EvomonList.SCARFUR);
        Evomon breezowl2 = new Evomon(EvomonList.BREEZOWL);
        Evomon scarfur3 = new Evomon(EvomonList.SCARFUR);
        Evomon breezowl5 = new Evomon(EvomonList.BREEZOWL);
        Evomon scarfur5 = new Evomon(EvomonList.SCARFUR);
        enemyTeam.add(scarfur);
        enemyTeam.add(breezowl2);
        enemyTeam.add(scarfur3);
        enemyTeam.add(breezowl5);
        enemyTeam.add(scarfur5);
                                                            
        switch (optionIndex) {
            case 0:
                // Create an instance of the BattleScreen class
                BattleScreen battleScreen = new BattleScreen(gameScreen, playerTeam, enemyTeam);
                
                // Set the BattleScreen as the current scene
                Scene scene = new Scene(battleScreen, ScreenOptions.xSize, ScreenOptions.ySize);
                gameScreen.getPrimaryStage().setScene(scene);
                gameScreen.getPrimaryStage().show();
                break;
            case 1:
                // Handle the "Options" option
                break;
            case 2:
                // Handle the "Exit" option
                break;
        }
    }
}