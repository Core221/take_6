package game;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TakeSix extends Application{
    private Card[] stable;

    public TakeSix(){
        stable = new Card[104];
        for(int i=0; i<10; i++ ){
            stable[i] = new Card(i+1);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nimm 6!");

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 300,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}