package card;


import java.util.*;

public class Card {
    protected final int cardId;
    protected final int CVV;
    protected String number;
    protected String name;
    protected String expirationDate;
    static protected ArrayList<String> usedNumbers = new ArrayList<String>();

    public Card(){
        this.cardId = 0;
        this.CVV = 0;
        this.number = "";
        this.name = "";
        this.expirationDate = "";
    }

    public Card(int cardId, String name, int CVV){
        this.cardId = cardId;
        this.name = name;
        this.expirationDate = "10-10-2050";
        this.number = generateNumber();

        while(findUsedNumbers(this.number)){
            this.number = generateNumber();
        }
        usedNumbers.add(this.number);

        this.CVV = CVV;
    }

    public boolean findUsedNumbers(String arg){
        String temp = new String(arg);

        for(int i = 0; i < usedNumbers.size(); i++)
            if(temp.equals(usedNumbers.get(i)))
                return true;
        return false;
    }

    public String generateNumber(){
        String result = "";
        String alphabet = "0123456789";
        Random r = new Random();

        for(int i = 0; i < 16; i++){
            char temp = alphabet.charAt(r.nextInt(alphabet.length()));
            result += temp;
        }
        return result;
    }

    public int getCardId() {
        return cardId;
    }

    public int getCVV() {
        return CVV;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", CVV=" + CVV +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}

