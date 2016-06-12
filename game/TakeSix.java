
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

public class TakeSix extends Application{
    private ArrayList<Card> stable;
    private int player;
    private String[] nickNames;
    private Canvas canvas;

    /**
     * Constructor for Game TakeSix
     */
    public TakeSix(){
        /*Example Values*/
        this.player = 4; //Just a example
        this.nickNames = new String[4];
        for(int i=0; i<4; i++){
            this.nickNames[i] = "Player "+ i;
        }
        /*=================*/
        //Create a stable
        stable = new ArrayList<>();
        for(int i=0; i<104; i++){
            stable.add(new Card(i+1));
        }
        //Start game and initial Table with rnd Cards
        Surface surface = new Surface(this.player);
        surface.initialTable(rndCards(4));

        // Add Players to Game
        for(int i= 0; i< this.player; i++){
            surface.addPlayers(this.nickNames[i]+1,rndCards(10));
        }

        /* Ausgabe des Startzustandes*/
        System.out.printf("The Start Situation:\n");
        surface.toDraw();

        // Play the game    ->(max 10 rounds possible)
        for(int rounds=0; rounds < 10; rounds++){

            ArrayList<Card> choosenCards = new ArrayList<Card>();
            for(int i=0; i< this.player; i++) {
            /*Hier müsste die sinnvolle Kartenauswahl statt finden*/
                int decision = 0;
            /*======*/
                Card cardOfPlayer= surface.getPlayers().get(i).getCards().get(decision); //Sind nur Beispiel Karten!!
                surface.getPlayers().get(i).getCards().remove(decision);
                surface.getPlayers().get(i).setCards(surface.getPlayers().get(i).getCards());
                choosenCards.add(cardOfPlayer);
            }
            // Evaluate the position of Cards on table
            Function.playCards(surface.getTable(),surface.getPlayers(),choosenCards);
            //Update functions to refresh table and stats
            surface.setTable(Function.updateTable());
            surface.setPlayers(Function.updatePlayers());

        /*Ausgabe nach Runde*/
            System.out.printf("\n\nRound "+(rounds+1)+":\n");
            surface.toDraw();
        }


    }

    /**
     * Gets n rnd chosen Cards from the stable and returns an Array of Cards
     *
     * @param amount    wished amount of cards
     * @return Array of cards
     */
    public ArrayList<Card> rndCards(int amount){
        ArrayList<Card> cards = new ArrayList<>();
        for(int i=0; i<amount; i++){
            int rnd = (int)(Math.random() * (stable.size()-i));
            cards.add(stable.get(rnd));
            stable.remove(rnd);
        }
        return cards;
    }

    /**
     * Creates a start menu in which you can choose the amount of Players and NickNames
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Take 6!");

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

    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.RED);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void playerAction(){
        System.out.printf("Hallo world");
    }
}