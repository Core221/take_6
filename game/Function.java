package game;

import java.util.ArrayList;
import java.util.Collections;

public class Function{
    private static ArrayList<ArrayList<Card>> table;
    private static ArrayList<Player> players;

    /**
     * Function to play one round
     * @param oldTable     the old table
     * @param oldPlayers     the old players
     * @param playerCard    Array of Cards from players (index of PlayerCard = index of Player)
     */
    public static void playCards(ArrayList<ArrayList<Card>> oldTable, ArrayList<Player> oldPlayers, ArrayList<Card> playerCard){
        //Update table and player
        table = oldTable;
        players= oldPlayers;

        //Lay Cards
        // Sort in ascending order (Player with lowest card-value starts)
        int[] playerOrder = getOrder(playerCard);
        //Place Cards on table
        for(int i=0; i<playerOrder.length;i++){
            placeCard(playerCard.get(playerOrder[i]),playerOrder[i]);
        }

    }

    /**
     * Helper Function to place a new Card in table
     * ->Evaluates if a table row is full
     * @param card  the card to place on table
     * @param playerIndex   the index of the player who throw the card
     */
    private static void placeCard(Card card, int playerIndex){
        int index= -1;           //index to get the position of the right table-row

        for(int i=0; i< table.size(); i++){
            Card lastCard= table.get(i).get(table.get(i).size()-1);
            if(lastCard.getValue()< card.getValue()){       //Check if current cards value is larger than last card in table-row
                if(index==-1) index= i;
                //Check where the card fits best and correct index if necessary
                if(table.get(index).get(table.get(index).size()-1).getValue() - card.getValue() < lastCard.getValue() - card.getValue()){
                    index = i;
                }
            }
        }
        //Set the card
        if(index!=-1){  //Case Card can be placed
            table.get(index).add(card);
            if(table.get(index).size()>5){
                int bulls= 0;
                for(int i=0; i< 5; i++){       //Count the bulls on Card and remove card 1-5 from table
                    bulls+= table.get(index).get(0).getBulls();
                    table.get(index).remove(0);
                }
                players.get(playerIndex).setBulls(bulls+players.get(playerIndex).getBulls());   //Add the bulls to player stats
            }
        }else{  //Case Card cannot be placed cause its value is too small
            /*Da hatte ich echt kein bock mehr :'D*/
        }
    }

    /**
     * Evaluates the right Order to add the cards to the table
     * @param playerCards
     * @return  The ascending order of the playerCards in form of an int Array
     */
    private static int[] getOrder(ArrayList<Card> playerCards){
        int[] order = new int[playerCards.size()];

        //initial List<Integer> with values of playerCards
        ArrayList<Integer> sortedCardValues = new ArrayList<Integer>();
        for(int i=0; i<playerCards.size();i++){
            sortedCardValues.add(playerCards.get(i).getValue());    //Sort the values
        }
        Collections.sort(sortedCardValues);

        for(int i=0; i<order.length;i++){
            for (int j=0; j<sortedCardValues.size(); j++){
                if(sortedCardValues.get(i) == playerCards.get(j).getValue()){   //compare the sorted values with the old ones
                    order[i]= j;       //get the right order
                }
            }
        }
        return order;
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