package thread;

import java.util.logging.Logger;

/**
 * Created by vicriss on 16-2-27.
 */
public class Sell implements Runnable {
    public int tickets = 10;
    @Override
    public void run() {
        while (tickets > 0) {
//            synchronized (this) {
                Logger.getAnonymousLogger().info(Thread.currentThread().getName() + "   sell: " + tickets);
                try {
                    Thread.sleep(300);
//                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
//            }
        }
    }
}
