package com.codurance;

import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife {

    private final Grid inputGrid;
    private final int totalIterations;
    Timer timer;

    public GameOfLife(Grid inputGrid, int totalIterations) {
        this.inputGrid = inputGrid;
        this.totalIterations = totalIterations;
        timer = new Timer();
        timer.schedule(new RunTask(), 2000, 1000);
    }

    class RunTask extends TimerTask {
        private int currentIterationCount = 0;
        private Grid currentGen = inputGrid;

        public RunTask() {
            System.out.println(formatter(currentIterationCount));
            System.out.println(inputGrid);
        }

        public void run() {
            currentIterationCount++;
            if (currentIterationCount <= totalIterations) {
                System.out.println(formatter(currentIterationCount));
                currentGen = currentGen.nextGen();
                System.out.println(currentGen);
            } else {
                System.out.println(formatter(currentIterationCount));
                System.exit(0);
            }
        }

        public String formatter(int i){
            StringBuffer strBuffer = new StringBuffer();
            if (i == 0){
                strBuffer.append("-------------[ INITIAL GEN V").append(i);
            } else if (i <= totalIterations) {
                strBuffer.append("---------------[ NEXT GEN V").append(i);
            }
            else {
                strBuffer.append("-------------[ SIMULATION COMPLETE: ")
                        .append(totalIterations)
                        .append(" GENERATIONS CREATED");
            }
            strBuffer.append(" ]---------------");
            return strBuffer.toString();
        }
    }
}
