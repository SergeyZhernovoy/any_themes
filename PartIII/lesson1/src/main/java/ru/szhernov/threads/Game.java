package ru.szhernov.threads;/**
 * Created by Admin on 01.04.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Game implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private Thread gameThread;

    public Game() {
        this.gameThread = new Thread(this,"Main thread game");
    }

    @Override
    public void run() {
        int i =0;

        System.out.println("работает поток "+ Thread.currentThread().getName()+" "+ i);
    }


    public void start(){
        this.gameThread.start();
    }

    public static void main(String[] args) {
        new Game().start();
    }

}
