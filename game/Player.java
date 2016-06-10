package game;


import java.util.ArrayList;

/**
 * Created by jbuer on 10.06.2016.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand_cards;
    private int bulls;

    /**
     * Constructor for Player
     * @param name
     * @param cards
     */
    public Player(String name, ArrayList<Card> cards){
        this.name = name;
        hand_cards= cards;
        bulls = 0;
        
    }

    /*Getter & Setter*/

    /**
     * Getter for name
     * @return the nickname
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for handCards of Player
     * @return  the handCards in form of an Array
     */
    public Card[] getCards(){
        Card[] cards= new Card[hand_cards.size()];
        for(int i=0; i< hand_cards.size(); i++){
            cards[i]= hand_cards.get(i);
        }
        return cards;
    }

    /**
     * Getter for bulls
     * @return amount of collected bulls
     */
    public int getBulls(){
        return this.bulls;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name){
        this.name= name;
    }

    /**
     * Setter for hand_cards
     * @param cards
     */
    public void setCards(Card[] cards){
        ArrayList<Card> handCards= new ArrayList<Card>();
        for(int i=0; i< cards.length; i++){
            handCards.add(cards[i]);
        }
        this.hand_cards= handCards;
    }

    /**
     * Setter for bulls
     * @param bulls
     */
    public void setBulls(int bulls){
        this.bulls= bulls;
    }
}
