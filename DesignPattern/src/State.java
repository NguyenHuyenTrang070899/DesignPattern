public class State {
    public static void main(String[] args) {
        DocumentContext context = new DocumentContext();
        context.setState(new NewState());
        context.applyState();

        context.setState(new SubmittedState());
        context.applyState();

        context.setState(new ApprovedState());
        context.applyState();
        context.setState(new RejectedState());
        context.applyState();
    }
}
interface IState {

    void handleRequest();
}
class NewState implements IState {

    @Override
    public void handleRequest() {
        System.out.println("Create a new document");
    }
}
class SubmittedState implements IState {

    @Override
    public void handleRequest() {
        System.out.println("Submitted");
    }
}
class ApprovedState implements IState {

    @Override
    public void handleRequest() {
        System.out.println("Approved");
    }
}
class RejectedState implements IState {

    @Override
    public void handleRequest() {
        System.out.println("Rejected");
    }
}
class DocumentContext {

    private IState state;

    public void setState(IState state) {
        this.state = state;
    }

    public void applyState() {
        this.state.handleRequest();
    }
}
