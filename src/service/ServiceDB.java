package service;

import account.Transaction;
import customer.Customer;
import dao.configuration.DatabaseConfig;
import dao.repository.CustomerRepository;
import dao.repository.TransactionRepository;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;

public class ServiceDB {

    // Customers
    public void createCustomer(CustomerRepository customerRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("First Name: ");
        String firstName = in.nextLine();

        System.out.println("Last Name: ");
        String lastName = in.nextLine();

        System.out.println("Address: ");
        String address = in.nextLine();

        System.out.println("Telephone: ");
        String telephone = in.nextLine();

        System.out.println("Username: ");
        String username = in.nextLine();

        System.out.println("Password: ");
        String password = in.nextLine();

        System.out.println("Email: ");
        String email = in.nextLine();

        customerRepository.insertCustomer(firstName, lastName, address, telephone, username, password, email);
    }

    public void listAllCustomers(CustomerRepository customerRepository){
        customerRepository.selectCustomers();

    }

    public void updatePasswordCustomer(CustomerRepository customerRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("Your username: ");
        String username = in.nextLine();

        System.out.println("Enter a new password: ");
        String newPassword = in.nextLine();

        customerRepository.updateCustomerPassword(username, newPassword);
    }
    public void updateUsernameCustomer(CustomerRepository customerRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("Your username: ");
        String username = in.nextLine();

        System.out.println("Enter a new username: ");
        String newUsername = in.nextLine();

        customerRepository.updateCustomerUsername(username, newUsername);
    }

    public void deleteCustomer(CustomerRepository customerRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("Your username: ");
        String username = in.nextLine();

        customerRepository.deleteCustomer(username);
    }


    // Transactions
    public void createTransaction(TransactionRepository transactionRepository){

        Scanner in = new Scanner(System.in);

        System.out.println("SOURCE IBAN: ");
        String sourceIBAN = in.nextLine();

        System.out.println("DESTINATION IBAN: ");
        String destIBAN = in.nextLine();

        System.out.println("DESCRIPTION: ");
        String description = in.nextLine();

        System.out.println("DATE: ");
        String date = in.nextLine();

        System.out.println("AMOUNT: ");
        int amount = in.nextInt();
        in.nextLine();

        transactionRepository.insertTransaction(sourceIBAN, destIBAN, description, date, amount);
    }

    public void listAllTransactions(TransactionRepository transactionRepository){
        transactionRepository.selectTransactions();
    }

    public void updateTransactionDescription(TransactionRepository transactionRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("SOURCE IBAN: ");
        String sourceIBAN = in.nextLine();

        System.out.println("DEST IBAN: ");
        String destIBAN = in.nextLine();

        System.out.println("DESCRIPTION: ");
        String description = in.nextLine();

        transactionRepository.updateDescription(sourceIBAN, destIBAN, description);
    }

    public void deleteTransaction(TransactionRepository transactionRepository){
        Scanner in = new Scanner(System.in);

        System.out.println("SOURCE IBAN: ");
        String sourceIBAN = in.nextLine();

        System.out.println("DEST IBAN: ");
        String destIBAN = in.nextLine();

        transactionRepository.deleteTransaction(sourceIBAN, destIBAN);
    }
}
