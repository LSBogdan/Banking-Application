package service;

import customer.Customer;
import dao.configuration.DatabaseConfig;
import dao.repository.CustomerRepository;

import java.sql.SQLOutput;
import java.util.*;

public class ServiceDB {

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
}
