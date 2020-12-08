public class FactoryClient { //Client
    public static void main(String[] args) {
        Superclass s = Factory.getSub(Type.SUB1);
        System.out.println(s);
    }
}
interface Superclass {
    vói A();
}
class Sub1 implements Superclass {
    public void A() { }
}
class Sub2 implements Superclass {
    public void A() { }
}
enum Type {
    SUB1, SUB2;
}
class Factory {
    private Factory() { }
    public static final Superclass getSub(Type type) {
        switch(type) {
            case SUB1:
                return new Sub1();
            case SUB2:
                return new Sub2();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
