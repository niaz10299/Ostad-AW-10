public class CheckingAccount extends BankAccount {
    private static final double FEE = 2.50;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount + FEE <= balance) {
            balance -= (amount + FEE);
            System.out.println("Withdrew: $" + amount + " (Fee: $" + FEE + ")");
        } else if (amount + FEE > balance) {
            System.out.println("Insufficient funds to cover withdrawal and fee.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}
