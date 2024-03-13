package BlackJack;


public class Card {
    
    private String rank;
    private String suit;
    private int value;

    public String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8",
                     "9", "10", "Jack", "Queen", "King"};
    
    // Constructor 1 (for testing)
    public Card(){

    }
    // Constructor 2
    public Card(String suit, String rank){
        setRank(rank);
        setSuit(suit);
    }

    private void setRank(String rank){
        this.rank = rank;
    }
    private void setSuit(String suit){
        this.suit = suit;
    }
    private void setValue(int value){
        this.value = value;
    }

    public String getRank(){
        return(this.rank);
    }
    public String getSuit(){
        return(this.suit);
    }
    public int getValue(){
        for(int i=0; i<ranks.length; i++)
            if(i > 10){
                setValue(10);
            }
            else if(i == 0){
                setValue(11);
            }
            else{
                setValue(i - 1);
            }
            return(this.value);
    }

    // String represention of Card
    public String toString(){
        return(getRank() + " of " + getSuit());
    }
}