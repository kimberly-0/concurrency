package kd.threads;

import kd.semaphores.BinarySemaphore;

/*
 * This class is repsonsible for creating a thread that prints the letter "X"
 */
public class ThreadX extends Thread {

    BinarySemaphore w;
    BinarySemaphore x;

    public ThreadX(BinarySemaphore w, BinarySemaphore x) {
        this.w = w;
        this.x = x;
    }

    /**
     * Run method containing code which will be executed by the thread.
     */
    public void run() {
        while (true) {

            double random = Math.random() * 1000;
            try {
                sleep((long) random); // vary output sequence

                w.P(); // tell W to wait

                System.out.println('X'); // print X

                x.V(); // notify binary semaphore that X has been printed

                sleep(10); // interleave

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +
                        " was interrupted out of sleep");
            }
        }
    }
}