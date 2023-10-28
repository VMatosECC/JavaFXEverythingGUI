//Scene1Controller manages the user interactions with Scene1

package javafxdemomatos;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author 12164
 */
public class Scene1Controller implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private HBox btnLogin;
    @FXML
    private CheckBox chkOlives;
    @FXML
    private CheckBox chkSausage;
    @FXML
    private CheckBox chkAnchovies;
    @FXML
    private RadioButton radDoubleCheese;
    @FXML
    private ToggleGroup togGroupCheese;
    @FXML
    private RadioButton radNoCheese;
    @FXML
    private RadioButton radHalfCheese;
    @FXML
    private TextArea txtMsg;
    @FXML
    private ComboBox<String> comPayment;
    @FXML
    private Slider sliderTip;
    @FXML
    private MenuBar menuBarMain;
    @FXML
    private ToggleGroup toggleGroupCloud;
    @FXML
    private Hyperlink linkGoogle;
    @FXML
    private Hyperlink linkWiki;
    @FXML
    private ImageView imgLogo;
    @FXML
    private ListView<String> lstNames;
    @FXML
    private Button btnNextScene;
    @FXML
    private Button btnClearAll;
    @FXML
    private Button btnShowSelections;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chkOlives.setSelected(true); //default value
        radDoubleCheese.setSelected(true); //default value
        comPayment.getItems().addAll("Cash", "Credit Card", "Cryto$");
        lstNames.getItems().addAll("Homer", "Marge", "Bart", "Lisa", 
                "Maggie", "Millhouse", "Ned Flanders", "Mr. Burns");
    }    

    @FXML
    private void btnClearAllClicked(ActionEvent event) {
        txtMsg.setText("");
        txtPassword.setText("");
        txtUserName.setText("");
        chkOlives.setSelected(false);
        chkSausage.setSelected(false);
        chkAnchovies.setSelected(false);
        
        RadioButton radSelected = (RadioButton)(togGroupCheese.getSelectedToggle());
        if (radSelected != null ) radSelected.setSelected(false);

    }

    @FXML
    private void btnShowSelectionsClicked(ActionEvent event) {
        // Extract values supplied by the user after interacting with the GUI.
        // Pickup name and password from their TextField conatiners, get the 
        // ChecBox and RadioButton selections, the Tip Slider and the payment
        // choice selected from the ComboBox
        // ---------------------------------------------------------------------
        txtMsg.setText("");
        txtMsg.appendText(" >>> Time: " + LocalDateTime.now() );
        txtMsg.appendText("\n You said USER:  [" + txtUserName.getText() + 
                          "],  PWD: [" + txtPassword.getText() + "]");
        
        txtMsg.appendText("\n Chk   Olives:    " + chkOlives.isSelected());
        txtMsg.appendText("\n Chk   Sausage:   " + chkSausage.isSelected());        
        txtMsg.appendText("\n Chk   Anchovies: " + chkAnchovies.isSelected()); 
        
        txtMsg.appendText("\n Radio 2X Cheese: " 
                         + String.valueOf(radDoubleCheese.isSelected()));
        txtMsg.appendText("\n Radio No Cheese: " 
                         + String.valueOf(radNoCheese.isSelected()));
        txtMsg.appendText("\n Radio Half Ch:   " 
                         + String.valueOf(radHalfCheese.isSelected()));
        RadioButton radSelected = (RadioButton)(togGroupCheese.getSelectedToggle());
        
        txtMsg.appendText("\n Tip %            " 
                         + String.valueOf(sliderTip.getValue()   ));
        
        
        txtMsg.appendText("\n Radio Button: " + String.valueOf(radSelected));
        
        if(radSelected != null && radSelected.equals(radDoubleCheese)){
            txtMsg.appendText("\n DOUBLE CHEESE selected");
        }
        else if(radSelected != null && radSelected.equals(radNoCheese)){
            txtMsg.appendText("\n NO CHEESE selected");
        }
        else if(radSelected != null && radSelected.equals(radHalfCheese)){
            txtMsg.appendText("\n HALF CHEESE selected");
        }
        else{
            txtMsg.appendText("\n NO RADIO (CHEESE) selected");
        }
        
        //Clearup any selected radio button
        //if (radSelected != null ) radSelected.setSelected(false);
        
        //Try to extract the payment mode from the exception throwing ComboBox
        try{
            String money = comPayment.getValue();
            txtMsg.appendText("\n MONEY: " + money);
        }
        catch(Exception e)
        {
            txtMsg.appendText("\n " + e.getMessage());      
        }
        
        //Pick a name from the ListView
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        txtMsg.appendText("\n lstNames selected item is: " + selectedName);
   
    }

    @FXML
    private void handleOnActionFileOpen(ActionEvent event) {
        //The top MenuBar "File" item includes among other its choices "Open"
        txtMsg.appendText("\n Option OPEN");
    }

    @FXML
    private void handleOnActionFileClose(ActionEvent event) {
        //The top MenuBar "File" item includes among other its choices "Close"
        txtMsg.appendText("\n Option CLOSE");
    }

    @FXML
    private void visitGoogle(ActionEvent event) throws URISyntaxException {
        //Try to reach Google.com using the URI given below
        try {
            Desktop.getDesktop().browse(new URI("www.Google.com"));
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void visitWiki(ActionEvent event) throws URISyntaxException {
        //Try to reach Wikipedia.org using the URI given below
        try {
            Desktop.getDesktop().browse(new URI("www.wikipedia.org"));
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lstMouseClicked(MouseEvent event) {
        //Pick a person's name from the listview control
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        System.out.println("lstMouseClicked():  " + selectedName);        
                
    }

    

    @FXML
    private void btnNextSceneClick(ActionEvent event) throws IOException {
        
        //Find out the current stage&scene - Ask any control for its placement.
        Scene  scene1 =  btnNextScene.getScene();
        Stage  stage  = (Stage)scene1.getWindow(); 

        //Who am I?
        Scene1Controller scene1Controller = this;
        
        //Get prepare to load Scene2 on the stage
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        Parent root2 = loader2.load();
        Scene scene2 = new Scene(root2);
        
        //Get a reference to the other controller
        Scene2Controller scene2Controller = loader2.getController();
        
        //Pass some data to the other controller
        scene2Controller.acceptData(txtUserName.getText(), 
                                  stage, 
                                  scene1,
                                  scene1Controller);  
        
       
        //Use the same stage, mount scene2 (displacing scene1)
        stage.setScene(scene2);
        stage.show(); 
        

    }
    
    public void acceptData(String data)
    {
        //The 'data' value comes from Scene2Controller!
        //It did that before showing Scene1 again
        txtMsg.appendText("\n Data from Scene2: " + data);
    }

    
}
