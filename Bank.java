public interface Bank {

    long getBalance();
    void withdraw(long amount);
    void deposit(long amount);
    void showAccount();
    boolean searchAccount(String acc_no);


    
} 