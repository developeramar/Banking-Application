public class Kotak_MahindraBank implements Bank {
    String name;
    String accno;
    String acc_type;
    long balance;

    public Kotak_MahindraBank(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal : " + balance);
        } else {
            System.out.println("your balance is less than " + amount + "\tTransaction failed");
        }
    }

    public void deposit(long amount) {
        balance = balance + amount;
    }

    public void showAccount() {
        System.out.println("Kotak_Mahindra Bank Account");
        System.out.println("Account Holder Name :" + name);
        System.out.println("User Account Number :" + accno);
        System.out.println("Account type : " + acc_type);
        System.out.println("balance : " + balance);
    }

    public boolean searchAccount(String account_no) {
        if (accno.equals(account_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}
