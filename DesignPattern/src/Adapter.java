interface Target {
    void A();
}
class Adaptee {
    public void B() {
    }
}

class TranslatorAdapter implements Target {
    private Adaptee adaptee;
    public TranslatorAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void A() {
    }
}
public class Adapter {
    public static void main(String[] args) {
        Target client = new TranslatorAdapter(new Adaptee());
        client.A();
    }
}