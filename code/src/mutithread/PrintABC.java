package mutithread;

public class PrintABC {
    static int  count = 0;

    static class Task implements Runnable{

        String character;
        int num;

        Task(String character,int num){
            this.character = character;
            this.num = num;
        }

        @Override
        public void run() {
            int i=0;
            while(i<10){
                synchronized (Task.class){

                    if(count%3 == num){
                        count++;
                        System.out.println(Thread.currentThread().getName() +" "+character);

                    }else
                        continue;
                }
                i++;
            }
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new Task("A",0)," 线程1");
        Thread thread2 = new Thread(new Task("B",1)," 线程2");
        Thread thread3 = new Thread(new Task("C",2)," 线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
