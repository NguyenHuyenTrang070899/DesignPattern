import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();

        new CEO(programmer);
        new Manager(programmer);
        new LeadProgrammer(programmer);

        System.out.println("Lập trình viên đã thực hiện thành công công việc của mình!");
        programmer.setState("Thành công!!!");
        System.out.println("\t\t\t\t----------------------------------");
        System.out.println("Lập trình viên không thực hiện được nhiệm vụ mới của mình.");
        programmer.setState("Thất bại!!!");

    }
}
abstract class Observer {
    protected Programmer programmer;
    public abstract void update();
}
class Programmer {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
class CEO extends Observer {
    public CEO(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Thành công!!!")) {
            System.out.println("Giám đốc điều hành hài lòng với Quản lý và Lập trình viên chính.");
        } else {
            System.out.println("CEO không hài lòng với Quản lý và Lập trình viên trưởng.");
        }
    }
}
class Manager extends Observer {
    public Manager(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Thành công!!!")) {
            System.out.println("Người quản lý hài lòng với Lập trình viên chính và Lập trình viên này.");
        } else {
            System.out.println("Người quản lý không hài lòng với Lập trình viên chính và Lập trình viên này.");
        }
    }
}
class LeadProgrammer extends Observer {
    public LeadProgrammer(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Thành công!!!")) {
            System.out.println("Lập trình viên trưởng tự hào về Lập trình viên của mình.");
        } else {
            System.out.println("Lập trình viên trưởng không tự hào về Lập trình viên của mình.");
        }
    }
}
