package game;

import java.util.ArrayList;

public class helperFunctions{

    /**
     * Gets n rnd chosen Cards from the stable and returns an Array of Cards
     *
     * @param amount    wished amount of cards
     * @return Array of cards
     */
    public static ArrayList<Card> rndCards(ArrayList<Card> stable,int amount){
        ArrayList<Card> cards = new ArrayList<>();
        for(int i=0; i<amount; i++){
            int rnd = (int)(Math.random() * (stable.size()-i));
            cards.add(stable.get(rnd));
            stable.remove(rnd);
        }
        return cards;
    }
}