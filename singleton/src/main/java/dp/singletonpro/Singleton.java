package dp.singletonpro;

public class Singleton {
    // one instance of a class
    // with public access



    //private static Object obj = new Object(); // var a = { }

    private static Singleton INSTANCE;
    private int data;
    private int[] arr = { 1,2,3};

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void foo() {

    }

}
