package 设计模式.观察者模式;

public class Client {
    /**
     * 定义了一对多的依赖关系，让多个观察者同时监听一个主题对象，当主题对象状态发生改变时会通知所有观察者
     * @param args
     */
    public static void main(String[] args){
        ConcreteSubject subject = new ConcreteSubject();
        Observer o1  = new ConcreteObserver( subject,"观察者1");
        Observer o2 = new ConcreteObserver(subject,"观察者2");

        subject.registerObserver(o1);
        subject.registerObserver(o2);

        subject.setState("更新1");
        subject.notifyObserver();
        subject.unRegisterObserver(o1);
        subject.setState("更新2");
        subject.notifyObserver();
    }
}
