package game;

import java.util.ArrayList;

public class Surface{
    private ArrayList<ArrayList<Card>> table;
    private Player[] players;

    /**
     * Constructor for Surface with components:
     * Cards on the table
     * Array of Players
     */
    public Surface(int amountOfPlayer){
        table = new ArrayList<ArrayList<Card>>();
        players= new Player[amountOfPlayer];
    }

    /**
     * Function to initial the cards on the Table
     *
     * @param tableCards
     */
    public void initialTable(ArrayList<Card> tableCards){
        for(int i=0; i< tableCards.size(); i++){
            ArrayList<Card> list= new ArrayList<Card>();
            list.add(tableCards.get(i));
            this.table.add(list);
        }
    }

    /**
     * Function to add a Player
     *
     * @param name
     * @param cards
     */
    public void addPlayers(String name, ArrayList<Card> cards){
        for(int i=0; i<players.length; i++){
            players[i] = new Player(name, cards);
        }
    }


    /*Getter & Setter */

    /**
     * Getter for table
     * @return  current cards on the table
     */
    public ArrayList<ArrayList<Card>> getTable(){
        return table;
    }

    public Player[] getPlayers(){
        return this.players;
    }

    /**
     * Setter for table
     * @param table
     */
    public void setTable(ArrayList<ArrayList<Card>> table){
        this.table= table;
    }
}