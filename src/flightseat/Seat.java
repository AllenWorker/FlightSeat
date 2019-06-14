/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author allen
 */
public class Seat  implements Serializable{
    private transient SimpleStringProperty seatNum = new SimpleStringProperty("");
    private transient SimpleStringProperty classType = new SimpleStringProperty("");
    private transient SimpleStringProperty seatType = new SimpleStringProperty("");
    private transient SimpleObjectProperty<Passenger> passenger = new SimpleObjectProperty<Passenger>();
    
    public Seat(String seatNum, String classType, String seatType, Passenger passenger)
    {
        setSeatNumber(seatNum);
        setClassType(classType);
        setSeatType(seatType);
        setPassenger(passenger);
    }
    
    
    public SimpleStringProperty seatNumberProperty() 
    {
        return seatNum;
    }
    
    public SimpleStringProperty classTypeProperty() 
    {
        return classType;
    }
    
    public SimpleStringProperty seatTypeProperty() 
    {
        return seatType;
    }
    
    public SimpleObjectProperty passengerProperty()
    {
        return passenger;
    }
    
    public String getSeatNumber() 
    {
        return seatNum.get();
    }
    
    public String getClassType() 
    {
        return classType.get();
    }
    
    public String getSeatType() 
    {
        return seatType.get();
    }
    
    public Passenger getPassenger()
    {
        return passenger.get();
    }
    
    public final void setSeatNumber(String seatNum) 
    {
        this.seatNum.set(seatNum);
    }
    
    public final void setClassType(String classType) 
    {
        this.classType.set(classType);
    }
    
    public final void setSeatType(String seatType) 
    {
        this.seatType.set(seatType);
    }
    
    public final void setPassenger(Passenger passenger)
    {
        this.passenger.set(passenger);
    }
    
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(getSeatNumber());
        s.writeUTF(getClassType());
        s.writeUTF(getSeatType());
        s.writeObject(getPassenger());
    }
    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        seatNum = new SimpleStringProperty(s.readUTF());
        classType = new SimpleStringProperty(s.readUTF());
        seatType = new SimpleStringProperty(s.readUTF());
        passenger = new SimpleObjectProperty<Passenger>();
    }
}
