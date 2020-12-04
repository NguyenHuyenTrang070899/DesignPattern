public class CommandClient {
    public static void main(String[] args) {
        Receiver r = new Receiver();
        Command c = new ConcreteCommand(r);
        Invoker invoker = new Invoker(c);
        invoker.method();
    }
}
class Receiver {
    public void action() {}
}
interface Command {
    void A();
}
class ConcreteCommand implements Command {
    private Receiver receiver;
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    public void A() {
        receiver.action();
    }
}
class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void method() {
        command.A();
    }
}