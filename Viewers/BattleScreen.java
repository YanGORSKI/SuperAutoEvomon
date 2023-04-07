package Viewers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

import Models.Evomon;
import Models.EvomonList;
import Settings.ScreenOptions;

public class BattleScreen extends StackPane {
    private GameScreen gameScreen;
    
    private Evomon playerEvomon1;
    private Evomon playerEvomon2;
    private Evomon playerEvomon3;
    private Evomon playerEvomon4;
    private Evomon playerEvomon5;
    
    private EvomonViewer playerEvomonViewer1;
    private EvomonViewer playerEvomonViewer2;
    private EvomonViewer playerEvomonViewer3;
    private EvomonViewer playerEvomonViewer4;
    private EvomonViewer playerEvomonViewer5;

    private EvomonViewer enemyEvomonViewer1;
    private EvomonViewer enemyEvomonViewer2;
    private EvomonViewer enemyEvomonViewer3;
    private EvomonViewer enemyEvomonViewer4;
    private EvomonViewer enemyEvomonViewer5;

    private ArrayList<EvomonViewer> evomonViewers;

    private BattleTimer battleTimer;
    private boolean battleOver;

    public BattleScreen(GameScreen gameScreen, ArrayList<Evomon> playerTeam, ArrayList<Evomon> enemyTeam) {
        for (Evomon evomon : playerTeam) {
            System.out.println(evomon.toString());
        }
        for (Evomon evomon : enemyTeam) {
            System.out.println(evomon.toString());
        }
        System.out.println();
        
        this.gameScreen = gameScreen;
        
        // Create the BattleTimer and start it
        this.battleTimer = new BattleTimer(this);
        battleTimer.start();

        // Set the background image
        ImageView backgroundImage = new ImageView(new Image("Resources\\Background\\Battle Background.png"));
        backgroundImage.setFitWidth(ScreenOptions.xSize);
        backgroundImage.setFitHeight(ScreenOptions.ySize);
        getChildren().add(backgroundImage);
        setAlignment(backgroundImage, Pos.CENTER);

        // // Create the Evomons
        // Evomon breezowl = new Evomon(EvomonList.BREEZOWL);
        // EvomonViewer evomon1 = new EvomonViewer(breezowl);
        // evomon1.setTranslateX(-(ScreenOptions.xSize/2.25));
        // evomon1.setTranslateY(+(ScreenOptions.ySize/9));

        // Evomon scarfur = new Evomon(EvomonList.SCARFUR);
        // EvomonViewer evomon2 = new EvomonViewer(scarfur);
        // evomon2.setTranslateX(+(ScreenOptions.xSize/2.25));
        // evomon2.setTranslateY(+(ScreenOptions.ySize/9));;
        // evomon2.setScaleX(-1); // Mirror the sprite image of the Evomon on the right

        // // Add the Evomons to the stack pane
        // getChildren().addAll(evomon1, evomon2);

        evomonViewers = new ArrayList<EvomonViewer>();

        // Create the EvomonViewers
        for (int i = 0; i < playerTeam.size(); i++) {
            if (playerTeam.get(i)!=null) {
                System.out.println(playerTeam.get(i).toString());
                if (playerEvomonViewer1 == null) {
                    playerEvomonViewer1 = new EvomonViewer(playerTeam.get(i));
                    evomonViewers.add(playerEvomonViewer1);
                    playerEvomonViewer1.setTranslateX((-(ScreenOptions.xSize/2.25))+(4*(playerEvomonViewer1.getWidth()/2.3)));
                    playerEvomonViewer1.setTranslateY(+(ScreenOptions.ySize/6));
                    getChildren().add(playerEvomonViewer1);
                } else
                if (playerEvomonViewer2 == null) {
                    playerEvomonViewer2 = new EvomonViewer(playerTeam.get(i));
                    evomonViewers.add(playerEvomonViewer2);
                    playerEvomonViewer2.setTranslateX((-(ScreenOptions.xSize/2.25))+(3*(playerEvomonViewer1.getWidth()/2.3)));
                    playerEvomonViewer2.setTranslateY(+(ScreenOptions.ySize/6));
                    getChildren().add(playerEvomonViewer2);
                } else
                if (playerEvomonViewer3 == null) {
                    playerEvomonViewer3 = new EvomonViewer(playerTeam.get(i));
                    evomonViewers.add(playerEvomonViewer3);
                    playerEvomonViewer3.setTranslateX((-(ScreenOptions.xSize/2.25))+(2*(playerEvomonViewer1.getWidth()/2.3)));
                    playerEvomonViewer3.setTranslateY(+(ScreenOptions.ySize/6));
                    getChildren().add(playerEvomonViewer3);
                } else
                if (playerEvomonViewer4 == null) {
                    playerEvomonViewer4 = new EvomonViewer(playerTeam.get(i));
                    evomonViewers.add(playerEvomonViewer4);
                    playerEvomonViewer4.setTranslateX((-(ScreenOptions.xSize/2.25))+(1*(playerEvomonViewer1.getWidth()/2.3)));
                    playerEvomonViewer4.setTranslateY(+(ScreenOptions.ySize/6));
                    getChildren().add(playerEvomonViewer4);
                } else
                if (playerEvomonViewer5 == null) {
                    playerEvomonViewer5 = new EvomonViewer(playerTeam.get(i));
                    evomonViewers.add(playerEvomonViewer5);
                    playerEvomonViewer5.setTranslateX((-(ScreenOptions.xSize/2.25))+(0*(playerEvomonViewer1.getWidth()/2.3)));
                    playerEvomonViewer5.setTranslateY(+(ScreenOptions.ySize/6));
                    getChildren().add(playerEvomonViewer5);
                }
            } 
        }
        for (int i = 0; i < enemyTeam.size(); i++) {
            if (enemyTeam.get(i)!=null) {
                System.out.println(playerTeam.get(i).toString());
                if (enemyEvomonViewer1 == null) {
                    enemyEvomonViewer1 = new EvomonViewer(enemyTeam.get(i));
                    evomonViewers.add(enemyEvomonViewer1);
                    enemyEvomonViewer1.setTranslateX((+(ScreenOptions.xSize/2.25))-(4*(enemyEvomonViewer1.getWidth()/2.3)));
                    enemyEvomonViewer1.setTranslateY(+(ScreenOptions.ySize/6));
                    enemyEvomonViewer1.setScaleX(-1);
                    getChildren().add(enemyEvomonViewer1);
                } else
                if (enemyEvomonViewer2 == null) {
                    enemyEvomonViewer2 = new EvomonViewer(enemyTeam.get(i));
                    evomonViewers.add(enemyEvomonViewer2);
                    enemyEvomonViewer2.setTranslateX((+(ScreenOptions.xSize/2.25))-(3*(enemyEvomonViewer1.getWidth()/2.3)));
                    enemyEvomonViewer2.setTranslateY(+(ScreenOptions.ySize/6));
                    enemyEvomonViewer2.setScaleX(-1);
                    getChildren().add(enemyEvomonViewer2);
                } else
                if (enemyEvomonViewer3 == null) {
                    enemyEvomonViewer3 = new EvomonViewer(enemyTeam.get(i));
                    evomonViewers.add(enemyEvomonViewer3);
                    enemyEvomonViewer3.setTranslateX((+(ScreenOptions.xSize/2.25))-(2*(enemyEvomonViewer1.getWidth()/2.3)));
                    enemyEvomonViewer3.setTranslateY(+(ScreenOptions.ySize/6));
                    enemyEvomonViewer3.setScaleX(-1);
                    getChildren().add(enemyEvomonViewer3);
                } else
                if (enemyEvomonViewer4 == null) {
                    enemyEvomonViewer4 = new EvomonViewer(enemyTeam.get(i));
                    evomonViewers.add(enemyEvomonViewer4);
                    enemyEvomonViewer4.setTranslateX((+(ScreenOptions.xSize/2.25))-(1*(enemyEvomonViewer1.getWidth()/2.3)));
                    enemyEvomonViewer4.setTranslateY(+(ScreenOptions.ySize/6));
                    enemyEvomonViewer4.setScaleX(-1);
                    getChildren().add(enemyEvomonViewer4);
                } else
                if (enemyEvomonViewer5 == null) {
                    enemyEvomonViewer5 = new EvomonViewer(enemyTeam.get(i));
                    evomonViewers.add(enemyEvomonViewer5);
                    enemyEvomonViewer5.setTranslateX((+(ScreenOptions.xSize/2.25))-(0*(enemyEvomonViewer1.getWidth()/2.3)));
                    enemyEvomonViewer5.setTranslateY(+(ScreenOptions.ySize/6));
                    enemyEvomonViewer5.setScaleX(-1);
                    getChildren().add(enemyEvomonViewer5);
                }
            } 
        }

        for (int i = 0; i < getChildren().size(); i++) {
            System.out.println("Child " + i);
            System.out.println("Layout -> X: " + getChildren().get(i).getLayoutX() + " | Y: " + getChildren().get(i).getLayoutY());
            System.out.println("Translate -> X: " + getChildren().get(i).getTranslateX() + " | Y: " + getChildren().get(i).getTranslateY());
        }

        // Add a button to return to the main menu
        Button returnButton = new Button("Return to Main Menu");
        returnButton.setOnAction(event -> {
            MainMenu mainMenu = new MainMenu(gameScreen);
            Scene scene = new Scene(mainMenu, ScreenOptions.xSize, ScreenOptions.ySize);
            gameScreen.getPrimaryStage().setScene(scene);
            gameScreen.getPrimaryStage().show();
        });
        getChildren().add(returnButton);
        setAlignment(returnButton, Pos.BOTTOM_RIGHT);

        
    }

    // Update all the EvomonViewers
    public void updateViewers() {
        for (EvomonViewer evomonViewer : evomonViewers) {
            evomonViewer.update();
        }
    }

    // Start the BattleTimer
    public void startTimer() {
        battleTimer.start();
    }

    // Stop the BattleTimer
    public void stopTimer() {
        battleTimer.stop();
    }

    // Check if the battle is over
    public boolean isBattleOver() {
        return battleOver;
    }

    public ArrayList<EvomonViewer> getEvomonViewers() {
        return evomonViewers;
    }

}