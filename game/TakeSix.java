package game;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TakeSix extends Application {
    private ArrayList<Card> stable;
    private int player;

    /** The games canvas. Is used to draw the game and retrieve width and height **/
    private Canvas canvas;

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
     * Gets n rnd choosen Cards from the stable and returns an Array
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
        surface.addPlayers(playerHand);
    }

    /**
     * Creates a star Menu in which you can choose the amount of Players
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nimm 6!");

        canvas = new Canvas();
        Pane container = new Pane(canvas);
        canvas.widthProperty().bind(container.widthProperty().subtract(2));
        canvas.heightProperty().bind(container.heightProperty().subtract(2));

        BorderPane layout = new BorderPane(container);

        // Placeholder button to redraw canvas manually. Drawing regularly using a thread is advised.
        Button placeholder = new Button("Draw");
        placeholder.setOnAction(event -> draw());
        layout.setTop(placeholder);
        // End of placeholder button;

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

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.RED);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}