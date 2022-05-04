import account.*;
import card.*;
import customer.*;
import service.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Service service = new Service();

        System.out.println("Clienti:");
        Customer c1 = service.createCustomer("Arges", "Pitesti", "Calea Bucuresti", 232, 430324, 1, "Firstname1", "Lastname1", "0123456789", "email1@gmail.com", "0777777777", "10-12-1991");
        service.printCustomerDetails(c1);
        Customer c2 = service.createCustomer("Arges", "Topoloveni", "Strada Banat", 121, 342029, 2, "Firstname2", "Lastname2", "0213647589", "email2@gmail.com", "0789898998", "3-3-1961");
        service.printCustomerDetails(c2);

        System.out.println("\nConturi:");
        Account a1 = service.createAccount("RO49AAAA1B31007593840000", "Firstname2 Lastname2", "TNISROB2",  2, 983);
        service.printAccountDetails(a1);

        SavingsAccount s1 = service.createSavingsAccount("RO49AAAA1B31007543811100", "FirstName1 LastName1", "RZBLROBU", 1, 12122);
        service.printSavingsAccountDetails(s1);

        System.out.println("\nCarduri:");
        Card card1 = service.createCard(1, "Firstname2 Lastname2", 123);
        System.out.println(card1);

        ArrayList<Card> cards= new ArrayList<>();
        cards.add(new Visa(2, "Firstname2 Lastname2", 134));
        cards.add(new MasterCard(3, "Firstname1 Lastname1", 434));
        cards.add(new Visa(4, "Firstname1 Lastname1", 734));
        for(int i = 0; i < cards.size(); i++)
            service.printCardDetails(cards.get(i));

        a1.addCard(cards.get(1));
        a1.addCard(cards.get(2));
        service.printCardsSorted(a1);


        System.out.println("\nTranzactii:");
        Transaction t1 = service.createTransaction("RO49AAAA1B31007593840000", "RO49AAAA1B31007543811100", "Transfer", "4-2-2022", 500);
        System.out.println(t1);

    }
}

