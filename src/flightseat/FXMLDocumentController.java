/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author allen
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML   private Button A1Btn;    @FXML   private Button B1Btn;
    @FXML   private Button C1Btn;    @FXML   private Button D1Btn;
    @FXML   private Button E1Btn;    @FXML   private Button F1Btn;
    @FXML   private Button A2Btn;    @FXML   private Button B2Btn;
    @FXML   private Button C2Btn;    @FXML   private Button D2Btn;
    @FXML   private Button E2Btn;    @FXML   private Button F2Btn;
    @FXML   private Button A3Btn;    @FXML   private Button B3Btn;
    @FXML   private Button C3Btn;    @FXML   private Button D3Btn;
    @FXML   private Button E3Btn;    @FXML   private Button F3Btn;
    @FXML   private Button A4Btn;    @FXML   private Button B4Btn;
    @FXML   private Button C4Btn;    @FXML   private Button D4Btn;
    @FXML   private Button E4Btn;    @FXML   private Button F4Btn;
    @FXML   private Button A5Btn;    @FXML   private Button B5Btn;
    @FXML   private Button C5Btn;    @FXML   private Button D5Btn;
    @FXML   private Button E5Btn;    @FXML   private Button F5Btn;
    @FXML   private Button A6Btn;    @FXML   private Button B6Btn;
    @FXML   private Button C6Btn;    @FXML   private Button D6Btn;
    @FXML   private Button E6Btn;    @FXML   private Button F6Btn;
    @FXML   private Button A7Btn;    @FXML   private Button B7Btn;
    @FXML   private Button C7Btn;    @FXML   private Button D7Btn;
    @FXML   private Button E7Btn;    @FXML   private Button F7Btn;
    @FXML   private Button A8Btn;    @FXML   private Button B8Btn;
    @FXML   private Button C8Btn;    @FXML   private Button D8Btn;
    @FXML   private Button E8Btn;    @FXML   private Button F8Btn;
    @FXML   private Button A9Btn;    @FXML   private Button B9Btn;
    @FXML   private Button C9Btn;    @FXML   private Button D9Btn;
    @FXML   private Button E9Btn;    @FXML   private Button F9Btn;
    @FXML   private Button A10Btn;    @FXML   private Button B10Btn;
    @FXML   private Button C10Btn;    @FXML   private Button D10Btn;
    @FXML   private Button E10Btn;    @FXML   private Button F10Btn;
    @FXML   private Button A11Btn;    @FXML   private Button B11Btn;
    @FXML   private Button C11Btn;    @FXML   private Button D11Btn;
    @FXML   private Button E11Btn;    @FXML   private Button F11Btn;
    @FXML   private Button A12Btn;    @FXML   private Button B12Btn;
    @FXML   private Button C12Btn;    @FXML   private Button D12Btn;
    @FXML   private Button E12Btn;    @FXML   private Button F12Btn;    
    
    Button[][] btnArry;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickBtn = (Button)event.getSource();
        
        System.out.println(clickBtn.getId());
        Dimension result = searchButton(btnArry, clickBtn);
        System.out.println(btnArry[result.height][result.width].getId());
    }
    
    
    public Dimension searchButton(Button[][] btnArry, Button target)
    {
        Dimension result = new Dimension(-1,-1);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (btnArry[i][j].equals(target)){
                    result.height = i;
                    result.width = j;
                    return result;
                 }
            }
        }
        return result;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnArry = new Button[][]
        {
            {A1Btn, B1Btn, C1Btn, D1Btn, E1Btn, F1Btn},
            {A2Btn, B2Btn, C2Btn, D2Btn, E2Btn, F2Btn},
            {A3Btn, B3Btn, C3Btn, D3Btn, E3Btn, F3Btn},
            {A4Btn, B4Btn, C4Btn, D4Btn, E4Btn, F4Btn},
            {A5Btn, B5Btn, C5Btn, D5Btn, E5Btn, F5Btn},
            {A6Btn, B6Btn, C6Btn, D6Btn, E6Btn, F6Btn},
            {A7Btn, B7Btn, C7Btn, D7Btn, E7Btn, F7Btn},
            {A8Btn, B8Btn, C8Btn, D8Btn, E8Btn, F8Btn},
            {A9Btn, B9Btn, C9Btn, D9Btn, E9Btn, F9Btn},
            {A10Btn, B10Btn, C10Btn, D10Btn, E10Btn, F10Btn},
            {A11Btn, B11Btn, C11Btn, D11Btn, E11Btn, F11Btn},
            {A12Btn, B12Btn, C12Btn, D12Btn, E12Btn, F12Btn}
        };
        
    }    
    
}
