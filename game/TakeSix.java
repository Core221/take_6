package game;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TakeSix extends Application{
    private ArrayList<Card> stable;
    private int player;


    public TakeSix(){
        //Create a stable
        stable = new ArrayList<Card>();
        for(int i=0; i<104; i++){
            stable.add(new Card(i+1));
        }
        //Start game and initial Table with rnd Cards
        Surface surface = new Surface();
        Card[] initialCards = new Card[4];

        for(int i=0; i<4; i++){
            int rnd = (int)(Math.random() * (104-i));
            initialCards[i] = stable.get(rnd);
            stable.remove(rnd);
        }
        surface.initialTable(initialCards);
        // Add Players to Game
        Card[][] playerHand= new Card[player][10];
        for(int i= 0; i< this.player; i++){
           for(int j=0; j<10; j++){
               int rnd = (int)(Math.random() * (100-(i+j)));
               playerHand[i][j] = stable.get(rnd);
               stable.remove(rnd);
           }
        }
        surface.addPlayers(playerHand);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nimm 6!");

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 400,400);

        primaryStage.setScene(scene);
        primaryStage.show();

        this.player=4; //Just a example
    }
}