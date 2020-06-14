package mutithread;

public class DeadLock {
    private static final Object obj1= new Object();
    private static final Object obj2= new Object();


    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+"获得资源1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"等待获得资源2");
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+"获得资源2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+"获得资源2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"等待获得资源1");
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName()+"获得资源1");
                    }
                }
            }
        }).start();
    }

}
