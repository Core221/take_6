package game;

import java.util.ArrayList;

public class Function{
    private static ArrayList<ArrayList<Card>> table;
    private static ArrayList<Player> players;

    /**
     * Function to play one round
     * @param oldTable     the old table
     * @param oldPlayers     the old players
     * @param playerCard    Array of Cards from players (index of PlayerCard = index of Player)
     */
    public static void playCards(ArrayList<ArrayList<Card>> oldTable, ArrayList<Player> oldPlayers, Card[] playerCard){
        //Update table and player
        table = oldTable;
        players= oldPlayers;

        //Lay Cards
        for(int i=0; i< playerCard.length; i++){
            placeCard(playerCard[i],i);
        }

    }

    /**
     * Helper Function to place a new Card in table
     * ->Evaluates if table row is full
     * @param card  the card to place on table
     * @param playerIndex   the index of the player who throw the card
     */
    private static void placeCard(Card card, int playerIndex){
        int index= -1;           //index to get the position of the right table row

        for(int i=0; i< table.size(); i++){
            Card lastCard= table.get(i).get(table.get(i).size()-1);
            if(lastCard.getValue()< card.getValue()){       //Bug: er schaut noch nicht welcher Wert am nächsten dran ist!
                    index= i;
            }
        }
        //Set the card
        if(index!=-1){  //Case Card can be placed
            table.get(index).add(card);
            if(table.get(index).size()>5){
                int bulls= 0;
                for(int i=0; i< 5; i++){       //Count the bulls on Card and remove card 1-5 from table
                    bulls+= table.get(index).get(0).getBulls();
                    table.remove(0);
                }
                players.get(playerIndex).setBulls(bulls+players.get(playerIndex).getBulls());   //Add the bulls to player stats
            }
        }else{  //Case Card cannot be placed cause its value is too small

            /*Da hatte ich echt kein bock mehr :'D*/
        }
    }

    /**
     * Updates the game with new table
     * @return  the changed table
     */
    public static ArrayList<ArrayList<Card>> updateTable(){
        return table;
    }

    /**
     * Updates the player stats
     * @return  the player accounts
     */
    public static ArrayList<Player> updatePlayers(){
        return players;
    }
}