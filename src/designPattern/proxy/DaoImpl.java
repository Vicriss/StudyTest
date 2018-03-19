package designPattern.proxy;

/**
 * Created by wybe on 2018/3/19.
 */
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("save data");
    }
}
