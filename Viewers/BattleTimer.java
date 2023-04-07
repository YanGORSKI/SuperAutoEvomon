package Viewers;

import java.util.Date;

import javafx.animation.AnimationTimer;

public class BattleTimer extends AnimationTimer {
    private BattleScreen battleScreen;
    private long lastTime;

    public BattleTimer(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
        this.lastTime = System.nanoTime();
    }

    @Override
    public void handle(long now) {
        System.out.println("TICK: " + new Date().getTime());
        // Calculate the time elapsed since the last tick
        double elapsedSeconds = (now - lastTime) / 1e9;
        
        // Update the initiative of all the Evomons
        for (EvomonViewer evomonV : battleScreen.getEvomonViewers()) {
            System.out.println(evomonV.evomon.getName() + " - "
                                + evomonV.evomon.getHp().getCurrent()+ "|"
                                + evomonV.evomon.getSp().getCurrent() + "|"
                                + evomonV.evomon.getInit().getCurrent());
            evomonV.evomon.increaseInitiative(elapsedSeconds);
        }

        // Update the HP and SP bars of all the EvomonViewers
        battleScreen.updateViewers();

        // Check if the battle is over
        if (battleScreen.isBattleOver()) {
            this.stop();
            // Do something to end the battle
        }

        // Update the lastTime variable
        lastTime = now;
    }
}