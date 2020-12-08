public class AbstractFactory {
    public static void main(String[] args) {
        SuperAbstractFactory f = SupewrFactory.getFactory(FactoryType.FACTORY1);
        Superclass1 s1 = f,method1();
        s1.A();
    }
}
interface Superclass1 {
    void A();
}
class Subclass1 implements Superclass1 {
    @Override
    public void A() {
    }
}
class Subclass2 implements Superclass1 {
    @Override
    public void A() {
    }
}
interface Superclass2 {
    void B();
}
class Subclass3 implements Superclass2 {
    @Override
    public void B() {
    }
}
class Subclass4 implements Superclass2 {
    @Override
    public void B() {
    }
}
enum FactoryType {
    FACTORY1, FACTORY2;
}
abstract class SuperAbstractFactory {
    public abstract Chair method1();
    public abstract Table method2();
}
class Factory1 extends SuperAbstractFactory {
    @Override
    public Superclass1 method1() {
        return new Subclass1();
    }
    @Override
    public Superclass2 method2() {
        return new Subclass3();
    }
}
class Factory2 extends SuperAbstractFactory {
    @Override
    public Superclass1 method1() {
        return new Subclass2();
    }
    @Override
    public Superclass2 method2() {
        return new Subclass4();
    }
}
class SuperFactory {
    private SuperFactory() {
    }
    public static SuperAbstractFactory getFactory(FactoryType type) {
        switch (type) {
            case FACTORY1:
                return new Factory1();
            case FACTORY2:
                return new Factory2();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
