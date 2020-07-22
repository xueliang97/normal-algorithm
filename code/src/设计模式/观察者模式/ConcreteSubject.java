package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    List<Observer> list;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;
    ConcreteSubject(){
        list = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer o:list){
            o.update();
        }
    }
}
