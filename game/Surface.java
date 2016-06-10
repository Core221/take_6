package game;

public class Surface{
    private Card[][] table;
    private Player[] players;

    /**
     * Constructor for Surface with components:
     * Cards on the table
     * Array of Players
     */
    public Surface(int amountOfPlayer){
        table = new Card[4][6];
        players= new Player[amountOfPlayer];
    }

    /**
     * Function to initial the cards on the Table
     *
     * @param tableCards
     */
    public void initialTable(Card[] tableCards){
        for(int i=0; i<4; i++){
            this.table[i][0] = tableCards[i];
        }
    }

    /**
     * Function to add a Player
     *
     * @param name
     * @param cards
     */
    public void addPlayers(String name, Card[] cards){
        for(int i=0; i<players.length; i++){
            players[i] = new Player(name, cards);
        }
    }


    /*Getter & Setter */

    /**
     * Getter for table
     * @return  current cards on the table
     */
    public Card[][] getTable(){
        return table;
    }

    public Player[] getPlayers(){
        return this.players;
    }

    /**
     * Setter for table
     * @param table
     */
    public void setTable(Card[][] table){
        this.table= table;
    }
}