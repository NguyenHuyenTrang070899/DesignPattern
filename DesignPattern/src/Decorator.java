public class Decorator {
    public static void main(String[] args) {
        IComputer gamingComputer = new GamingComputer(new BasicComputer());
        gamingComputer.assemble();
        System.out.println("\n");
        IComputer workComputer = new WorkComputer(new GamingComputer(new BasicComputer()));
        workComputer.assemble();
    }
}
interface IComputer {
    void assemble();
}
class BasicComputer implements IComputer {
    @Override
    public void assemble() {
        System.out.print("Máy tính cơ bản.");
    }
}
abstract class ComputerDecorator implements IComputer {
    protected IComputer computer;

    public ComputerDecorator(IComputer computer) {
        this.computer = computer;
    }

    @Override
    public void assemble() {
        this.computer.assemble();
    }
}
class GamingComputer extends ComputerDecorator {
    public GamingComputer(IComputer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Thêm đặc điểm của máy tính chơi game.");
    }
}
class WorkComputer extends ComputerDecorator {
    public WorkComputer(IComputer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Thêm đặc điểm của một máy tính làm việc.");
    }
}