package com.appendixa;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class SelectionField {

    static RadioButton carButton  = new RadioButton("car");
    static RadioButton motorCycle = new RadioButton("motorcycle");
    static VBox vboxassociated1, vboxassociated2, vboxassociated3;
    public static ComboBox<Integer> dropDownPenaltyPoints = new ComboBox<>();
    public static boolean isUnder25;
    public static String selectedVehicle;
    public static int selectedPoint;

    static ToggleGroup toggleGroup = new ToggleGroup();

    static public void groupButtonsFunction(){

        carButton.setToggleGroup(toggleGroup);
        motorCycle.setToggleGroup(toggleGroup);
        dropDownPenaltyPoints.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11);
    }


    static public void selectCarType(Label labelAssociated){

    
        toggleGroup.selectedToggleProperty().addListener((obersable, oldValue, newValue) -> {
         
            if ((newValue != null)){
                RadioButton selectedButton = (RadioButton) newValue;
                labelAssociated.setText("Selected vehicle type :" + selectedButton.getText());
                selectedVehicle = selectedButton.getText();
            }
        });
        
        vboxassociated1 = new VBox(20, carButton, motorCycle, labelAssociated );
        // vboxassociated1.setStyle("-fx-padding: 20; -fx-alignment: center;");


    }

    
    static public void selectPenaltyPoints(Label labelAssociated){

        
        dropDownPenaltyPoints.setOnAction(event -> {
            selectedPoint = dropDownPenaltyPoints.getValue();

        });
        
        vboxassociated2 = new VBox(20, dropDownPenaltyPoints, labelAssociated );
    }



    static public void checkIfUnder25(CheckBox checkbox){

            checkbox.setOnAction(event -> {
                if (checkbox.isSelected()){
                    isUnder25 = true;
                }else {
                    isUnder25 = false; // Set to false when unchecked
                }
            });
          
            
            vboxassociated3 = new VBox(20, checkbox);
            

        


    }
    
}

 