package Viewers;

import Settings.ScreenOptions;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ActBar extends StackPane{
    
    private Rectangle wFrame;
    private Rectangle bFrame;
    private Rectangle fill;
    double width;
    double height;

    public ActBar(EvomonViewer evomon) {
        width = 100*(1280/ScreenOptions.xSize);
        height= 10*(720/ScreenOptions.ySize);
        fill = new Rectangle(0, height, Color.YELLOW);
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

    public void setACT(double currentInit) {
        double actPercentage = currentInit / 100;
        if (actPercentage > 1) actPercentage = 1;
        fill.setWidth(wFrame.getWidth() * actPercentage);
    }
}