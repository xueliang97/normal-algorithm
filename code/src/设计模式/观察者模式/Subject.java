package 设计模式.观察者模式;

public interface Subject {
    void registerObserver(Observer observer);

    void unRegisterObserver(Observer observer);

    void notifyObserver();

}
