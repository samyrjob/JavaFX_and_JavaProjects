package hellofx;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.scene.control.Label;

public class Game implements Serializable, Comparator<Game>{

    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    Player player;
    LevelManager levelManager;
        
    static public ArrayList<Game> gamePlayers = new ArrayList<>();





    public int compare(Game game1, Game game2){
        
        if( game2.player.getPoints() - game1.player.getPoints() >0){
            return 1;
        }
        else if (game2.player.getPoints() - game1.player.getPoints() <0){

            return -1;
        }
        else {
            return 0;
        }
    }

    Game(String namePlayer, Player player, LevelManager levelManager){
        this.player =  new Player(namePlayer);
        levelManager = new LevelManager();
        this.levelManager = levelManager;
    }

    @Override
    public String toString() {
        return "Player name = " + player.getName() + "  Score = " + player.getPoints() +  "  Level reached = " + levelManager.getCurrentLevel();
    }



    static public void deserializeGamesObjects() {

        try {

            FileInputStream fileIn = new FileInputStream("gamePlayers.ser");
             ObjectInputStream objIn = new ObjectInputStream(fileIn);
    
            while (true) {
                try {
                    gamePlayers = (ArrayList<Game>) objIn.readObject(); // Deserialize each object
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




    static public void serializeGamesObjects(ArrayList<Game> gamePlayers) {
        try  {
            FileOutputStream fileOut = new FileOutputStream("gamePlayers.ser");
            BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);
            ObjectOutputStream objOut = new ObjectOutputStream(bufferedOut);
            

            
            objOut.writeObject(gamePlayers); // Serialize the object

            objOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    

    
}
