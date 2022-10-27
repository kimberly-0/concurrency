package kd.threads;

import kd.semaphores.*;

/*
 * This class is repsonsible for creating a thread that prints the letter "W"
 */
public class ThreadW extends Thread {

    BinarySemaphore w;
    BinarySemaphore x;
    Semaphore sumYZ; // counting semaphore

    public ThreadW(BinarySemaphore w, BinarySemaphore x, Semaphore sumYZ) {
        this.w = w;
        this.x = x;
        this.sumYZ = sumYZ;
    }

    /**
     * Run method containing code which will be executed by the thread.
     */
    public void run() {
        while (true) {

            double random = Math.random() * 1000;
            try {
                sleep((long) random); // vary output sequence

                x.P(); // tell X to wait

                System.out.println('W'); // print W

                w.V(); // notify binary semaphore that W has been printed

                sumYZ.V(); // notify counting semaphore that W has been printed

                sleep(10); // interleave

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +
                        " was interrupted out of sleep");
            }
        }
    }
}