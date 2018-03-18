package thread.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wybe on 2018/3/18.
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            MyThreadLocal myThreadLocal = new MyThreadLocal(threadLocal);
            myThreadLocal.setStr();
            executor.execute(myThreadLocal);
            System.out.println(threadLocal.get());
        }
        executor.shutdown();
    }
}
