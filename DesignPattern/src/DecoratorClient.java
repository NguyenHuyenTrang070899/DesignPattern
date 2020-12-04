public class DecoratorClient {
    public static void main(String[] args) {
        IComponent c = new ConcreteComponent();
        IComponent ca = new ConcreteDecorator(c);
        ca.A();
    }
}
interface IComponent {
    void A();
}
class ConcreteComponent implements IComponent{
    public ConcreteComponent() {
    }
    public void A() { }
}
abstract class Decorator implements IComponent {
    protected IComponent component;
    public Decorator(IComponent component) {this.component = component; }
    public void A() {this.component.A();};
}
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(IComponent component) { super(component);}
    public void A() {super.A();}
}