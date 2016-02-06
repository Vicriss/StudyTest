package thread;

import java.awt.image.VolatileImage;

/**
 * Created by vicriss on 16-2-4.
 */
public class ThreadTest extends Thread {

    volatile boolean keepRunning = true;
    public void run() {
        int count = 0;
        while (keepRunning){
            System.out.println(getName() + ":running" + count);
            if (count > 10)
                keepRunning = false;
            count++;
            Thread.yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableTest implements Runnable {
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        int count = 0;
        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + ":running" + count);
            if (count > 10)
                keepRunning = false;
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}