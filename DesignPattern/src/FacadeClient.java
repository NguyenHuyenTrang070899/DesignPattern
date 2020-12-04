public class FacadeClient {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.start1();
        f.start2();
    }
}
interface A {
    void action();
}
class Subsystem1 implements A {
    @Override
    public void action() {
    }
}
class Subsystem2 implements A {
    @Override
    public void action() {
    }
}
class Facade {
    private A subsystem1;
    private A subsystem2;
    public Facade() {
        subsystem1 = new Subsystem1();
        subsystem2 = new Subsystem2();
    }
    public void start1() {
        subsystem1.action();
    }
    public void start2() {
        subsystem2.action();
    }
}