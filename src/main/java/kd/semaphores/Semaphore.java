package kd.semaphores;

/**
 * This class was derived from the coursework specification made available by Dr
 * Sulaiman Lawal and Dr Stephen Riddle, Newcastle University.
 * Source - CSC8016 Advanced Programming Coursework Specification
 * Original Authors - Dr Sulaiman Lawal and Dr Stephen Riddle
 */

public class Semaphore {

    protected int value;

    public Semaphore() {
        value = 0;
    }

    public Semaphore(int initial) {
        value = (initial >= 0) ? initial : 0;
    }

    public synchronized void P() throws InterruptedException {
        while (value == 0) {
            wait();
        }
        value--;
    }

    public synchronized void V() {
        value++;
        notify();
    }
}