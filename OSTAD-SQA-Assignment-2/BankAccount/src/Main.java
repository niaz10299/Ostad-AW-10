public class Main {
    public static void main(String[] args) throws Exception {
        SavingsAccount savings = new SavingsAccount(2000);
        CheckingAccount checking = new CheckingAccount(2000);

        System.out.println("Initial Balances:");
        System.out.println("Savings Account Balance: $" + savings.getBalance());
        System.out.println("Checking Account Balance: $" + checking.getBalance());

        System.out.println("\nSavings Account Transactions:");
        savings.deposit(500);
        savings.withdraw(300);
        savings.withdraw(1500);

        System.out.println("\nChecking Account Transactions:");
        checking.deposit(500);
        checking.withdraw(300);
        checking.withdraw(2500);

        System.out.println("\nFinal Balances:");
        System.out.println("Savings Account Balance: $" + savings.getBalance());
        System.out.println("Checking Account Balance: $" + checking.getBalance());
    }
}
