package account;

import card.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Account implements Comparator<Transaction> {
    protected String IBAN;
    protected String name;
    protected String swift;
    protected int customerId;
    protected double amount;
    protected ArrayList<Card> cards = new ArrayList<>();

    public Account(){
        this.IBAN = "";
        this.name = "";
        this.swift = "";
        this.customerId = 0;
        this.amount = 0.0;
    }

    public Account(String IBAN, String name, String swift, int customerId, double amount){
        this.IBAN = IBAN;
        this.name = name;
        this.swift = swift;
        this.customerId = customerId;
        this.amount = amount;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void deleteCard(Card card){
        cards.remove(card);
    }

    public int compare(Transaction t1, Transaction t2){
        Double d1 = t1.getAmount();
        Double d2 = t2.getAmount();
        return d1.compareTo(d2);
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", name='" + name + '\'' +
                ", swift='" + swift + '\'' +
                ", customerId=" + customerId +
                ", amount=" + amount +
                '}';
    }
}

