package game;

public class Surface{
    private Card[][] table;
    private Player[] players;

    /**
     * Constructor for Surface with components:
     * Cards on the table
     * Cards in the Hand of Player
     */
    public Surface(int amountOfPlayer){
        table = new Card[4][5];
        players= new Player[amountOfPlayer];
    }

    /**
     * Function to initial the cards on the Table
     * @param tableCards
     */
    public void initialTable(Card[] tableCards){
        for(int i=0; i<4; i++){
            this.table[i][0] = tableCards[i];
        }
    }

    /**
     * Function to add a Player
     * @param name
     * @param cards
     */
    public void addPlayers(String name, Card[] cards){
        for(int i=0; i<players.length; i++){
            players[i] = new Player(name, cards);
        }
    }
}