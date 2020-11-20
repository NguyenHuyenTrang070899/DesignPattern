class Singleton {
    private String state = "1";
    private static Singleton instance = null;
    private Singleton() { }
    public static Singleton Instance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void print() {
        System.out.println(state);
    }

    public void next() {
        if (state.compareTo("1") == 0) {
            state = "2";
        }
        else if (state.compareTo("2") == 0) {
            state = "3";
        }
        else if (state.compareTo("3") == 0) {
            state = "1";
        }
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.Instance();
        s1.print();               // use Singleton: 1 - not use: 1
        s1.next();
        s1.print();               // use Singleton: 2 - not use: 2

        Singleton s2 = Singleton.Instance();
        s2.print();               // use Singleton: 2 - not use: 1
        s1.print();               // use Singleton: 2 - not use: 2
        s2.next();
        s2.print();               // use Singleton: 3 - not use: 2
        s1.print();               // use Singleton: 3 - not use: 2
    }
}
