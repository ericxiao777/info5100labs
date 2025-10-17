/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zherenxiao
 */
public class MainFXMLController implements Initializable {
    @FXML
    TextField schoolTextField;
    
    @FXML
    TextField registrationTextField;
    
    @FXML
    TextField schoolemailTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Controller initializing");
    }    
    
    
    public void submit() {

    try {
        String name;
        int age;
        String email;

        name = this.schoolTextField.getText().trim();
        String ageText = this.registrationTextField.getText().trim();
        email = this.schoolemailTextField.getText().trim();

        
        if (name.isEmpty()) {
            showErrorAlert("name cannot be empty. Please enter name.");
            return;
        }

        
        if (ageText.isEmpty()) {
            showErrorAlert("age cannot be empty. Please enter a valid age.");
            return;
        }

        
        age = Integer.parseInt(ageText);

        
        if (email.isEmpty()) {
            showErrorAlert("email cannot be empty. Please enter your email.");
            return;
        }

       

        showSuccessAlert("Submission successful!");

    } catch (NumberFormatException e) {
        showErrorAlert("Invalid number. Please provide digits only, e.g., 12345.");
    }
}
    

    
    public void showErrorAlert(String message){
        showAlert(message, Alert.AlertType.ERROR,"Ooops!");
    }
    
    public void showSuccessAlert(String message){
        showAlert(message, Alert.AlertType.INFORMATION,"Success!");
    }
    
    public void showAlert(String message, Alert.AlertType alertType, String headerText){
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
