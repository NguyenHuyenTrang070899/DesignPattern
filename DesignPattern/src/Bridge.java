public class Bridge {
    public static void main(String[] args) {
        Abstract a1 = new Abstract1(new Implement1());
        a1.A();
    }
}
interface Implement {
    void A();
}
class Implement1 implements Implement {
    @Override
    public void A() {
    }
}

abstract class Abstract {
    protected Implement implement;
    public Abstract(Implement implement) {
        this.implement = implement;
    }
    public abstract void A();
}
class Abstract1 extends Abstract {

    public Abstract1(Implement implement) {
        super(implement);
    }
    @Override
    public void A() {
        implement.A();
    }
}
