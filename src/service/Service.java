package service;

import account.*;
import card.*;
import customer.*;

import java.util.*;

public class Service {

    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public Address createAddress(String county, String city, String street, int number, int postalCode){
        Address newAddress = new Address(county, city, street, number, postalCode);
        return newAddress;
    }


//    public void createCustomer(Scanner in){
//        System.out.println("First name: ");
//        String firstName = in.nextLine();
//
//    }

    public Customer createCustomer(String county, String city, String street, int number, int postalCode, int customerId, String firstName, String lastName, String cnp, String email, String phoneNumber, String dateOfBirth){
        Address newAddress = createAddress(county, city, street, number, postalCode);
        Customer newCustomer = new Customer(customerId, firstName, lastName, cnp, email, phoneNumber, dateOfBirth, newAddress);
        return newCustomer;
    }

    public void printCustomerDetails(Customer customer){
        System.out.println(customer.toString());
    }

    public Account createAccount(String IBAN, String name, String swift, int customerId, double amount){
        Account newAccount = new Account(IBAN, name, swift, customerId, amount);
        return newAccount;
    }

    public void printAccountDetails(Account account){
        System.out.println(account.toString());
    }

    public SavingsAccount createSavingsAccount(String IBAN, String name, String swift, int customerId, double amount, String startDate, String endDate, int interest){
        SavingsAccount newSavingsAccount = new SavingsAccount(IBAN, name, swift, customerId, amount, startDate, endDate, interest);
        return newSavingsAccount;
    }

    public void printSavingsAccountDetails(SavingsAccount savingsAccount){
        System.out.println(savingsAccount.toString());
    }

    public Card createCard(int cardId, String name, int CVV){
        Card newCard = new Card(cardId, name, CVV);
        return newCard;
    }

    public void printCardDetails(Card card){
        System.out.println(card.toString());
    }

    public void printCardsSorted(Account account){
        System.out.println("Before: " + account.getCards());
        account.SortAccountCards();
        System.out.println("After: " + account.getCards());
    }
    public Transaction createTransaction(String sourceIBAN, String destIBAN, String description, String date, double amount){
        Transaction newTransaction = new Transaction(sourceIBAN, destIBAN, description, date, amount);
        return  newTransaction;
    }

    public void printTransactionDetails(Transaction transaction){
        System.out.println(transaction);
    }

}
