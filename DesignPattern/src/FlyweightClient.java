import java.util.HashMap;

public class FlyweightClient {
    public static void main(String[] args) {
        ConcreteFly c = (ConcreteFly) FlyweightFactory.getFlyweight("a");
        c.A();
    }
}
interface Flyweight {
    public void A();
}
class ConcreteFly implements Flyweight {
    private String name;
    public ConcreteFly(String name) {
        this.name = name;
    }
    @Override
    public void A() {
    }
}
class FlyweightFactory {
    private static final HashMap f = new HashMap();
    public static Flyweight getFlyweight(String name) {
        ConcreteFly c = (ConcreteFly) f.get(name);
        if(c == null) {
            c = new ConcreteFly(name);
            f.put(name, c);
        }
        return c;
    }
}