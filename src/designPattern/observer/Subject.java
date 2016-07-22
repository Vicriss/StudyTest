package designPattern.observer;

/**
 * Created by wybe on 7/22/16.
 */
public interface Subject {
    void register(Observer obj);
    void deleteObserver(Observer obj);
    void notifyObservers();
}
