package Viewers;

import Settings.ScreenOptions;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SPBar extends StackPane{
    
    private Rectangle wFrame;
    private Rectangle bFrame;
    private Rectangle fill;
    double width;
    double height;

    public SPBar(EvomonViewer evomon) {
        width = 100*(1280/ScreenOptions.xSize);
        height= 10*(720/ScreenOptions.ySize);
        fill = new Rectangle(0, height, Color.BLUE);
        wFrame = new Rectangle(width, height);
        wFrame.setStrokeWidth(3);
        wFrame.setFill(Color.TRANSPARENT);
        wFrame.setStroke(Color.WHITE);
        bFrame = new Rectangle(width-3, height-3);
        bFrame.setStrokeWidth(3);
        bFrame.setFill(Color.TRANSPARENT);
        bFrame.setStroke(Color.BLACK);
        getChildren().addAll(fill, bFrame, wFrame);
    }

    public void setSP(double currentSP) {
        double spPercentage = currentSP / 100;
        if (spPercentage > 1) spPercentage = 1;
        fill.setWidth(wFrame.getWidth() * spPercentage);
    }
}