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

    public Card chooseCard(){
        Card chosen= hand_cards.get(0);
        hand_cards.remove(0);
        return chosen;
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
     * @return  ArrayList of Cards
     */
    public ArrayList<Card> getCards(){
        return this.hand_cards;
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
    public void setCards(ArrayList<Card> cards){
        this.hand_cards= cards;
    }

    /**
     * Setter for bulls
     * @param bulls
     */
    public void setBulls(int bulls){
        this.bulls= bulls;
    }
}
