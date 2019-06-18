/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author allen
 */
public class SearchController implements Initializable {

    @FXML
    private Spinner<Integer> seatNumSpinner;
    @FXML
    private Text seatNumTxt;
    @FXML
    final ToggleGroup group = new ToggleGroup();
    
    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 1);
    @FXML
    private RadioButton RBtnA;
    @FXML
    private RadioButton RbtnB;
    @FXML
    private RadioButton RbtnC;
    @FXML
    private RadioButton RbtnD;
    @FXML
    private RadioButton RbtnE;
    @FXML
    private RadioButton RbtnF;
    @FXML
    private Button searchBtn;
    @FXML
    private Text nameTxt;
    @FXML
    private Text ageTxt;
    @FXML
    private Text classTxt;
    @FXML
    private Text seatPosTxt;
    
    private Seat[][] seatArray;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valueFactory.valueProperty().addListener((obs, oldValue, newValue) -> spinnerChange());
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (group.getSelectedToggle() != null) {
          spinnerChange();
        }
      }
    });
        seatNumSpinner.setValueFactory(valueFactory);
        RBtnA.setToggleGroup(group);
        RBtnA.setSelected(true);
        RbtnB.setToggleGroup(group);
        RbtnC.setToggleGroup(group);
        RbtnD.setToggleGroup(group);
        RbtnE.setToggleGroup(group);
        RbtnF.setToggleGroup(group);
        
        RBtnA.setUserData(1);
        RbtnB.setUserData(2);
        RbtnC.setUserData(3);
        RbtnD.setUserData(4);
        RbtnE.setUserData(5);
        RbtnF.setUserData(6);
    }    

    private void spinnerChange() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String col = selectedRadioButton.getText();
        seatNumTxt.setText(col + seatNumSpinner.getValue().toString());
    }
    
     public Dimension binarySearch(String line, int row)
     {
        Dimension result = new Dimension(-1,-1);
        String[] seatLine = {"A","B","C","D", "E", "F"};
        int first = 0;
        int last = seatLine.length-1;
        int mid=0;
        boolean found = false;

        while (first <= last && !found)
        {
            mid = (first + last) / 2;

            if (seatLine[mid].toUpperCase().equals(line.toUpperCase())||seatLine[mid].toUpperCase().compareTo(line.toUpperCase()) == 0) // cannot use == for string comparisons
                found = true;
            else if (seatLine[mid].toUpperCase().compareTo(line.toUpperCase()) > 0) 
                last = mid - 1;
            else
                first = mid + 1;
        }

        if (found)
        {
            result.height = row-1;
            result.width = mid;
            return result;
        }
        else
        {
            return result;
        }
            
     }
    
    public void setSeatArray(Seat[][] seatArray)
    {
        this.seatArray = seatArray;
    }
    
    public Seat[][] getSeatArray()
    {
        return seatArray;
    }

    @FXML
    private void searhBtnClick(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String col = selectedRadioButton.getText();
        Dimension result = binarySearch(col, seatNumSpinner.getValue());
        nameTxt.setText((seatArray[result.height][result.width].getPassenger().getPassengerName().equals("")) ? "Seat Available!" : seatArray[result.height][result.width].getPassenger().getPassengerName());
        ageTxt.setText(seatArray[result.height][result.width].getPassenger().getAge());
        classTxt.setText(seatArray[result.height][result.width].getClassType());
        seatPosTxt.setText(seatArray[result.height][result.width].getSeatType());
    }
}
