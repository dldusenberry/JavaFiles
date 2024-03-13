package BlackJack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
        public String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        public String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8",
                     "9", "10", "Jack", "Queen", "King"};
        private ArrayList<Card> deck;
        
        public Deck(){
        deck = new ArrayList<Card>();
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                deck.add(new Card(suits[i],ranks[j]));
            }
        }
    }
    public ArrayList<Card> getDeck(){
        return(deck);
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card deal(){
        return(deck.remove(0));
    }

    public int deckSize(){
        return(deck.size());
    }

    }

