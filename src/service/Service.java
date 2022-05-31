package service;

import account.*;
import card.*;
import customer.*;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.sql.SQLOutput;
import java.util.*;

public class Service {

    private static int id = 0;
    private static int cardId = 0;

    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    private List<Transaction> transactions = new ArrayList<>();

    private List<Card> cards = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public List<Card> getCards(){
        return cards;
    }

    public void setCards(List<Card> cards){
        this.cards = cards;

    }

    public void setAccounts(List<Account> accounts){ this.accounts = accounts;}

    public Address createAddress(String county, String city, String street, int number, int postalCode){
        Address newAddress = new Address(county, city, street, number, postalCode);
        return newAddress;
    }

    public void createCustomer(){

        Scanner in = new Scanner(System.in);

        id++;

        System.out.println("First name: ");
        String firstName = in.nextLine();

        System.out.println("Last name: ");
        String lastName = in.nextLine();

        System.out.println("CNP: ");
        String cnp = in.nextLine();

        System.out.println("Email: ");
        String email = in.nextLine();

        System.out.println("Telephone: ");
        String telephone = in.nextLine();

        System.out.println("Date of Birth");
        String date = in.nextLine();

        System.out.println("Address");

        System.out.println("County:");
        String county = in.nextLine();

        System.out.println("City:");
        String city = in.nextLine();

        System.out.println("Street:");
        String street = in.nextLine();

        System.out.println("Number:");
        int number = in.nextInt();
        in.nextLine();

        System.out.println("Postal Code");
        int postalCode = in.nextInt();
        in.nextLine();


        Address newAddress = createAddress(county, city, street, number, postalCode);
        Customer newCustomer = new Customer(id, firstName, lastName, cnp, email, telephone, date, newAddress);

        customers.add(newCustomer);
    }

    public void printAllCustomers(){
        System.out.println("Our Customers:");
        if(customers.size() != 0)
            for(int i = 0; i < customers.size(); i++)
                System.out.println(customers.get(i).toString());
    }

    public Customer createCustomer(String county, String city, String street, int number, int postalCode, int customerId, String firstName, String lastName, String cnp, String email, String phoneNumber, String dateOfBirth){
        Address newAddress = createAddress(county, city, street, number, postalCode);
        Customer newCustomer = new Customer(customerId, firstName, lastName, cnp, email, phoneNumber, dateOfBirth, newAddress);
        return newCustomer;
    }

    public void printCustomerDetails(Customer customer){
        System.out.println(customer.toString());
    }

    public void createAccount(){
        Scanner in = new Scanner(System.in);

        System.out.println("IBAN");
        String iban = in.nextLine();

        System.out.println("Name");
        String name = in.nextLine();

        System.out.println("Swift");
        String swift = in.nextLine();

        System.out.println("Your customer Id:");
        int id = in.nextInt();
        in.nextLine();

        System.out.println("Amount:");
        double amount = in.nextDouble();
        in.nextLine();

        Account newAccount = new Account(iban, name, swift, id, amount);

        accounts.add(newAccount);
    }

    public void listAllAccounts(){
        System.out.println("Our Accounts:");

        if(accounts.size() != 0)
            for(int i = 0; i < accounts.size(); i++)
                System.out.println(accounts.get(i).toString());
    }

    public void createSavingsAccount(){
        Scanner in = new Scanner(System.in);

        System.out.println("IBAN");
        String iban = in.nextLine();

        System.out.println("Name");
        String name = in.nextLine();

        System.out.println("Swift");
        String swift = in.nextLine();

        System.out.println("Your customer Id:");
        int id = in.nextInt();
        in.nextLine();

        System.out.println("Amount:");
        double amount = in.nextDouble();
        in.nextLine();

        System.out.println("Start Date:");
        String startDate = in.nextLine();

        System.out.println("End Date:");
        String endDate = in.nextLine();

        System.out.println("Interes:");
        int interest = in.nextInt();
        in.nextLine();

        SavingsAccount savingsAccount = new SavingsAccount(iban, name, swift, id, amount, startDate, endDate, interest);

        accounts.add(savingsAccount);
    }

    public void createCard(){

        cardId++;

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        int CVV = in.nextInt();
        in.nextLine();

        Card newCard = new Card(cardId, name, CVV);

        cards.add(newCard);
    }

    public void listAllCards(){

        System.out.println("Our Cards:");

        if(cards.size() != 0)
            for(int i = 0; i < cards.size(); i++)
                System.out.println(cards.get(i).toString());
    }

    public void addCardToAccount(){
        Scanner in = new Scanner(System.in);

        System.out.println("Your customerId: ");
        int idAccount = in.nextInt();
        in.nextLine();

        System.out.println("The id of the card: ");
        int idCard = in.nextInt();
        in.nextLine();

        for(int i = 0; i < accounts.size(); i++)
            if(accounts.get(i).getCustomerId() == idAccount){

                for(int j = 0; j < cards.size(); j++)
                    if(cards.get(j).getCardId() == idCard)
                        accounts.get(i).addCard(cards.get(j));
            }
    }

    public void createTransaction(){
        Scanner in = new Scanner(System.in);

        System.out.println("Source IBAN: ");
        String sourceIBAN = in.nextLine();

        System.out.println("Destination IBAN: ");
        String destIBAN = in.nextLine();

        System.out.println("Description: ");
        String description = in.nextLine();

        System.out.println("Date: ");
        String date = in.nextLine();

        System.out.println("Amount: ");
        double amount = in.nextDouble();
        in.nextLine();

        Transaction newTransaction = new Transaction(sourceIBAN, destIBAN, description, date, amount);
        transactions.add(newTransaction);
    }

    public void listAllTansactions(){
        System.out.println("Our transactions: ");
        if(transactions.size() != 0)
            for(int i = 0; i < transactions.size(); i++)
                System.out.println(transactions.get(i).toString());
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
