/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author allen
 */
public class InputController implements Initializable {

    @FXML
    private RadioButton adultRb;
    @FXML
    private RadioButton childRb;
    @FXML
    private Text seatNumTxt;
    @FXML
    private TextField passengerNameTxt;
    @FXML
    private Text classTypeTxt;
    @FXML
    private Text seatTypeTxt;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button submitBtn;
    @FXML
    final ToggleGroup group = new ToggleGroup();
    
    private String seatNum;
    private String classType;
    private String seatType;
    private boolean submit = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setSeatNum(String seatNum)
    {
        this.seatNum = seatNum;
        seatNumTxt.setText(seatNum);
    }
    
    public void setClassType(String classType)
    {
        this.classType = classType;
        classTypeTxt.setText(classType);
    }
    
    public void setSeatType(String seatType)
    {
        this.seatType = seatType;
        seatTypeTxt.setText(seatType);
    }
    
    public String getSeatNum()
    {
        return seatNum;
    }
    
    public String getClassType()
    {
        return classType;
    }
    
    public String getSeatType()
    {
        return seatType;
    }
    
    public boolean getSubmit()
    {
        return submit;
    }

    @FXML
    private void submitBtnClick(ActionEvent event) {
    }
            
}
