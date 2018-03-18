package thread.ThreadLocal;

/**
 * Created by wybe on 2018/3/18.
 */
public class MyThreadLocal implements Runnable{

    private ThreadLocal<String> threadLocal;

    public MyThreadLocal(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        setStr();
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    }

    public void setStr() {
        threadLocal.set(Thread.currentThread().getName());
    }
}
