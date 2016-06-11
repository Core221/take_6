package game;

import java.util.ArrayList;

public class Surface{
    private ArrayList<ArrayList<Card>> table;
    private ArrayList<Player> players;

    /**
     * Constructor for Surface with components:
     * Cards on the table
     * Array of Players
     */
    public Surface(int amountOfPlayer){
        table = new ArrayList<ArrayList<Card>>();
        players= new ArrayList<Player>();
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
            players.add(new Player(name, cards));
    }

    /**
     * Draw the Surface new
     */
    public void toDraw(){       //Momentan nur ne Konsolenausgabe
        System.out.printf("Table: \n");
        for(int i=0; i<table.size(); i++){
            for(int j=0; j<table.get(i).size(); j++){
                System.out.printf(table.get(i).get(j).getValue()+"  ");
            }
            System.out.printf("\n");
        }

        for(int i=0; i<players.size(); i++){
            System.out.print("\n"+ players.get(i).getName() + ", Bulls: " + players.get(i).getBulls()+"\n");
            for(int j=0; j<players.get(i).getCards().size(); j++){
                System.out.printf(players.get(i).getCards().get(j).getValue()+", ");
            }
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

    /**
     * Getter for players
     * @return  player acc
     */
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    /**
     * Setter for table
     * @param table
     */
    public void setTable(ArrayList<ArrayList<Card>> table){
        this.table= table;
    }

    /**
     * Setter for players
     * @param players
     */
    public void setPlayers(ArrayList<Player> players){
        this.players= players;
    }
}