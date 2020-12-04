public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new State1());
        context.applyState();
        context.setState(new State2());
        context.applyState();
    }
}
interface State {
    void A();
}
class State1 implements State {
    @Override
    public void A() {
    }
}
class State2 implements State {
    @Override
    public void A() {
    }
}

class Context {
    private State state;
    public void setState(State state) {
        this.state = state;
    }
    public void applyState() {
        this.state.A();
    }
}
