
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
import java.util.Collections;

public class TakeSix extends Application{

    private Surface playField;
    private Canvas canvas;

    /**
     * Constructor for Game TakeSix
     */
    public TakeSix(){
        newGame();
        for(int rounds=0; rounds < 10; rounds++){
           nextRound();
        }

    }

    /**
     * Start of a new Game
     *
     * 1. Ask for the start condition
     * 2. Create a playField
     * 3. Initials the playField with table cards and players
     * 4. Draw the playField
     */
    public void newGame(){
        //1. Ask for start conditions
        /*Example Values*/
        int player = 4;
        String[] nickNames = new String[player];
        for(int i=0; i< player; i++){
            nickNames[i] = "Player "+ (i+1);
        }
        /*=================*/
        //2. Create a new playField
        playField= new Surface();

        //Create a stable
        ArrayList<Card> stable = new ArrayList<>();
        for(int i=0; i<104; i++){
            stable.add(new Card(i+1));
        }

        // Add Players to Game
        for(int i= 0; i< player; i++){
            playField.addPlayers(nickNames[i],helperFunctions.rndCards(stable,10));
        }
        //Lay 4 Cards on the table
        playField.initialTable(helperFunctions.rndCards(stable,4));

        // 4. Draw the playField

        System.out.printf("The Start Situation:\n");
        playField.toDraw();
    }

    /**
     * Play a round
     *
     * 1. Every player lays (by turn) a card covert in the middle
     * 2. Add the cards on the position of the table
     * 3. Print a new version of the table
     */
    public void nextRound(){
        // 1. Lay cards in the middle
        ArrayList<Card> chosenCards = new ArrayList<Card>();
        for(int i=0; i< playField.getPlayers().size(); i++) {
            chosenCards.add(playField.getPlayers().get(i).chooseCard());    //W#hlt nur die erste auf Hand
        }
        // 2. Place Cards on table
        placeCards(chosenCards);

        // 3. Draw updated playField
        /*Ausgabe nach Runde*/
        System.out.printf("\n\nAfter Round"+":\n");
        playField.toDraw();
    }

    /**
     * Place the played cards in the right spots on the table
     *
     * 1. Sorting cards in ascending order depending on its value
     * 2. Place every single card in the right order
     *
     * @param cards
     */
    public void placeCards(ArrayList<Card> cards){
        //1. get the right order of the cards
        int[] playerOrder = getOrder(cards);
        //2. Place Cards on table
        for(int i=0; i<cards.size();i++){
            setCard(cards.get(playerOrder[i]),playerOrder[i]);
        }
    }

    /**
     * Checks the card values and returns the index of cards in ascending order
     * Bsp.: 42, 9 , 13, 102 -> int[] ={1,2,0,3}
     *
     * @param cards
     * @return
     */
    private static int[] getOrder(ArrayList<Card> cards){
        int[] order = new int[cards.size()];
        //initial List<Integer> with values of playerCards
        ArrayList<Integer> sortedCardValues = new ArrayList<Integer>();
        for(int i=0; i<cards.size();i++){
            sortedCardValues.add(cards.get(i).getValue());    //Sort the values
        }
        Collections.sort(sortedCardValues);
        //get indices of the right order
        for(int i=0; i<order.length;i++){
            for (int j=0; j<sortedCardValues.size(); j++){
                if(sortedCardValues.get(i) == cards.get(j).getValue()){   //compare the sorted values with the old ones
                    order[i]= j;
                }
            }
        }
        return order;
    }

    /**
     * Place the Card or start a new row
     *
     * 1. Find the position where the card belongs and same the index
     * 1.1 If this isn't possible because the card value is too small return let: index = -1
     * 2. Add the card to the row and check if the size isn't bigger than 5
     * 2.1 Player can decide which row he wants to start new and has to take the old cards
     * 3. Add the bulls to the player
     *
     * @param card
     * @param playerIndex
     */
    public void setCard(Card card, int playerIndex){
        // index to get the fitting row
        int index= -1;
        //1. Find position
        for(int i=0; i< playField.getTable().size(); i++){
            Card lastCard= playField.getTable().get(i).get(playField.getTable().get(i).size()-1);
            if(lastCard.getValue()< card.getValue()){       //Check if current cards value is larger than last card in playField.getTable()-row
                if(index==-1) index= i;
                //Check where the card fits best and correct index if necessary
                if(playField.getTable().get(index).get(playField.getTable().get(index).size()-1).getValue() - card.getValue() < lastCard.getValue() - card.getValue()){
                    index = i;
                }
            }
        }
        int bulls= 0;
        //2. Case Card can be placed
        if(index!=-1){
            playField.getTable().get(index).add(card);
            if(playField.getTable().get(index).size()>5){
                for(int i=0; i< 5; i++){       //Count the bulls on Card and remove card 1-5 from playField.getTable()
                    bulls+= playField.getTable().get(index).get(0).getBulls();
                    playField.getTable().get(index).remove(0);
                }
            }
        //2.1   Case Card cannot be placed cause its value is too small
        }else{
            /*Player has to make a choice*/
            int playerchoice= 0;
            /*===========================*/
            playField.getTable().get(playerchoice).add(card);
            for(int i=0; i<playField.getTable().get(playerchoice).size(); i++){
                bulls+= playField.getTable().get(playerchoice).get(0).getBulls();
                playField.getTable().get(playerchoice).remove(0);
            }

        }
        // 3. Player gets the bulls
        playField.getPlayers().get(playerIndex).setBulls(bulls+playField.getPlayers().get(playerIndex).getBulls()); //Add the bulls to player stats
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

}