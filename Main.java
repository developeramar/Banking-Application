import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Bank createAccount(ArrayList<Bank> C) {

        int choice;
        String name, accno, acc_type;
        long balance;
        boolean found;

        Bank bank;

        System.out.println("-------------------------------- --------------------------------");
        System.out.println();
        System.out.println("1.SBI_Bank 2.UCO_Bank 3. Kotak_Mahindra");
        System.out.println();
        System.out.println("-------------------------------- --------------------------------");

        System.out.println("Enter Your favoriate  Bank --");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        System.out.println();

        System.out.println("Enter Name : ");
        name = sc.nextLine();
        System.out.println("Enter Account No : ");
        accno = sc.nextLine();
        System.out.println("Enter Account type : ");
        acc_type = sc.nextLine();
        System.out.println("Enter Balance : ");
        balance = sc.nextLong();

        found = false;

        for (int i = 0; i < C.size(); i++) {
            found = C.get(i).searchAccount(accno);

            if (found) {
                System.out.println("Account with entered accNo already exists. ");
                break;
            }
        }

        if (!found) {
            switch (choice) {

                case 1:
                    if (balance < 1000) {
                        System.out.println("Minimum balance is 1000. Please make sure your minimum balance is 1000");
                    }

                    else {
                        bank = new SBI_Bank(name, accno, acc_type, balance);
                        System.out.println("Account Created in SBI Bank ");
                        return bank;
                    }
                    break;

                case 2:
                    if (balance < 2000)

                    {
                        System.out.println("Minimum balance is 2000. Please make sure your minimum balance is 20000");
                    } else {
                        bank = new UCO_Bank(name, accno, acc_type, balance);
                        System.out.println("Account created in UCO Bank");
                        return bank;
                    }
                    break;

                case 3:
                    if (balance < 3000)

                    {
                        System.out.println("Minimum balance is 2000. Please make sure your minimum balance is 20000");
                    } else {
                        bank = new Kotak_MahindraBank(name, accno, acc_type, balance);
                        System.out.println("Account created in Kotak Mahindra Bank");
                        return bank;
                    }
                    break;

                default:
                    System.out.println("Wrong Choice");

            }
        }

        return null;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Bank> C = new ArrayList<>();

        System.out.println("No accounts found. Please Create one");
        Bank bank = createAccount(C);

        if (bank != null) {

            C.add(bank);

        }

        int ch;

        do {
            System.out.println("-------------------------------- ----------------");
            System.out.println();
            System.out.println("\n #Banking System Application#");
            System.out.println(
                    " 1.Create an account \n2. Display all account details \n 3. Search by Account number\n 4. Deposit the amount \n 5. Withdraw the amount \n 6. Remove account\n 7.Exit ");
            System.out.println();
            System.out.println("-------------------------------- ----------------");

            System.out.print("Enter your choice :--- ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    Bank bank1 = createAccount(C);
                    if (bank1 != null) {
                        C.add(bank1);
                    }
                    break;

                case 2:
                    if (C.isEmpty()) {
                        System.out.println("Account not found ");
                    }
                    for (int i = 0; i < C.size(); i++) {
                        C.get(i).showAccount();
                    }
                    break;

                case 3:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.size(); i++) {
                        found = C.get(i).searchAccount(ac_no);
                        if (found) {
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.size(); i++) {
                        found = C.get(i).searchAccount(ac_no);
                        if (found) {
                            System.out.println("Enter the amount to deposit");
                            long amount = sc.nextLong();
                            C.get(i).deposit(amount);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.size(); i++) {
                        found = C.get(i).searchAccount(ac_no);
                        if (found) {
                            System.out.println("Enter the amount to withdraw");
                            long amount = sc.nextLong();
                            C.get(i).withdraw(amount);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.!");
                    }
                    break;

                case 6:
                    System.out.println("Enter your acc no: ");
                    String temp = sc.next();
                    found = false;

                    for (int i = 0; i < C.size(); i++) {

                        found = C.get(i).searchAccount(temp);
                        if (found) {
                            C.remove(i);
                            System.out.println("Account remove Successfully!");
                            break;
                        } else if (!found) {
                            System.out.println("Searched Failed ! Account not Exists");
                        }
                    }
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Wrong Input");
            }

        } while (ch != 7);

    }
}
