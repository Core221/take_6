package game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;


public class Surface extends Application{

    Button btn_start;
    public Surface(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nimm 6!");
        btn_start= new Button("Start");

        StackPane layout = new StackPane();
        layout.getChildren().add(btn_start);

        Scene scene = new Scene(layout, 300,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}