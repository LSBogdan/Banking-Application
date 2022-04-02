package account;


public class SavingsAccount extends Account{
    static private double annuallInterestRate;
    private double savingsBalance;
    private double monthlyInterest;

    public SavingsAccount(){
        super();
        this.savingsBalance = 0.0;
    }

    public SavingsAccount(String IBAN, String name, String swift, int customerId, double amount) {
        super(IBAN, name, swift, customerId, amount);
        this.savingsBalance = amount;
    }

    public void calculateMonthlyInterest(){
        this.monthlyInterest = (savingsBalance * annuallInterestRate) / 12;
    }

    public static double getAnnuallInterestRate() {
        return annuallInterestRate;
    }

    public static void setAnnuallInterestRate(double annuallInterestRate) {
        SavingsAccount.annuallInterestRate = annuallInterestRate;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public void calculateSavings(){
        savingsBalance += this.monthlyInterest;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", name='" + name + '\'' +
                ", swift='" + swift + '\'' +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", cards=" + cards +
                ", savingsBalance=" + savingsBalance +
                ", monthlyInterest=" + monthlyInterest +
                '}';
    }
}
