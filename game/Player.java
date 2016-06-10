package game;

import java.util.ArrayList;

/**
 * Created by jbuer on 10.06.2016.
 */
public class Player {
    private String name;
    private Card[] hand_cards;
    private int bulls;


    public Player(String name, Card[] cards){
        this.name = name;
        hand_cards= cards;
        bulls = 0;
        
    }

    public String getName(){
        return this.name;
    }

    public Card[] getCards(){
        return this.hand_cards;
    }

    public int getBulls(){
        return this.bulls;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setCards(Card[] cards){
        this.hand_cards= cards;
    }

    public void setBulls(int bulls){
        this.bulls= bulls;
    }
}
