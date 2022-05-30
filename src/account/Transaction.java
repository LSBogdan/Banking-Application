package account;

import java.util.*;

public class Transaction {
    private final String sourceIBAN;
    private final String destIBAN;
    private final String description;
    private final String date;
    private final double amount;

    public Transaction(){
        this.sourceIBAN = "";
        this.destIBAN = "";
        this.description = "";
        this.date = "";
        amount = 0.0;
    }

    public Transaction(String sourceIBAN, String destIBAN, String description, String date, double amount){
        this.sourceIBAN = sourceIBAN;
        this.destIBAN = destIBAN;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public String getSourceIBAN() {
        return sourceIBAN;
    }

    public String getDestIBAN() {
        return destIBAN;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sourceIBAN='" + sourceIBAN + '\'' +
                ", destIBAN='" + destIBAN + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }

}
