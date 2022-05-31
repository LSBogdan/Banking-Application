package dao.repository;

import dao.configuration.DatabaseConfig;

import java.sql.*;

public class TransactionRepository {

    private static TransactionRepository transactionRepository;

    private TransactionRepository(){}

    public static TransactionRepository getTransactionRepository(){
        if(transactionRepository == null){
            transactionRepository = new TransactionRepository();
        }
        return transactionRepository;
    }

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS transactions" +
                "(id int PRIMARY KEY AUTO_INCREMENT, sourceIBAN varchar(50), destinationIBAN varchar(50), date varchar(50), description varchar(50), amount int)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void selectTransactions() {
        String selectTransactionsSql = "SELECT * FROM transactions";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectTransactionsSql);
            System.out.println("TRANSACTIONS: ");

            while (resultSet.next()) {
                System.out.println("\tSOURCE IBAN: " + resultSet.getString(2));
                System.out.println("\tDESTINATION IBAN: " + resultSet.getString(3));
                System.out.println("\tDESCRIPTION: " + resultSet.getString(4));
                System.out.println("\tDATE: " + resultSet.getString(5));
                System.out.println("\tAMOUNT: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void insertTransaction(String sourceIBAN, String destIBAN, String description, String date, int amount){
            String insertTransactionSql = "INSERT INTO transactions(sourceIBAN, destinationIBAN, description, date, amount) VALUES(?, ?, ?, ?, ?)";

             Connection connection = DatabaseConfig.getDatabaseConnection();

            try{
                PreparedStatement preparedStatement = connection.prepareStatement(insertTransactionSql);
                preparedStatement.setString(1, sourceIBAN);
                preparedStatement.setString(2, destIBAN);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, date);
                preparedStatement.setInt(5, amount);
                preparedStatement.executeUpdate();
        } catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void updateDescription(String sourceIBAN, String destIBAN, String newDescription){
        String updateTransactionDescriptionSql = "UPDATE transactions SET description=? WHERE sourceIBAN= ? AND destinationIBAN = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateTransactionDescriptionSql);
            preparedStatement.setString(1, newDescription);
            preparedStatement.setString(2, sourceIBAN);
            preparedStatement.setString(3, destIBAN);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTransaction(String sourceIBAN, String destIBAN){
        String deleteTransactionSQL = "DELETE FROM transactions WHERE sourceIBAN=? AND destinationIBAN= ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTransactionSQL);
            preparedStatement.setString(1, sourceIBAN);
            preparedStatement.setString(2, destIBAN);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
