package account;


public class SavingsAccount extends Account{
    private final String startDate;
    private final String endDate;
    private final int interest;

    SavingsAccount(){
        super();
        this.startDate = "";
        this.endDate = "";
        this.interest = 0;
    }

    public SavingsAccount(String IBAN, String name, String swift, int customerId, double amount, String startDate, String endDate, int interest) {
        super(IBAN, name, swift, customerId, amount);
        this.startDate = startDate;
        this.endDate = endDate;
        this.interest = interest;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getInterest() {
        return interest;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                ", IBAN='" + IBAN + '\'' +
                ", name='" + name + '\'' +
                ", swift='" + swift + '\'' +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", cards=" + cards +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", interest=" + interest +
                '}';
    }
}
