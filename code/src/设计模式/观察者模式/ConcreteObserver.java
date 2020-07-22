package 设计模式.观察者模式;

public class ConcreteObserver implements Observer {

    private String observerState;
    private String name;
    private ConcreteSubject subject;
    public ConcreteObserver(ConcreteSubject subject, String name){
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subject.getState();
        System.out.println(name+"状态为"+observerState);
    }
}
