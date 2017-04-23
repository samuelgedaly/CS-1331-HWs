//Collaborated with Benjamin Vaisberg
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;
import java.util.ArrayList;

/**
* class Yik Yak
* @author Samuel Gedaly
* @version 1.0
*/
public class YikYak extends Application {

    //Create a linked list called postList that holds Yaks currently in
    //the feed
    private LinkedList<Post> postList = new SinglyLinkedList<Post>();
    private BorderPane borderPane = new BorderPane();
    private ArrayList<StackPane> listOfPanes = new ArrayList<>();
    private ObservableList<StackPane> observableListOfPanes;
    private ListView<StackPane> listView = new ListView<>();
    private String[] phrases = {
        "Pass the buck.",
        "Excited for Java 9 to come out this summer. Can't wait for that #REPL",
        "So sad Taylor and Justin are graduating. We'll miss you!",
        "Kendrick Lamar new album out",
        "EventHandler is the thing that handles the event." };

/**
* start method where the primary stage is set
* @param stage of type Stage
*/
    public void start(Stage stage) {
        Button refreshButton = new Button("Refresh");
        Button deleteButton = new Button("Delete");
        ImageView bannerImage = new ImageView(new Image("YikYakBanner.png"));
        ToolBar toolbar = new ToolBar(refreshButton, deleteButton);
        borderPane.setTop(bannerImage);
        borderPane.setBottom(toolbar);
        borderPane.setCenter(listView);
        refreshButton.setOnAction(e -> {
                generatePosts();
                updateDisplay();
            });
        deleteButton.setOnAction(e -> {
                deletePosts();
                updateDisplay();
            });
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show(); // makes the window visible to the user
    }

    /**
     * This method should add new posts to your list of posts.
     */
    public void generatePosts() {
        Random rand = new Random();
        int r = rand.nextInt(3) + 1;
        int r2;
        for (int i = 0; i < r; i++) {
            r2 = rand.nextInt(phrases.length);
            Post phrase = new Post(phrases[r2]);
            postList.add(phrase);
        }
    }

    /**
     * This method should delete posts from your list of posts.
     */
    public void deletePosts() {
        postList.remove(postList.size() - 1);
    }

    /**
     * This method updates the feed that is displayed to the user.
     */
    public void updateDisplay() {
        listOfPanes = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++) {
            ImageView postImage = new ImageView(new Image("YikYakPost.png"));
            Text postText = new Text(postList.get(i).getText());
            postText.setWrappingWidth(250);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(postImage, postText);
            stackPane.setAlignment(postImage, Pos.CENTER_LEFT);
            listOfPanes.add(stackPane);
        }
        observableListOfPanes = FXCollections.observableArrayList(listOfPanes);
        listView = new ListView<>(observableListOfPanes);
        borderPane.setCenter(listView);
    }

    /**
     * This class represents the individual posts that make up the feed.
     */
    private class Post {
        private String text;
        private final int TEXT_LIMIT = 50;

        public Post(String text) {
            if (text.length() < TEXT_LIMIT) {
                this.text = text;
            } else {
                this.text = text.substring(0, TEXT_LIMIT);
            }
        }

        public String getText() {
            return text;
        }
    }

}
