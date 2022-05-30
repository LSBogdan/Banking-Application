package service;

import account.*;
import card.*;
import customer.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


public class WriteService {

    private static WriteService instance;

//    private List<Customer> customers = ReadService.getInstance().getCustomers();
//    private List<Card> cards = ReadService.getInstance().getCards();
//    private List<Account> accounts = ReadService.getInstance().getAccounts();
//    private List<SavingsAccount> savingsAccounts = ReadService.getInstance().getSavingsAccounts();
//    private List<Transaction> transactions = ReadService.getInstance().getTransactions();

    public static WriteService getInstance(){
        if(instance == null)
            instance = new WriteService();
        return instance;
    }

    public <T> void writeDetails(Object obj, Class<T> classOf){
        try{
            var writer = new BufferedWriter(new FileWriter("data/output.csv", true));
            new FileWriter("data/output.csv", false).close();

            if(classOf.toString().equals("class customer.Customer")) {
                writer.write(((Customer) obj).toString() + "\n");
            } else if(classOf.toString().equals("class account.Account")){
                writer.write(((Account)obj).toString() + "\n");
            } else if(classOf.toString().equals("class account.SagingsAccount")) {
                writer.write(((SavingsAccount) obj).toString() + "\n");
            } else if(classOf.toString().equals("class account.Transaction")) {
                writer.write(((Transaction) obj).toString() + "\n");
            } else if(classOf.toString().equals("class card.MasterCard")) {
                writer.write(((MasterCard) obj).toString() + "\n");
            } else if(classOf.toString().equals("class card.Visa")) {
                writer.write(((Visa) obj).toString() + "\n");
            }

            writer.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
