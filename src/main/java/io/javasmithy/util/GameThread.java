package io.javasmithy.util;

import io.javasmithy.controller.game.GameController;

public class GameThread extends Thread {
    private GameController gc;

    public GameThread(GameController gameController) {
        this.setDaemon(true);
        this.gc = gameController;
    }

    @Override
    public void run() {
        System.out.println("Log: starting GC run thread.");
        this.gc.run();
    }
}