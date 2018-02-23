package pattern_singleton;

public class Singleton {
    private volatile static Singleton uniqueRef;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(uniqueRef == null) {
            synchronized (Singleton.class) {
                if(uniqueRef == null) {
                    uniqueRef = new Singleton();
                }
            }
        }
        return uniqueRef;
    }

}
