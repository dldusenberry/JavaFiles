package BlackJack;

import java.util.ArrayList;

public class Player {
    private String name;
    private int handValue = 0;
    private ArrayList<Card> hand;
    // Constructor 1 (for testing)
    public Player(){

    }
    // Constructor 2
    public Player(String name){
        setName(name);
        setHand(hand);
    }
    //Setter
    public void setHandValue(int handValue){
        this.handValue = handValue;
    }

    //Getter
    public int getHandValue(){
        return(this.handValue);
    }
    public ArrayList<Card> getHand(){
        //Hand hand = new Hand(null);
        return(hand);

    }
    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }

    // Getter 
    public String getName(){
        return(this.name);
    }

    // String represention of Player
    public String toString(){
        return(getName());
    }
}
