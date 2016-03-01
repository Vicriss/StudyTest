package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vicriss on 16-2-4.
 */
public class Main {
    public static void main(String[] args) {
        Sell sell = new Sell();
        ThreadTest tt = new ThreadTest();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.execute(sell);
//            es.execute(tt);
        }
        es.shutdown();
    }
}
