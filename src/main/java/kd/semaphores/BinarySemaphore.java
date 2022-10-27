package kd.semaphores;

public class BinarySemaphore extends Semaphore {

    public BinarySemaphore(int initial) {
        super();
        value = (initial > 0) ? 1 : 0;
    }

}
