public class ChainOfResponsibility {
    public static void main(String[] args) {
        LeaveRequestWorkFlow.getApprover().approveLeave(new LeaveRequest(3));
        System.out.println("---");
        LeaveRequestWorkFlow.getApprover().approveLeave(new LeaveRequest(5));
    }
}
class LeaveRequest {
    private int days;
    public LeaveRequest(int days) {
        this.days = days;
    }
    public int getDays() {
        return days;
    }
}
abstract class Approver {
    protected Approver nextApprover;
    public void approveLeave(LeaveRequest request) {
        if (this.canApprove(request.getDays())) {
            this.doApproving(request);
        } else if (nextApprover != null) {
            nextApprover.approveLeave(request);
        }
    }
    public void setNext(Approver approver) {
        this.nextApprover = approver;
    }
    protected abstract boolean canApprove(int numberOfDays);
    protected abstract void doApproving(LeaveRequest request);
}
class Supervisor extends Approver {
    @Override
    protected boolean canApprove(int numberOfDays) {
        return numberOfDays <= 3;
    }
    @Override
    protected void doApproving(LeaveRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Supervisor");
    }
}
class DeliveryManager extends Approver {
    @Override
    protected boolean canApprove(int numberOfDays) {
        return numberOfDays > 3;
    }
    @Override
    protected void doApproving(LeaveRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Delivery Manager");
    }
}
class LeaveRequestWorkFlow {
    public static Approver getApprover() {
        Approver supervisor = new Supervisor();
        Approver manager = new DeliveryManager();
        supervisor.setNext(manager);
        return supervisor;
    }
}
