/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemomatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Scene2Controller implements Initializable {

    private Stage    stage;
    private Scene    scene;
    private Parent   root;
    
    private Stage    currentStage;  //same as callerStage 
    private Stage    callerStage;   
    private Scene    callerScene;
    Scene1Controller callerController;
    
    @FXML private TextField txtMsg2;
    @FXML private Button    btnBack2;
    @FXML private TableView<Customer> tableCustomer;
    @FXML private TableColumn<Customer, Integer> colID;
    @FXML private TableColumn<Customer, String>  colName;
    @FXML private TableColumn<Customer, String>  colPhone;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Setup and populate the GUI Customer[ID, name, phone] TableView
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        //Put some data in the table
        Customer c1 = new Customer(111, "Homer Simpson", "555-1234");
        Customer c2 = new Customer(222, "Hermione Ranger", "777-1234");
        Customer c3 = new Customer(333, "Diana Prince", "555-9999");
        tableCustomer.getItems().addAll(c1, c2, c3);
       
        //Add more data and refresh the table
        tableCustomer.getItems().add(new Customer(444,"Arya Stark", "888-1234"));
        tableCustomer.refresh();
    }    

    
    public void acceptData(String data, Stage callerStage, Scene callerScene1, 
                         Scene1Controller callerController1) {        
        //Use this method to receive data from the caller (Scene1Controller)
        txtMsg2.setText(data);
        this.callerStage = callerStage; //scene1 and scene2 use the same stage!
        this.callerScene = callerScene1;
        this.callerController = callerController1;
    }

    @FXML
    private void btnGoBackClick(ActionEvent event) throws IOException {
        //Pass some data from this GUI to caller Scene1Controller
        callerController.acceptData(txtMsg2.getText());
        
        //Set the stage with the last image of Scene1 (including its state data)
        callerStage.setScene(callerScene);  // restore scene1
        callerStage.show();
        
    }

    @FXML
    private void tableCustomerOnMousClicked(MouseEvent event) {
        //Pick from the Customer table the chosen row and show it
        Customer selectedCust = tableCustomer.getSelectionModel().getSelectedItem();
        if (selectedCust != null) {
           txtMsg2.setText(selectedCust.getId()     + ", " 
                         + selectedCust.getName()   + ", " 
                         + selectedCust.getPhone());    
        }
        

    }
    
    
}
