package BlackJack;

import java.util.ArrayList;

public class Hand {
    private int handValue;
    private ArrayList<Card> hand; 

    //Setter
    public void setHandValue(int handValue){
        this.handValue = handValue;
    }

    //Getter
    public int getHandValue(){
        return(this.handValue);
    }


    // Constructor 
    public Hand(Deck deck){
        
        hand = new ArrayList<Card>();
        for(int i =0; i<2; i++){
            //hand.add(deck.deal());
            Card newCard = new Card();
            newCard = deck.deal();
            update_playerHand(newCard);
            update_handValue(hand);
        }
        
    }

    // Update hand cards and values
    public void hit(Deck deck){
        Card newCard = new Card();
        newCard = deck.deal();
        update_playerHand(newCard);
        update_handValue(hand);
    }
    public void update_playerHand(Card newCard){
        hand.add(newCard);
    }
    public void update_handValue(ArrayList<Card> hand){
        for (int i = 0; i < hand.size(); i++){
            handValue += hand.get(i).getValue();
        }
    }
    // Reset hand for new game
    public void clear(){ 
        hand.clear();
        setHandValue(0);
    }

    // Evaluate hand values
    public boolean hasBlackJack(){
        if (getHandValue() == 21){
            return(true);
        } return(false);

    }
    public boolean hasBust(){
        if (getHandValue() > 21){
            return(true);
        } return(false);
    }
   
    // String represention of Hand 
    public String displayHand(){
        return("Hand shows: " + hand + "\n" + "Hand Value: " + getHandValue());
    }
}


