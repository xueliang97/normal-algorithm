package 设计模式.单例模式;

/**
 * 单例
 */
public class Singleton {
    /**
     * 饿汉模式 线程安全
     */
//    private static Singleton singleton1 = new Singleton();
//    private Singleton(){
//    }
//    public static Singleton getInstance(){
//        return singleton1;
//    }

    /**
     *  懒汉模式 线程不安全
     */
//    private static Singleton singleton2;
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        if (singleton2==null)
//            singleton2 = new Singleton();
//        return singleton2;
//    }


    /**
     * 静态内部类实现,线程安全
     */
    private Singleton(){

    }
    private static class Single{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return Single.INSTANCE;
    }



    /**
     *  双重检查
     */
//    private static volatile Singleton singleton3;
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        //是否创建了对象，所有线程都要执行
//        if (singleton3==null){
//            synchronized (Singleton.class){
//                if (singleton3==null){//避免重复创建，多线程下会在synchronized阻塞不再加判断会重复创建
//                    singleton3 = new Singleton();
//                }
//            }
//        }
//        return singleton3;
//    }


}
