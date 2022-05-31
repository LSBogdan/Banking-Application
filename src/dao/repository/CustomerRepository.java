package dao.repository;

import dao.configuration.DatabaseConfig;

import java.sql.*;

public class CustomerRepository {

    private static CustomerRepository customerRepository;

    private CustomerRepository(){
    }

    public static CustomerRepository getCustomerRepository(){
        if(customerRepository == null){
            customerRepository = new CustomerRepository();
        }
        return  customerRepository;
    }

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS customers" +
                "(id int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), address varchar(50), telephone varchar(30), username varchar(30), password varchar(30), email varchar(30))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectCustomers(){

        String selectCustomersSql = "SELECT * FROM customers";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectCustomersSql);
            System.out.println("CUSTOMERS: ");

            while(resultSet.next()){
                System.out.println("\tFIRST NAME: " + resultSet.getString(2));
                System.out.println("\tLAST NAME: " + resultSet.getString(3));
                System.out.println("\tADDRESS: " + resultSet.getString(4));
                System.out.println("\tTELEPHONE: " + resultSet.getString(5));
                System.out.println("\tUSERNAME: " + resultSet.getString(6));
                System.out.println("\tPASSWORD: " + resultSet.getString(7));
                System.out.println("\tEMAIL: " + resultSet.getString(8));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertCustomer(String firsName, String lastName, String address, String telephone, String username, String password, String email){
        String insertCustomersSql = "INSERT INTO customers(firstName, lastName, address, telephone, username, password, email) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertCustomersSql);
            preparedStatement.setString(1, firsName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, telephone);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateCustomerUsername(String username, String newUsername){
        String updateCustomerUsernameSql = "UPDATE customers SET username=? WHERE username=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerUsernameSql);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateCustomerPassword(String username, String newPassword){
        String updateCustomerPasswordSql = "UPDATE customers SET password=? WHERE username=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerPasswordSql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String username){
        String deleteCustomerSQL = "DELETE FROM customers WHERE username=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCustomerSQL);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
