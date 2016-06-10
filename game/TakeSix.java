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

        this.player=4; //Just a example
    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.RED);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}