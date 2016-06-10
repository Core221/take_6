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
            surface.addPlayers(nickNames[i],rndCards(10));
        }
    }

    /**
     * Gets n rnd chosen Cards from the stable and returns an Array
     *
     * @param amount    wished amount of cards
     * @return Array of cards
     */
    public Card[] rndCards(int amount){
        Card[] cards = new Card[amount];
        for(int i=0; i<amount; i++){
            int rnd = (int)(Math.random() * (stable.size()-i));
            cards[i] = stable.get(rnd);
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

        this.player=4; //Just a example
        nickNames = new String[this.player];
        for(int i=0;i<player;i++){
            nickNames[i]= i+"";
        }
    }
}