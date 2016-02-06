package thread;

/**
 * Created by vicriss on 16-2-4.
 */
public class Main extends Thread{

    public void run() {
        ThreadTest tt = new ThreadTest();
        RunnableTest rt = new RunnableTest();
        Thread rtt = new Thread(rt,"rt");
        tt.setName("hh");
        tt.start();
        rtt.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
