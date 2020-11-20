public class Command {
    public static void main(String[] args) {
        Accountt account = new Accountt("NTHT");

        ICommand open = new OpenAccount(account);
        ICommand close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);

        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}
class Accountt {
    private String name;

    public Accountt(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }

    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}
interface ICommand {

    void execute();
}
class OpenAccount implements ICommand {

    private Accountt account;

    public OpenAccount(Accountt account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.open();
    }
}
class CloseAccount implements ICommand {

    private Accountt account;

    public CloseAccount(Accountt account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.close();
    }
}
class BankApp {

    private ICommand openAccount;
    private ICommand closeAccount;

    public BankApp(ICommand openAccount, ICommand closeAccount) {
        this.openAccount = openAccount;
        this.closeAccount = closeAccount;
    }

    public void clickOpenAccount() {
        System.out.println("User click open an account");
        openAccount.execute();
    }

    public void clickCloseAccount() {
        System.out.println("User click close an account");
        closeAccount.execute();
    }
}