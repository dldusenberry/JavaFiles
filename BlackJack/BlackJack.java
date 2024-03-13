package BlackJack;
/**
 * BlackJack
 */
import java.util.*;

public class BlackJack {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int playGame = 0;
            instructions();
            // Create new player & dealer
            Player player1; // = new Player();
            Player dealer; //= new Player();
            Hand p1_Hand;
            Hand dlr_Hand;
            while (playGame == 0) {
                player1 = new Player();
                dealer = new Player();
            
                System.out.println("Hello, please type your name: ");
                String name1 = input.nextLine(); 
                String name2 = "dealer";
                player1 = new Player();
                dealer = new Player();
                
                player1.setName(name1);
                dealer.setName(name2);

            
            // Create and shuffle new deck
            Deck newDeck = create_deck();
            newDeck.shuffle();
            // Create player & dealer Hands and 
            p1_Hand = new Hand(newDeck);
            dlr_Hand = new Hand(newDeck);
            // clear/reset for new game
            //p1_Hand.clear();
            //dlr_Hand.clear();
            
            
            
    
                
                // Deal first hand
                //dealCard(p1_Hand, newDeck);
                //dealCard(dlr_Hand, newDeck);
                
                //System.out.println(p1_Hand);
                //System.out.println(dlr_Hand);
                p1_Hand.displayHand();
                dlr_Hand.displayHand();


                checkBlackJack(dlr_Hand, p1_Hand, name1);
            
                hitOrStay(p1_Hand, newDeck);
                if (dlr_Hand.getHandValue() <= 16){
                    dealCard(dlr_Hand, newDeck);
                }
                checkBust(dlr_Hand, p1_Hand, name1);
                if (dlr_Hand.getHandValue() == p1_Hand.getHandValue()){
                    System.out.println("Its a TIE!");
                    results(p1_Hand, dlr_Hand);
                }
                else if (dlr_Hand.getHandValue() > p1_Hand.getHandValue()){
                    System.out.println("Dealer wins!" + name1+" loses.");
                    results(p1_Hand, dlr_Hand);
                }
                else {
                    System.out.println(name1 + " wins!" + " Dealer loses.");
                    results(p1_Hand, dlr_Hand);
        
                }
               
                System.out.println("Would you like to play again?");
                System.out.println("Type yes or no: ");
                String answer = input.nextLine();
                answer.toLowerCase();
                if (answer.equals("no")) {
                    playGame = 1;
                }
            };
        
        
        }
    }
    

    /*
     * FUNCTION DEFINITIONS
     */
    public static void instructions(){
        System.out.println("~~ BLACKJACK ~~");
        System.out.println("A playing card game, you vs dealer, also known as 21.");
        System.out.println("");
        System.out.println("HOW TO PLAY:");
        System.out.println("Each card is assigned a value 2-10, face cards equal 10, and an Ace is either 1 or 11.");
        System.out.println("The goal is to get a higher hand value total than the dealer without going over 21");
        System.out.println("Or win by getting a 'BlackJack' which is a hand value of exactly 21.");
        System.out.println("The player and dealer will each be dealt 2 cards, then first check for a BlackJack.");
        System.out.println("If neither the players or dealer has a BlackJack, then the players can");
        System.out.println("- Type HIT for another card adding to hand card total, or ");
        System.out.println("- Type STAY to decline a card and keep current hand value total.");
        System.out.println("The dealer must HIT if their hand is <=16, and STAY if hand >16.");
        System.out.println("Either a winner, bust, or tie will be annouced each game.");
        System.out.println("WINNER: Player beats dealer or gets a BlackJack");
        System.out.println("BUST: Player or dealer's hand value total exceeds 21");
        System.out.println("TIE: Player's hand total equals dealer's hand total.");
        System.out.println("");
        System.out.println("");
    }
    public static Deck create_deck(){
        Deck deck = new Deck();
        return(deck);
    }
    
    static void dealCard(Hand h, Deck deck){
        h.hit(deck);
    }
    static void results(Hand h, Hand d){
        h.displayHand();
        h.displayHand();
    }
    public static void checkBlackJack(Hand dlr_Hand, Hand p1_Hand, String name1){
        int cbj = 1;
        do{
        if (dlr_Hand.hasBlackJack() && p1_Hand.hasBlackJack()){
            System.out.println("Dealer has BlackJack! ");
            System.out.println(name1 +" ALSO has BlackJack!");
            System.out.println("Its a TIE!");
            results(p1_Hand, dlr_Hand);
            cbj=0;
        }
        else if (dlr_Hand.hasBlackJack()){
            System.out.println("Dealer has BlackJack!");
            System.out.println("Dealer wins!" + name1 +" loses.");
            results(p1_Hand, dlr_Hand);
            cbj=0;
        } 
        else if (p1_Hand.hasBlackJack()){
            System.out.println(name1 + " has BlackJack!");
            System.out.println(name1 + " wins!" + " Dealer loses.");
            results(p1_Hand, dlr_Hand);
            cbj=0;
            }
        } while (cbj == 1);
    }
    
    public static void hitOrStay(Hand h, Deck deck){
        
        try(Scanner input = new Scanner(System.in)) {
            int stay = 0;
            String h_or_s;
            while ((stay == 0) && (!h.hasBust())) {
                System.out.println("Please type 'hit' or 'stay':  ");
                h_or_s = input.nextLine();
                h_or_s.toLowerCase();
                if (h_or_s.equals("hit")){
                        h.hit(deck);
                        h.displayHand();
                }
                else if (h_or_s.equals("stay")){
                    stay = 1;
                }
            };
        }
    }

    
    public static void checkBust(Hand dlr_Hand, Hand p1_Hand, String name1){
        int cbj = 1;
        do{
        if (dlr_Hand.hasBust()  && p1_Hand.hasBust()){
            System.out.println("Both bust! No winner.");
            results(dlr_Hand, p1_Hand);
            cbj=0;
        }
        else if (p1_Hand.hasBust()){
            System.out.println(name1 + "bust!" + "Dealer wins!");
            results(dlr_Hand, p1_Hand);
            cbj=0;
        }
        else if (dlr_Hand.hasBust()){
            System.out.println("Dealer bust!" + name1 + "wins!");
            results(dlr_Hand, p1_Hand);
            cbj=0;
        } 
        
        } while ( cbj == 1);
    }
}
    

