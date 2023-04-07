package Viewers;

import Settings.ScreenOptions;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HPBar extends StackPane{
    
    private Rectangle wFrame;
    private Rectangle bFrame;
    private Rectangle fill;
    double width;
    double height;

    public HPBar(EvomonViewer evomon) {
        width = 100*(1280/ScreenOptions.xSize);
        height= 10*(720/ScreenOptions.ySize);
        fill = new Rectangle(width, height, Color.RED);
        wFrame = new Rectangle(width, height);
        wFrame.setStrokeWidth(2);
        wFrame.setFill(Color.TRANSPARENT);
        wFrame.setStroke(Color.WHITE);
        bFrame = new Rectangle(width-3, height-3);
        bFrame.setStrokeWidth(3);
        bFrame.setFill(Color.TRANSPARENT);
        bFrame.setStroke(Color.BLACK);
        getChildren().addAll(fill, bFrame, wFrame);
    }

    public void setHP(double currentHealth, double maxHealth) {
        double healthPercentage = currentHealth / maxHealth;
        if (healthPercentage < 0) healthPercentage = 0; 
        fill.setWidth(wFrame.getWidth() * healthPercentage);
    }
}