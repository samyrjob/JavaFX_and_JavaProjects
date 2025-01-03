package hellofx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class LevelManager implements Serializable{

    private static final long serialVersionUID = 1L;

    private int currentLevel;
    private int totalCorrectAnswers;
    private int totalWasteItems;
    private transient List<Waste> currentWasteItems;
    private List<String[]> wasteDataUntil5;
    private List<String[]> wasteDataAfter5;
    static private int timingSeconds;

    public LevelManager() {
        this.currentLevel = 1;
        timingSeconds = 60;
        this.totalCorrectAnswers = 0;
        this.currentWasteItems = new ArrayList<>();
        this.wasteDataUntil5 = new ArrayList<>();
        this.wasteDataAfter5 = new ArrayList<>();
    }


  
    // Reads the names and bin types from a seed file and loads them into the wasteData list
    private void loadWasteDataFromFile(String filePath, List<String[]> wasteData) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
            getClass().getResourceAsStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Split each line by the comma
                if (parts.length == 2) {  // Make sure there are exactly two parts: waste name and bin type
                    String name = parts[0].trim();  // Trim leading/trailing spaces from waste name
                    String binType = parts[1].trim();  // Trim leading/trailing spaces from bin type
                    wasteData.add(new String[]{name, binType});
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Creates waste items based on the level
    public List<Waste> createWasteItemsForLevel() {

        if (currentLevel<5){
            int numberOfItems = currentLevel * 5;  // e.g., 10 items for level 1, 20 for level 2, etc.
            List<Waste> wasteItems = new ArrayList<>();
    
             // Ensure the seed file is loaded (you can call this method during initialization)
             if (wasteDataUntil5.isEmpty()) {
                loadWasteDataFromFile("/hellofx/waste_data.txt", wasteDataUntil5);  // Load names from seed file
            } 
    
            // Create waste items and assign names randomly from the loaded list
            Random random = new Random();
            for (int i = 0; i < numberOfItems; i++) {
                String [] element_from_listWASTE = wasteDataUntil5.get(random.nextInt(wasteDataUntil5.size()));
                String name = element_from_listWASTE[0];  // Randomly pick a name
                String binType = element_from_listWASTE[1].trim(); 
                Waste waste = new Waste(name, binType);
                wasteItems.add(waste);
            }
    
            currentWasteItems = wasteItems;
            totalWasteItems = wasteItems.size();
            return wasteItems;
        }
        else {
            int numberOfItems = currentLevel * 5;  // e.g., 10 items for level 1, 20 for level 2, etc.
            List<Waste> wasteItems = new ArrayList<>();
    
             // Ensure the seed file is loaded (you can call this method during initialization)
             if (wasteDataAfter5.isEmpty()) {
                loadWasteDataFromFile("/hellofx/expanded_waste_data.txt", wasteDataAfter5);  // Load names from seed file
            }
    
            // Create waste items and assign names randomly from the loaded list
            Random random = new Random();
            for (int i = 0; i < numberOfItems; i++) {
                String [] element_from_listWASTE = wasteDataAfter5.get(random.nextInt(wasteDataAfter5.size()));
                String name = element_from_listWASTE[0];  // Randomly pick a name
                String binType = element_from_listWASTE[1].trim(); 
                Waste waste = new Waste(name, binType);
                wasteItems.add(waste);
            }
    
            currentWasteItems = wasteItems;
            totalWasteItems = wasteItems.size();
            return wasteItems;

        }
    }



    // Call this after each drop to update correct answers
    public void incrementCorrectAnswers() {
        totalCorrectAnswers++;
    }

    // Determines if the player should move to the next level
    public boolean canMoveToNextLevel() {
        double correctPercentage = (double) totalCorrectAnswers / totalWasteItems;
        return correctPercentage >= 0.75;  // 75% correct answers to move to the next level
    }

    // Move to the next level
    public void nextLevel() {
        if (canMoveToNextLevel()) {
            currentLevel++;
            timingSeconds -= 5;
            totalCorrectAnswers = 0; // Reset for the new level
            currentWasteItems.clear(); // Clear current waste items
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<Waste> getCurrentWasteItems() {
        return currentWasteItems;
    }

    public int getTimingForCurrentLevel(){
        return timingSeconds;
    }
}

