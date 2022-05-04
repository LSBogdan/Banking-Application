package service;

import account.*;
import card.*;
import customer.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadService {
    private static ReadService instance;

    private List<Customer> customers = new ArrayList<>();

    private List<Card> cards = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<SavingsAccount> savingsAccounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public static ReadService getInstance(){
        if(instance == null)
            instance = new ReadService();
        return instance;
    }

    private static List<String[]> getCSVColumns(String fileName){
        List<String[]> columns = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = in.readLine()) != null) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        }catch(IOException e) {
            System.out.println("In " + fileName + " you don't have data!");
        }
        return columns;
    }

    public void loadFromCSVCustomer(){
        try{
            var columns = ReadService.getCSVColumns("data/customers.csv");

            for(var fields : columns){
                var newCustomer = new Customer(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4],
                        fields[5],
                        fields[6],
                        new Address(fields[7], fields[8], fields[9], Integer.parseInt(fields[10]), Integer.parseInt(fields[11]))
                );
                customers.add(newCustomer);
            }
        } catch (NumberFormatException e){
            System.out.println(e.toString());
        }
    }

    public void loadFromCSVAccount(){
        try{
            var columns = ReadService.getCSVColumns("data/accounts.csv");

            for(var fields : columns){
                var newAccount = new Account(
                    fields[0],
                    fields[1],
                    fields[2],
                    Integer.parseInt(fields[3]),
                    Double.parseDouble(fields[4])
                );
                accounts.add(newAccount);
            }
        } catch (NumberFormatException e){
            System.out.println(e.toString());
        }
    }

    public void loadFromCSVSavingsAccount(){
        try{
            var columns = ReadService.getCSVColumns("data/savingsAccounts.csv");

            for(var fields : columns){
                var newSavingsAccount = new SavingsAccount(
                  fields[0],
                  fields[1],
                  fields[2],
                  Integer.parseInt(fields[3]),
                  Double.parseDouble(fields[4]),
                  fields[5],
                  fields[6],
                  Integer.parseInt(fields[7])
                );
                savingsAccounts.add(newSavingsAccount);
            }
        } catch (NumberFormatException e){
            System.out.println(e.toString());
        }
    }

    public void loadFromCSVTransaction(){
        try{
            var columns = ReadService.getCSVColumns("data/trasnsaction.csv");

            for(var fields : columns){
                var newTransaction = new Transaction(
                  fields[0],
                  fields[1],
                  fields[2],
                  fields[3],
                  Double.parseDouble(fields[4])
                );
                transactions.add(newTransaction);
            }
        } catch(NumberFormatException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public<T extends Card> Card readOneCard(String[] fields, Class<T> classOf){
        if(classOf.toString().equals("class card.MasterCard")){
            return new MasterCard(Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]));
        }
        return new Visa(Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]));
    }

    public void loadFromVCSCards(){
        try{
            var columns = ReadService.getCSVColumns("data/cards.csv");
            Card card;

            for(var fields : columns){
                if(fields[0].equals("MasterCard"))
                    card = readOneCard(fields, MasterCard.class);
                else
                    card = readOneCard(fields, Visa.class);

                cards.add(card);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void setInstance(ReadService instance) {
        ReadService.instance = instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }
}
