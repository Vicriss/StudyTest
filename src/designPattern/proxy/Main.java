package designPattern.proxy;

/**
 * Created by wybe on 2018/3/19.
 */
public class Main {
    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        Dao proxy = (Dao) new ProxyFactory(dao).getProxyInstance();
        proxy.save();
    }
}
