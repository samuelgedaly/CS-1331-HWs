//Collaborated with Benjamin Vaisberg and Ash Bhimasani
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
* Class that creates the splash screen as well as the actual Pokedex
* @author Samuel Gedaly
* @version 1.0
*/
public class Pokedex extends Application {

/**
* Overrides the start method.
* This is where the Stage is created as well as the scenes and the buttons.
* @param primary which is the Stage that is passed in
*/
    @Override
    public void start(Stage primary) {
        Button startButton = new Button("Go!");
        BorderPane pane = new BorderPane();
        HBox pane2 = new HBox(25);
        Image intro = new Image("splashscreen.jpeg");
        ImageView imageView = new ImageView(intro);
        pane2.getChildren().add(imageView);

        ArrayList<Pokemon> array = new ArrayList<Pokemon>();
        array = PokemonFactory.createPokemon();
        ObservableList<BorderPane> items = FXCollections.observableArrayList();
        for (int i = 0; i < array.size(); i++) {
            BorderPane box = array.get(i).createSideView();
            Pokemon p = array.get(i);

            box.setOnMouseClicked((event) -> {
                    pane.setCenter(p.createDetailView());
                });
            items.add(box);
        }
        ListView<BorderPane> list = new ListView<BorderPane>(items);
        pane.setLeft(list);
        pane.setCenter(array.get(0).createDetailView());
        Scene splashScreen = new Scene(pane);
        startButton.setOnAction((ActionEvent event) -> {
                primary.setScene(splashScreen);
            });
        StackPane stack = new StackPane();
        stack.getChildren().addAll(pane2, startButton);
        Scene initial = new Scene(stack);
        primary.setScene(initial);
        primary.show();
    }
}