public class ChainOfResponsibility {
    public static void main(String[] args) {
        WorkFlow.getB().method(new A("TT"));
    }
}
class A {
    private String name;
    public A(String name) {
        this.name = name;
    }
}
abstract class B {
    protected B nextB;
    public void setNext(B b) {
        this.nextB = b;
    }
    public void method(A a) {
    }
}
class B1 extends B { }
class B2 extends B { }
class WorkFlow {
    public static B getB() {
        B b1 = new B1();
        B b2 = new B2();
        b1.setNext(b2);
        return b1;
    }
}
    
