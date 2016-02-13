package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vicriss on 16-2-4.
 */
public class Main extends Thread{

    public void run() {
        ThreadTest tt = new ThreadTest();
        RunnableTest rt = new RunnableTest();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(tt);
        es.execute(new ThreadTest());
//        Thread rtt = new Thread(rt,"rt");
//        tt.setName("hh");
//        tt.start();
//        rtt.start();




        tt.keepRunning = false;
        rt.keepRunning = false;

//        try {
//            rtt.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {
        new Main().start();
    }
}
