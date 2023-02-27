package dp.singletonpro;

import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Singleton sing1 =  Singleton.getInstance();
        AtomicReference<Singleton> sing2 = new AtomicReference<>();
        AtomicReference<Singleton> sing3 = new AtomicReference<>();
        
        Thread t1 = new Thread( () -> {
            System.out.println(Thread.currentThread().getName());
            sing2.set(Singleton.getInstance());
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            sing3.set(Singleton.getInstance());
        });
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        //Singleton.INSTANCE = null;
        //Singleton.INSTANCE

        System.out.println(sing1 == sing2.get() && sing2.get() == sing3.get());
    }
}
