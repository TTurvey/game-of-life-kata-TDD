package com.codurance;

import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife {

    public static void play(Grid input, int iterations){
        System.out.println(input);

        Timer timer = new Timer();
        int begin = 1000;
        int timeInterval = 3000;

        timer.schedule(new TimerTask() {
            int counter = 0;
            Grid nextGenGrid = input.nextGen();

            @Override
            public void run() {
                System.out.println(nextGenGrid);
                nextGenGrid = nextGenGrid.nextGen();
                counter++;

                if (counter >= iterations) {
                    timer.cancel();
                }
            }
        }, begin, timeInterval);
    }
}
