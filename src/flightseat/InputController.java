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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author allen
 */
public class InputController {

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
    private String name;
    private String age;
    private boolean submit = false;
    
    public void init()
    {
        adultRb.setToggleGroup(group);
        adultRb.setSelected(true);
        childRb.setToggleGroup(group);
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
    
    public void setName(String name)
    {
        this.name = name;
        passengerNameTxt.setText(name);
    }
    
    public void setAge(String age)
    {
        this.age = age;
        switch(age)
        {
            case "Adult":
                adultRb.setSelected(true);
                adultRb.requestFocus();
                break;
            case "Child":
                childRb.setSelected(true);
                childRb.requestFocus();
                break;
            case "":
                adultRb.setSelected(true);
                adultRb.requestFocus();
                break;
        }
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
    
    public String getName()
    {
        return name;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public boolean getSubmit()
    {
        return submit;
    }

    @FXML
    private void submitBtnClick(ActionEvent event) {
        submit = true;
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        age = selectedRadioButton.getText();
        name = passengerNameTxt.getText();
        closeStage(event);
    }
    
    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
