package thread;

import java.awt.image.VolatileImage;
import java.util.logging.Logger;

/**
 * Created by vicriss on 16-2-4.
 */
public class ThreadTest extends Thread {

    volatile boolean keepRunning = true;
    public synchronized void run() {
        int count = 0;
        while (keepRunning){
            Logger.getAnonymousLogger().info(getName() + "  running: " + count);
            if (count > 10)
                keepRunning = false;
            count++;
            try {
                Thread.sleep(1000);
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

