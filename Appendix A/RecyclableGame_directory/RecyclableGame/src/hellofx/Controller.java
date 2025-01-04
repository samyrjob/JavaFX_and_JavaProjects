package hellofx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;



public class Controller {

    @FXML
    private Label levelReached, scoreLabel, timer, messageLoss;
    
    @FXML
    private Rectangle plasticBin;
    
    @FXML
    private Rectangle glassBin;

    @FXML
    private Rectangle foodWasteBin;

    @FXML
    private Rectangle paperBin;

    @FXML
    private Text plasticBinText;

    @FXML
    private Rectangle otherBin;

    @FXML
    private Circle wasteItem;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button startButton;
    
    @FXML
    private TextField playerNameField;

    @FXML
    private VBox rankPlayers;

    @FXML
    private VBox nameAndStart;



    Game game;
    Player player;
   
    // Define the score field
    private int score = 0;
    // Create a StackPane to hold the circle and the text
    // StackPane stackPane = new StackPane();

    private int currentWasteIndex = 0; // Track the current waste item index
    private List<StackPane> wasteStackPanes = new ArrayList<>(); // Store StackPanes for waste items

    private HashMap<String, Rectangle> map_binType = new HashMap<>();



    private LevelManager levelManager;

    private Timeline timeline;
    // private int timerSeconds = levelManager.getTimingForCurrentLevel();
    private int timerSeconds;
    private boolean isGameActive = true;
    private Button myButton, myButtonRestart;



    
    // This waste belongs to the plastic bin


    public void initialize() {


        Game.deserializeGamesObjects();
        // Set up event handler for the start button
        startButton.setOnAction(event -> {
            enterNameAndStartGame();
        });


        // Initially, the label is visible, and we don't show the button
        myButton = new Button("See rankings !");
        myButton.setOnAction( event -> displayRankPlayers());

        //Set the button action to restart the game 
        myButtonRestart = new Button("Restart the game !");

        // myButtonRestart.setOnAction(event -> {
        //     nameAndStart.setVisible(true);
        //     enterNameAndStartGame();
        //     revertToLabel();});

            myButtonRestart.setOnAction(event -> {
                // Prompt the player to enter a new name and restart
                String newPlayerName = promptForNewPlayerName(); // Method to get a new name (e.g., show a dialog)
                if (newPlayerName != null && !newPlayerName.trim().isEmpty()) {
                    // Create a new game instance
                    game = new Game(newPlayerName, new Player(newPlayerName), new LevelManager());
            
                    // Reset UI elements and game state
                    resetGameUI();
            
                    // Hide the name input and start the game
                    nameAndStart.setVisible(false);
                    gridPane.setVisible(true);
                    startGame();
                    startTimer();
                }
            });

        
    }

    private String promptForNewPlayerName() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Restart Game");
        dialog.setHeaderText("Enter a new player name:");
        dialog.setContentText("Name:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null); // Return the entered name or null if canceled
    }

    private void resetGameUI() {
        revertToLabel();
        // Clear the score label
        scoreLabel.setText("Score: 0");
    
        // Reset the level display
        levelReached.setText("Level: 1");
    
        // Clear any previous waste items
        gridPane.getChildren().removeAll(wasteStackPanes);
        wasteStackPanes.clear();
    
        // Hide ranking and reset its elements
        rankPlayers.getChildren().clear();
        rankPlayers.setVisible(false);
    
        // Reset timer label
        timer.setText("Timer: 0");
    }
    



    private void enterNameAndStartGame(){
        String playerName = playerNameField.getText().trim();
        if (!playerName.isEmpty()) {
            game = new Game(playerName, player, levelManager);
            nameAndStart.setVisible(false); // Hide the name field
            gridPane.setVisible(true); // Make the game interface visible
            startGame();
            startTimer();
            
        }
    }




    private void displayRankPlayers() {

        Collections.sort(Game.gamePlayers, game);

        int size_alist = Game.gamePlayers.size();
        // Populate the VBox with labels for each item
        System.out.println(Game.gamePlayers.size());

        int limit_loop =  (size_alist > 10 ? 10 : size_alist);
       
        for (int i = 0; i < limit_loop; i++) {
            Game gamePlayer = Game.gamePlayers.get(i);
            Label label = new Label((i + 1) + ". " + gamePlayer.toString()); // Display index before the object
            rankPlayers.getChildren().add(label);
        }
        
    
        gridPane.setVisible(false);
        rankPlayers.setVisible(true);
    }


    private void startGame(){
        
        // Set properties or modify the bins as needed
        plasticBinText.setText("Plastic Bin");
        otherBin.setStroke(Color.DARKBLUE);
        map_binType.put("FoodWaste", foodWasteBin);
        map_binType.put("Paper", paperBin);
        map_binType.put("Glass", glassBin);
        map_binType.put("Plastic", plasticBin);
        map_binType.put("Other", otherBin);

        // demander de rentrer le nom d'un joueur

        // Initialize the game 
        // initialize_game();




            setupNewLevel();
            // startTimer();
            // logic of what will happen if we drag over the 4 bins :
            handleDragOverAndDropped(foodWasteBin, "FoodWaste");
            handleDragOverAndDropped(glassBin, "Glass");
            handleDragOverAndDropped(paperBin, "Paper");
            handleDragOverAndDropped(plasticBin, "Plastic");
            handleDragOverAndDropped(otherBin, "Other");


    }


     private void startTimer() {
        if (timeline != null) {
            timeline.stop(); // Stop the previous timeline if it exists
        }

        timerSeconds = game.levelManager.getTimingForCurrentLevel(); // Reset timer for the current level
        timer.setText("Timer: " + timerSeconds);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timerSeconds--;
            timer.setText("Timer: " + timerSeconds);

            if (timerSeconds == 0) {
                timeline.stop();
                onTimerEnd(); // Handle what happens when time runs out
            }
        }));

        timeline.setCycleCount(timerSeconds); // Run for the specified number of seconds
        timeline.play(); // Start the timeline
    }

    private void onTimerEnd() {
        isGameActive = false; // Mark the game as inactive
        // Logic when the timer ends (e.g., fail the level)
       //! set text for trying again
       messageLoss.setText("Sorry the time is over....you lost ! ");
        wasteStackPanes.get(currentWasteIndex).setVisible(false);
        Game.gamePlayers.add(game);
        Game.serializeGamesObjects(Game.gamePlayers);
        // Optionally, reset the level or allow the player to retry
        replaceWithButton();
    }


    private StackPane createWasteItemStackPane(Waste waste) {
        StackPane stackPane = new StackPane();
        Circle wasteItem = new Circle(80, Color.DARKBLUE); // Create new circle for each waste
        Text text = new Text(waste.getName());
        text.setFill(Color.WHITE); // Adjust text color
        text.setStyle("-fx-font-weight: bold;");
        stackPane.getChildren().addAll(wasteItem, text);

        stackPane.setOnDragDetected(event -> {
            Dragboard dragboard = stackPane.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(waste.getBin()); // Attach bin type
            dragboard.setContent(content);
            stackPane.setOpacity(0.5);
                    // Capture a snapshot of the drag view
            var dragSnapshot = wasteItem.snapshot(null, null);

            // Set drag view with offsets to center it on the mouse
            dragboard.setDragView(dragSnapshot, dragSnapshot.getWidth() / 2, dragSnapshot.getHeight() / 2);

            // dragboard.setDragView(wasteItem.snapshot(null, null));
            event.consume();
        });

        stackPane.setOnDragDone(event -> {
            stackPane.setOpacity(1.0);
            event.consume();
        });

        return stackPane;
    }



    private void handleDragOverAndDropped(Rectangle binType, String bin_type){
                // Drag over event for plastic bin
                binType.setOnDragOver(event -> {
                    if (event.getGestureSource() != binType && event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                });
            
                // Drag dropped event for plastic bin
                binType.setOnDragDropped(event -> {
                    handleDrop(bin_type, event);
                    
                });
    }


        // Common logic for handling drop
        private void handleDrop(String bin_type, javafx.scene.input.DragEvent event) {

            if (!isGameActive) {
                event.setDropCompleted(false); // Prevent the drop
                event.consume();
                return;
            }

            Dragboard dragboard = event.getDragboard();
            boolean success = false;
    
            if (dragboard.hasString()) {
                String binType = dragboard.getString();
                System.out.println("Expected: " + bin_type + ", Found: " + binType);

                // Check if the dropped item matches the correct bin
                if (bin_type.equals(binType) ) {
                    game.player.addPoint(); // Add a point for correct bin
                    score = game.player.getPoints(); // Update the score from Player class
                    game.levelManager.incrementCorrectAnswers(); // Increment correct answers in LevelManager
                    updateScore(); // Update the score label
                }
                
                // After drop, hide the waste item (doesn't reappear)

                wasteStackPanes.get(currentWasteIndex).setVisible(false); // Hide current item
                currentWasteIndex++; // Move to next item

                if (currentWasteIndex < wasteStackPanes.size()) {
                    if (timerSeconds != 0){
                        wasteStackPanes.get(currentWasteIndex).setVisible(true); // Show the next waste item
                    }
                }
                else {
                        // Check if the player qualifies for the next level
                        if (game.levelManager.canMoveToNextLevel()) {
                            game.levelManager.nextLevel(); // Move to the next level
                            setupNewLevel(); // Setup new level items
                        } else {
                            // Optionally, display a message that the player failed the level
                            // labels_score.setText("Try again to progress!");
                            //! set text to try again 
                            messageLoss.setText("Sorry you lost !  ");
                            timeline.stop();
                            Game.gamePlayers.add(game);
                            Game.serializeGamesObjects(Game.gamePlayers);
                            replaceWithButton();
                        }
                         // create a button in the location of timer tag "start again"
                        // after we click on it it calls setupnewLevel()
                        // when we click the button disappears and is replaced by the new running timer count
                   
                    }


                success = true;
            }
    
            event.setDropCompleted(success);
            event.consume();
        }




        private void setupNewLevel() {

            isGameActive = true;
            // Clear the current waste items
            // gridPane.getChildren().clear();
            wasteStackPanes.clear();
            currentWasteIndex = 0;
        
            // Get new waste items for the next level
            List<Waste> newWasteItems = game.levelManager.createWasteItemsForLevel();
        
            for (Waste waste : newWasteItems) {
                StackPane stackPane = createWasteItemStackPane(waste);
                wasteStackPanes.add(stackPane);
                gridPane.add(stackPane, 0, 2); // Add to the GridPane
                stackPane.setVisible(false); // Hide initially
            }
        
            if (!wasteStackPanes.isEmpty()) {
                wasteStackPanes.get(0).setVisible(true); // Show the first waste item for the new level
            }
        
            // mandatory for the player, set the timer : 
            
    
            // Optionally update the level display
            levelReached.setText("Level: " + game.levelManager.getCurrentLevel());

            startTimer(); // Restart the timer for the new level
        }


        // Method to update the score label
        private void updateScore() {
            scoreLabel.setText("Score: " + score); // Update the label with the current score
        }




        // This method replaces the label with a button
        public void replaceWithButton() {

            int row = GridPane.getRowIndex(timer);
            int col = GridPane.getColumnIndex(timer);
            // Remove the label
            gridPane.getChildren().remove(timer);

            // Add the button at the same position
            GridPane.setRowIndex(myButton, row);
            GridPane.setColumnIndex(myButton, col);
            
            // Add the button in place of the label
            gridPane.getChildren().add(myButton);

            int row1 = GridPane.getRowIndex(levelReached);
            int col1 = GridPane.getColumnIndex(levelReached);
            // Remove the label
            gridPane.getChildren().remove(levelReached);

            // Add the button at the same position
            GridPane.setRowIndex(myButtonRestart, row1);
            GridPane.setColumnIndex(myButtonRestart, col1);
            
            // Add the button in place of the label
            gridPane.getChildren().add(myButtonRestart);
           
        }

            // This method reverts back to the label when the button is clicked
        public void revertToLabel() {
            // Remove the button
            gridPane.getChildren().remove(myButton);
            gridPane.getChildren().remove(myButtonRestart);
            
            // Add the label back
            gridPane.getChildren().add(timer);
                // Add the label back
            gridPane.getChildren().add(levelReached);
            
        }

}