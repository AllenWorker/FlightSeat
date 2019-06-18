/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    Seat[][] seatArray;
    @FXML
    private Button searchBtn;
    @FXML
    private Button closeBtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Button clickBtn = (Button)event.getSource();
        
        Dimension result = searchButton(btnArry, clickBtn);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Input.fxml"));
        Parent parent = fxmlLoader.load();
        InputController dialogController = fxmlLoader.<InputController>getController();
        dialogController.setSeatNum(seatArray[result.height][result.width].getSeatNumber());
        dialogController.setClassType(seatArray[result.height][result.width].getClassType());
        dialogController.setSeatType(seatArray[result.height][result.width].getSeatType());
        dialogController.setName(seatArray[result.height][result.width].getPassenger().getPassengerName());
        dialogController.setAge(seatArray[result.height][result.width].getPassenger().getAge());
        dialogController.init();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        if(dialogController.getSubmit())
        {
            seatArray[result.height][result.width].setPassenger(new Passenger(dialogController.getName(), dialogController.getAge()));
            int location = 4*(6*result.height + (result.width));
            File seatmap = new File("seatmap.txt");
            switch(dialogController.getAge())
            {
                case "Adult":
                     btnArry[result.height][result.width].setText("A");
                     seatmap = new File("seatmap.txt");
                     writeToRandomAccessFile(seatmap, location, "A");
                     break;
                case "Child":
                     btnArry[result.height][result.width].setText("C");
                     seatmap = new File("seatmap.txt");
                     writeToRandomAccessFile(seatmap, location, "C");
                     break;
            }           
        }
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
        readData();
        initialButtonArray();
    } 
    
    public void initialButtonArray()
    {
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
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(seatArray[i][j].getPassenger().getPassengerName()==null || seatArray[i][j].getPassenger().getPassengerName().equals(""))
                {
                    btnArry[i][j].setText("*");
                } else
                {
                    switch(seatArray[i][j].getPassenger().getAge())
                    {
                        case "Adult":
                            btnArry[i][j].setText("A");
                            break;
                        case "Child":
                            btnArry[i][j].setText("C");
                            break;
                    }
                }
            }
        }
    }
    
    public void createNewSeatMap()
    {
        seatArray = new Seat[12][6];
        String classType;
        String seatType;
        String initial;
        String seatNum;
        Passenger emptyPassenger = new Passenger();
        for (int i = 0; i < 12; i++) {
            if(i<2)
                {
                    classType = "First Class";
                }
                else if (i>=2 && i<6)
                {
                    classType = "Business Class";
                }
                else
                {
                    classType = "Economy Class";
                }
            for (int j = 0; j < 6; j++) {
                switch(j){
                    case 0:
                        initial = "A";
                        seatType = "Window";
                        break;
                    case 1:
                        initial = "B";
                        seatType = "Middle";
                        break;
                    case 2:
                        initial = "C";
                        seatType = "Aisle";
                        break;
                    case 3:
                        initial = "D";
                        seatType = "Aisle";
                        break;
                    case 4:
                        initial = "E";
                        seatType = "Middle";
                        break;
                    case 5:
                        initial = "F";
                        seatType = "Window";
                        break;
                    default:
                        initial = "!";
                        seatType = "Error";
                        break;
                }
                seatNum = initial+(i+1);
                seatArray[i][j] = new Seat(seatNum, classType, seatType, emptyPassenger);
            }
        }
    }
    
    public void readData()
    {
        try
        {
            File savedata = new File("savedata.dat");
            File seatmap = new File("seatmap.txt");
            if(!savedata.exists())
            {
              try
              {
                  createNewSeatMap();
                  FileOutputStream outputFile = new FileOutputStream(savedata);
                  ObjectOutputStream outputObj = new ObjectOutputStream(outputFile);
                  outputObj.writeObject(seatArray);
                  outputObj.close();
                  outputFile.close();
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("New data");
                  alert.setHeaderText(null);
                  alert.setContentText("Data doesn't exist! Creating new Data!");

                  alert.showAndWait();
                  FileInputStream inputFile = new FileInputStream(savedata);
                  ObjectInputStream inputObj = new ObjectInputStream(inputFile);
                  seatArray = (Seat[][]) inputObj.readObject();
                  inputObj.close();
                  inputFile.close();
              }
              catch (IOException i)
              {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Creating New Data Filed!");
                  alert.setHeaderText(null);
                  alert.setContentText("Filed to create savedata.dat!" + i);
                  alert.showAndWait();
              }
            }
            if(!seatmap.exists())
            {
                  createNewSeatMap();
                  int position = 0;
                  String result = "";
                  for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 6; j++) {
                        result += (seatArray[i][j].toString() + ",");
                    }
//                    result += "\n";
                }
                  writeToRandomAccessFile(seatmap, position, result);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("New map");
                  alert.setHeaderText(null);
                  alert.setContentText("SeatMap doesn't exist! Creating new Map!");
                  alert.showAndWait();
            }
            FileInputStream inputFile = new FileInputStream(savedata);
            ObjectInputStream inputObj = new ObjectInputStream(inputFile);
            seatArray = (Seat[][]) inputObj.readObject();
            inputObj.close();
            inputFile.close();

        } 
        catch (IOException i)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Reading New Data Filed!");
            alert.setHeaderText(null);
            alert.setContentText("Filed to read savedata.dat!");
            alert.showAndWait();
        }
        catch (ClassNotFoundException c)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Class Not Found!");
            alert.setHeaderText(null);
            alert.setContentText("Class not found!");
            alert.showAndWait();
        }
        
    }
    public void saveData()
    {
        try
        {
            FileOutputStream outputFile = new FileOutputStream("savedata.dat");
            ObjectOutputStream outputObj = new ObjectOutputStream(outputFile);
            outputObj.writeObject(seatArray);
            outputObj.close();
            outputFile.close();
        }
        catch (IOException i)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Saving Data Filed!");
            alert.setHeaderText(null);
            alert.setContentText("Filed to save savedata.dat!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void searchBtnAction(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search.fxml"));
        Parent root = (Parent)fxmlLoader.load();          
        SearchController controller = fxmlLoader.<SearchController>getController();
        
        controller.setSeatArray(seatArray);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    private static void writeToRandomAccessFile(File file, int position, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// write String to RandomAccessFile 
			fileStore.writeChars(record);
			fileStore.close(); 
                    } catch (IOException e) { 
			e.printStackTrace(); 
                    }  
    }
    
    private static char readFromRandomAccessFile(File file, int position) { 
		char record = 'E'; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "r"); // read mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// read String from RandomAccessFile 
			record = fileStore.readChar(); 
			//record = fileStore.readLine();
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		return record; 
	}
    @FXML
    private void handleCloseBtnAction(ActionEvent event) {
        saveData();
        Stage stage = (Stage) closeBtn.getScene().getWindow();
   
        stage.close();
    }
}
