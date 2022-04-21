package comparators;

import card.*;
import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
    @Override
    public int compare(Card c1, Card c2){
        if(c1 == c2)
            return 0;

        if(c1 == null)
            return -1;

        if(c2 == null)
            return -1;

        return c1.getNumber().compareTo(c2.getNumber());
    }
}
