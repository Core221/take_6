package game;

import java.util.ArrayList;

/**
 * Created by jbuer on 10.06.2016.
 */
public class Player {
    private String name;
    private Card[] hand_cards;
    private ArrayList<Card> bulls;


    public Player(String name){
        this.name = name;
        hand_cards= new Card[10];
        bulls = new ArrayList<>();
        
    }
}
