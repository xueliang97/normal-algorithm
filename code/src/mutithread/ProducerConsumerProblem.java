package mutithread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblem {
    public static final int MAX_SIZE = 10;
    private static final LinkedList<Object> list = new LinkedList<>();
    private final static Lock lock= new ReentrantLock();

    private static final Condition full = lock.newCondition(); //仓库满的条件变量

    private static final Condition empty = lock.newCondition();//仓库空的条件变量

    static  class Producer implements Runnable{

        @Override
        public void run() {
            produce();
        }
    }

    static class Consumer implements  Runnable{

        @Override
        public void run() {
            consume();
        }
    }

    public static  void produce()  {
        lock.lock();
        while(list.size()==MAX_SIZE){
            System.out.println("仓库已满，容量："+list.size());
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        System.out.println(Thread.currentThread().getName()+"生产,仓库容量"+list.size());

        empty.signalAll();
        lock.unlock();
    }

    public static void consume()  {
        lock.lock();
        while(list.size()==0){
            System.out.println("仓库为空，容量："+list.size());
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove();//拿第一个
        System.out.println(Thread.currentThread().getName()+"消费,仓库容量"+list.size());

        full.signalAll();
        lock.unlock();
    }



    public static void main(String[] args){
        Thread thread1 = new Thread(new Producer(),"生产者1");
        Thread thread2 = new Thread(new Producer(),"生产者2");
        Thread thread3 = new Thread(new Producer(),"生产者3");

        Thread thread4 = new Thread(new Consumer(),"消费者1");
        Thread thread5 = new Thread(new Consumer(),"消费者2");
        Thread thread6 = new Thread(new Consumer(),"消费者3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
