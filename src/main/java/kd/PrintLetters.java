package kd;

import kd.semaphores.*;
import kd.threads.*;

public class PrintLetters {

    public static void main(String[] args) throws InterruptedException {

        /*
         * Create binary semaphores to track each letter (for alternation between "W"
         * and "X", and alternation between "y" and "z")
         * Values of the "X" and "z" binary semaphores are set to 1 to indicate that the
         * event has already occurred so that the other letter will be printed first
         */
        BinarySemaphore w = new BinarySemaphore(0);
        BinarySemaphore x = new BinarySemaphore(1);
        BinarySemaphore y = new BinarySemaphore(0);
        BinarySemaphore z = new BinarySemaphore(1);

        /*
         * Create a counting semaphore to ensure that the total number of "y"s and "z"s
         * that have been output at any given point in the output string does not exceed
         * the number of "W"s that have been output up to that point
         */
        Semaphore sumYZ = new Semaphore();

        /*
         * Create a new thread for each letter: "W", "X", "y" and "z"
         */
        Thread TW = new ThreadW(w, x, sumYZ);
        Thread TX = new ThreadX(w, x);
        Thread TY = new ThreadY(y, z, sumYZ);
        Thread TZ = new ThreadZ(y, z, sumYZ);

        /*
         * Start all four threads (invoke their run methods)
         */
        TW.start();
        TX.start();
        TY.start();
        TZ.start();

        /*
         * Let the threads sleep after 10 seconds and terminate the program
         */
        Thread.sleep(10000);
        System.exit(0);
    }
}