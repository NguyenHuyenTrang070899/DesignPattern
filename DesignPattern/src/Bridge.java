public class Bridge {
    public static void main(String[] args) {
        Bank vietcomBank = new VietcomBank(new CheckingAccount());
        vietcomBank.openAccount();
        Bank tpBank = new TPBank(new SavingAccount());
        tpBank.openAccount();
    }
}
interface Account {
    void openAccount();
}
class CheckingAccount implements Account {

    @Override
    public void openAccount() {
        System.out.println("Checking Account");
    }
}
class SavingAccount implements Account {

    @Override
    public void openAccount() {
        System.out.println("Saving Account");
    }
}
abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }
    public abstract void openAccount();
}
class VietcomBank extends Bank {

    public VietcomBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.print("Open your account at VietcomBank is a ");
        account.openAccount();
    }
}
class TPBank extends Bank {

    public TPBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.print("Open your account at TPBank is a ");
        account.openAccount();
    }
}
