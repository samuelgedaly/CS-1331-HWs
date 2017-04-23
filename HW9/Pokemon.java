//Collaborated with Benjamin Vaisberg and Ash Bhimasani
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
// Needed to start the JavaFX app:
import javafx.scene.layout.BorderPane;
// Needed to create/color an ellipse:
import javafx.scene.control.Label;
// Needed to make a button and add an event handler:

/**
 * Class representing a Pokemon that is recorded in the Pokedex
 * @author Samuel Gedaly
 * @version 1.0
 */
public class Pokemon {
    private String name;
    private HBox type = new HBox();
    private Image pic;
    private String description;
    private int generation;
    private int number;

    /**
     * Creates a Pokemon instance
     *
     * @param name of the Pokemon
     * @param pic the path to the image file
     * @param types the types of the Pokemon
     */
    public Pokemon(String name, String pic, Type ... types) {
        this.name = name;
        for (Type t : types) {
            type.getChildren().add(t.getTypeView());
        }
        type.setSpacing(5);
        this.pic = new Image(pic);

        createSideView();
        createDetailView();
    }

    /**
     * Creates the detail view of the Pokemon to be displayed in
     * the main section of the Pokedex.
     * @return Vbox that is the detailed view of the pokemon
     */
    public BorderPane createDetailView() {
        //Create the bigger detail view for the main pane here
        //Remember to actually save this view or change this method
        //header to return the view.
        //This method is called inside of PokemonFactory
        BorderPane p = new BorderPane();
        VBox pane2 = new VBox(10);
        ImageView imageView2 = new ImageView(pic);
        Label label1 = new Label(this.description);
        Label label2 = new Label("#" + this.number);
        Label label3 = new Label("Generation: " + generation);
        Label label4 = new Label(this.name);
        pane2.getChildren().addAll(imageView2, label4, type, label2, label3,
                                    label1);
        p.setCenter(pane2);
        return p;
    }

    /**
     * Creates the list view of the Pokemon to be displayed in
     * the list view panel
     * @return BorderPane which is the side view of the pokemon
     */
    public BorderPane createSideView() {
        //create the view that will be displayed for each entry in the list
        //in the side panel.
        //Remember to actually save this view or change this method header
        //to return the view. So that you can actually use it.
        //This method is called inside of PokemonFactory.
        BorderPane pane3 = new BorderPane();
        Label label = new Label(this.name);
        ImageView imageView3 = new ImageView(pic);
        imageView3.setFitWidth(100);
        imageView3.setFitHeight(100);
        pane3.setLeft(imageView3);
        pane3.setCenter(label);
        return pane3;
    }

    /**
     * Sets the description
     * @param d the description
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Sets the generation
     * @param generation the generation of the pokemon
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * Sets the number of the Pokemon
     * @param number the number of the pokemon
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
