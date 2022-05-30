import account.*;
import card.*;
import customer.*;
import dao.configuration.DatabaseConfig;
import dao.repository.CustomerRepository;
import service.*;
import java.util.*;

import java.util.ArrayList;

public class Main {
    static ArrayList<String> availableCommands = new ArrayList<>();

    private static void printAllCommands(){
        availableCommands.forEach((n) -> System.out.println(n));
    }

    public static void main(String[] args){

        Main.availableCommands.add("create_customer");
        Main.availableCommands.add("list_all_customers");
        Main.availableCommands.add("update_password_customer");
        Main.availableCommands.add("update_username_customer");
        Main.availableCommands.add("help");
        Main.availableCommands.add("end");

//        CustomerRepository customerRepository = CustomerRepository.getCustomerRepository();
//        customerRepository.createTable();
//        customerRepository.insertCustomer("Bogdan", "Lolot", "Calinesti", "0123456789", "BogdanLolot", "123456", "lolotbogdan@yahoo.com");
//        customerRepository.selectCustomers();
//        customerRepository.deleteCustomer("BogdanLolot");
//
//        DatabaseConfig.closeDatabaseConfiguration();


        CustomerRepository customerRepository = CustomerRepository.getCustomerRepository();
        customerRepository.createTable();

        Scanner in = new Scanner(System.in);
        boolean end = false;
        Service service = new Service();
        ServiceDB serviceDB= new ServiceDB();
        AuditService auditService = new AuditService();

        while(!end){
            System.out.println("Insert a command(you can use the word help to see commands): ");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (command){
                    case "create_customer" -> serviceDB.createCustomer(customerRepository);
                    case "list_all_customers" -> serviceDB.listAllCustomers(customerRepository);
                    case "update_password_customer" -> serviceDB.updatePasswordCustomer(customerRepository);
                    case "update_username_customer" -> serviceDB.updateUsernameCustomer(customerRepository);
                    case "delete_customer" -> serviceDB.deleteCustomer(customerRepository);
                    case "help" ->  Main.printAllCommands();
                    case "end" -> end = true;
                }
                if(availableCommands.contains(command))
                    auditService.logAction(command);
            } catch(Exception e){
                System.out.println(e.toString());
            }
        }
        DatabaseConfig.closeDatabaseConfiguration();

//-------------------------------------
//        Scanner in = new Scanner(System.in);
//        boolean end = false;
//        Service service = new Service();
//        AuditService auditService = new AuditService();
//
//        ReadService.getInstance().loadFromCSVCustomer();
//        service.setCustomers(ReadService.getInstance().getCustomers());
//
//
//        while(!end){
//            System.out.println("Insert command: !help - to see commands!");
//            String command = in.nextLine().toLowerCase(Locale.ROOT);
//
//            try{
//                switch (command){
//                    case "createCustomer" -> service.createCustomer("Arges", "Pitesti", "Calea Bucuresti", 232, 430324, 1, "Firstname1", "Lastname1", "0123456789", "email1@gmail.com", "0777777777", "10-12-1991");
//                    case "help" ->  Main.printAllCommands();
//                    case "end" -> end = true;
//                }
//                if(availableCommands.contains(command))
//                    auditService.logAction(command);
//            } catch(Exception e){
//                System.out.println(e.toString());
//            }
//        }
//
//        Customer c1 = service.createCustomer("Arges", "Pitesti", "Calea Bucuresti", 232, 430324, 1, "Firstname1", "Lastname1", "0123456789", "email1@gmail.com", "0777777777", "10-12-1991");
//        WriteService.getInstance().writeDetails(c1, Customer.class);

//-------------------
        //Chestii hardcodate
        boolean hard = false;

        if(hard) {


            System.out.println("Clienti:");
            Customer c1 = service.createCustomer("Arges", "Pitesti", "Calea Bucuresti", 232, 430324, 1, "Firstname1", "Lastname1", "0123456789", "email1@gmail.com", "0777777777", "10-12-1991");
            service.printCustomerDetails(c1);
            Customer c2 = service.createCustomer("Arges", "Topoloveni", "Strada Banat", 121, 342029, 2, "Firstname2", "Lastname2", "0213647589", "email2@gmail.com", "0789898998", "3-3-1961");
            service.printCustomerDetails(c2);

            System.out.println("\nConturi:");
            Account a1 = service.createAccount("RO49AAAA1B31007593840000", "Firstname2 Lastname2", "TNISROB2", 2, 983);
            service.printAccountDetails(a1);

            SavingsAccount s1 = service.createSavingsAccount("RO49AAAA1B31007543811100", "FirstName1 LastName1", "RZBLROBU", 1, 12122, "2022-05-04", "2023-05-03", 4);
            service.printSavingsAccountDetails(s1);

            System.out.println("\nCarduri:");
            Card card1 = service.createCard(1, "Firstname2 Lastname2", 123);
            System.out.println(card1);

            ArrayList<Card> cards = new ArrayList<>();
            cards.add(new Visa(2, "Firstname2 Lastname2", 134));
            cards.add(new MasterCard(3, "Firstname1 Lastname1", 434));
            cards.add(new Visa(4, "Firstname1 Lastname1", 734));
            for (int i = 0; i < cards.size(); i++)
                service.printCardDetails(cards.get(i));

            a1.addCard(cards.get(1));
            a1.addCard(cards.get(2));
            service.printCardsSorted(a1);


            System.out.println("\nTranzactii:");
            Transaction t1 = service.createTransaction("RO49AAAA1B31007593840000", "RO49AAAA1B31007543811100", "Transfer", "4-2-2022", 500);
            System.out.println(t1);
        }
    }
}

