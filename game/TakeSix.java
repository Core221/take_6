package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class TakeSix extends Application{
    private ArrayList<Card> stable;
    private int player;
    private String[] nickNames;

    /**
     * Constructor for Game TakeSix
     */
    public TakeSix(){
        //Create a stable
        stable = new ArrayList<Card>();
        for(int i=0; i<104; i++){
            stable.add(new Card(i+1));
        }
        //Start game and initial Table with rnd Cards
        Surface surface = new Surface(this.player);
        surface.initialTable(rndCards(4));

        // Add Players to Game
        for(int i= 0; i< this.player; i++){
            surface.addPlayers(this.nickNames[i],rndCards(10));
        }
        // Play the game    ->(Jet just 1 Round)

        Card[] choosenCards = new Card[this.player];
        for(int i=0; i< this.player; i++){
            /*Hier müsste die Kartenauswahl statt finden*/
            choosenCards[i]= surface.getPlayers()[i].getCards()[0];     //Sind nur Beispiel Karten!!

        }
        surface.setTable(Function.playCards(surface.getTable(),choosenCards));  //update the current table in surface

    }

    /**
     * Gets n rnd chosen Cards from the stable and returns an Array of Cards
     *
     * @param amount    wished amount of cards
     * @return Array of cards
     */
    public ArrayList<Card> rndCards(int amount){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i=0; i<amount; i++){
            int rnd = (int)(Math.random() * (stable.size()-i));
            cards.add(stable.get(rnd));
            stable.remove(rnd);
        }
        return cards;
    }

    /**
     * Creates a star menu in which you can choose the amount of Players and NickNames
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Take 6!");

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 400,400);

        primaryStage.setScene(scene);
        primaryStage.show();
        /* You can choose an amount of Players*/

        this.player = 4; //Just a example
        this.nickNames = new String[this.player];
        for(int i=0; i<player; i++){
            this.nickNames[i] = "Player "+ i;
        }
    }
}