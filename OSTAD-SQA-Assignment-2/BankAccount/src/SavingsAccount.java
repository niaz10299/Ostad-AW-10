public class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit of $" + WITHDRAWAL_LIMIT);
        } else {
            super.withdraw(amount);
        }
    }
}
