package com.codurance;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife {

    private Grid inputGrid;
    private final int iterations;
    Timer timer;

    public GameOfLife(Grid inputGrid, int iterations) {
        this.inputGrid = inputGrid;
        this.iterations = iterations;
        timer = new Timer();
        timer.schedule(new RunTask(), 2000, 2000);
    }

    class RunTask extends TimerTask {
        private int count = 0;
        private Grid currentGen = inputGrid;

        public RunTask() {
            System.out.println(formatter(count));
            System.out.println(inputGrid);
        }

        public void run() {
            count++;
            if (count <= iterations) {
                System.out.println(formatter(count));
                currentGen = currentGen.nextGen();
                System.out.println(currentGen);
            } else {
                System.out.println("SIMULATION COMPLETE: " + iterations + " GENERATIONS CREATED");
                //timer.cancel(); Not necessary because we call System.exit
                // Stops the AWT thread (and everything else)
                System.exit(0);
            }
        }

        public StringBuffer formatter(int i){
            StringBuffer stringBuffer = new StringBuffer();
            if (i==0){
                stringBuffer.append("--------------");
                stringBuffer.append("INITIAL GEN [V" + i + "]");
                stringBuffer.append("--------------");
            }
            else {
                stringBuffer.append("----------------");
                stringBuffer.append("NEXT GEN [V" + i + "]");
                stringBuffer.append("----------------");
            }
            return stringBuffer;
        }

    }
}


//
//        timer.schedule(new TimerTask() {
//        Grid nextGenGrid = inputGrid.nextGen();
//        nextGenGrid = nextGenGrid.nextGen();
//        counter++;
//
//        if (counter >= iterations) {
//            timer.cancel();
//        }
//        System.out.println(stringBuffer);
//    }
    
    
    
    

