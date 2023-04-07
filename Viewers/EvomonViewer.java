package Viewers;

import Models.Evomon;
import Settings.ScreenOptions;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class EvomonViewer extends StackPane{
    Evomon evomon;
    ImageView sprite;
    private HPBar hpBar;
    private SPBar spBar;
    private ActBar actBar;

    public EvomonViewer(Evomon evomon) {
        this.evomon = evomon;
        this.setWidth(250*(ScreenOptions.xSize/1280));
        this.setHeight(250*(ScreenOptions.ySize/720));

        // Set the sprite image
        this.sprite = new ImageView(new Image(evomon.getSprite()));
        this.sprite.setFitWidth(225*(ScreenOptions.xSize/1280));
        this.sprite.setFitHeight(225*(ScreenOptions.ySize/720));
        
        // Add the HPBar
        hpBar = new HPBar(this); // Pass a reference to this EvomonViewer object
        hpBar.setTranslateY(this.getHeight() / 2);

        // Add the SPBar
        spBar = new SPBar(this); // Pass a reference to this EvomonViewer object
        spBar.setTranslateY((this.getHeight() / 2) + hpBar.height);

        // Add the ActBar
        actBar = new ActBar(this); // Pass a reference to this EvomonViewer object
        actBar.setTranslateY((this.getHeight() / 2) + hpBar.height + spBar.height);


        getChildren().add(sprite);
        setAlignment(sprite, Pos.CENTER);
        getChildren().add(hpBar);
        setAlignment(hpBar, Pos.CENTER);
        getChildren().add(spBar);
        setAlignment(spBar, Pos.CENTER);
        getChildren().add(actBar);
        setAlignment(actBar, Pos.CENTER);
    }

    public void update() {
        this.hpBar.setHP(this.evomon.getHp().getCurrent(), this.evomon.getHp().getBase());
        this.spBar.setSP(this.evomon.getSp().getCurrent());
        this.actBar.setACT(this.evomon.getInit().getCurrent());
    }

   
    

}
