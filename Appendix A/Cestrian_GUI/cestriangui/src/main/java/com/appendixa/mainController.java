package com.appendixa;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;






public class mainController {
    
    
    @FXML
    Label vehicleType, penaltyPoints;

   

    @FXML
    StackPane mainStackPane;

    @FXML
    private CheckBox checkbox25;

    
    @FXML
    private Button buttonConfirm;

    @FXML
    public void handleButtonClick() {

        // Alert alertError = new Alert(AlertType.ERROR);
        // This method will be called when the button is clicked
        
        //     // Check if the user has selected a vehicle type and penalty points
        // if (SelectionField.selectedVehicle == null || SelectionField.selectedVehicle.isEmpty()) {
            //     alert.setContentText("Error Please select a vehicle type.");
            //     return;
            // }
            
            // // else if (SelectionField.selectedPoint == 0) {
                // //     alertError.setContentText("Error Please select penalty points.");
                // //     return;
                // // }
                // else{
                    
                if (SelectionField.dropDownPenaltyPoints.getValue() != null && SelectionField.selectedVehicle != null){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Calculation : ");
                    alert.setHeaderText(null);
                    alert.setContentText("Total amount payable for insurance: " + calculateAmountForInsurance() + " \u00A3");
                    alert.showAndWait();
                    // to reset the total payable
                    total_payable = 0;
        }

        // }

    }

    private int total_payable;

    public void initialize(){

        SelectionField.groupButtonsFunction();


        SelectionField.selectCarType(vehicleType );
        SelectionField.selectPenaltyPoints(penaltyPoints);
        SelectionField.checkIfUnder25(checkbox25);


        // mainStackPane.getChildren().addAll(SelectionField.vboxassociated1, SelectionField.vboxassociated2);
        mainStackPane.setStyle("-fx-padding: 60; -fx-alignment: center;");


        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(SelectionField.vboxassociated1, SelectionField.vboxassociated2, SelectionField.vboxassociated3, buttonConfirm);
        mainStackPane.getChildren().addAll(mainLayout);




                // Position mainStackPane relative to its parent (Scene)
        mainStackPane.setLayoutX(100); // Set X position (distance from left)
        mainStackPane.setLayoutY(100); // Set Y position (distance from top)

    }








    private int calculateAmountForInsurance(){

        if (SelectionField.selectedVehicle == "car") {
            total_payable += 305; // Car base price
            if (SelectionField.selectedPoint > 6) {
                total_payable += 100; // Penalty for more than 6 points
            }
            if (SelectionField.isUnder25) {
                total_payable += 150; // Example penalty for under 25
            }
        } else if (SelectionField.selectedVehicle == "motorcycle") { // Change from 1 to 2
            total_payable += 360; // Motorcycle base price
            if (SelectionField.selectedPoint > 6) {
                total_payable += 100; // Penalty for more than 6 points
            }
            if (SelectionField.isUnder25) {
                total_payable += 150; // Example penalty for under 25
            }
        
        }
        return total_payable;
    }

// We have to reset the value of total Points
    

    
}
