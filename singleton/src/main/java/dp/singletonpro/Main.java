package dp.singletonpro;

import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static int add(int x) {
        if (x == 0) {
            return 0;
        }
        return 1 + add(x-1);
    }

    public static void printData(Singleton s1, int y) {
        System.out.println(s1.getData());
        y = 12;
        s1.setData(30);
    }

    int x = 20;

    public static void changeX(Main m) {
        //m.x = 100;
        m = new Main(); // #100
        m.x = 100;
        String s = "Asd"; // primitive type behavior
        String name1 = "itay";
        String name2 = "itay";
        if (name1 == name2) {
            System.out.println("equal"); // WRONG !!
        }
        if (name1.equals(name2)) {
            System.out.println("equal"); // CORRECT !!
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Main m1 = new Main(); // #70
        Main m3 = m1;

        System.out.println(m1.x);
        m1.x = 20;
        changeX(m1);
        System.out.println(m1.x); // ? 100 ? 20
        System.out.println(m3.x); // ? 100 ? 20
        m1 = new Main();
        m1.x = 99;
        System.out.println(m3.x); // ? 100 ? 20 ? 99

        Person p1 = new Person(1, "Danny");
        Person p2 = new Person(1, "Danny");
        if (p1 == p2) {
            System.out.println("NOT happen");
        }
        if (p1.equals(p2)) {
            System.out.println("happen");
        }


        Main m2 = new Main();
        System.out.println(m2.x);

        System.out.println(Thread.currentThread().getName());

        AtomicReference<Singleton> sing2 = new AtomicReference<>();

        AtomicReference<Singleton> sing3 = new AtomicReference<>();

        Thread t1 = new Thread( () -> {
            System.out.println(Thread.currentThread().getName());
            sing2.set(Singleton.getInstance()); // sing2 = Singleton.getInstance();
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            sing3.set(Singleton.getInstance()); // sing3 = Singleton.getInstance();
        });
        t1.start();
        t2.start();

        Singleton sing1 =  Singleton.getInstance();
        int y = 20;
        t1.join();
        t2.join();
        
        //Singleton.INSTANCE = null;
        //Singleton.INSTANCE

        sing1.setData(30);
        printData(sing1, y);
        System.out.println(y); // 20? 12?

        System.out.println(sing1 == sing2.get() && sing2.get() == sing3.get());
    }
}
