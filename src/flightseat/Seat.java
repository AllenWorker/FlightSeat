/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author allen
 */
public class Seat {
    private final SimpleStringProperty seatNum = new SimpleStringProperty("");
    private final SimpleStringProperty classType = new SimpleStringProperty("");
    private final SimpleStringProperty seatType = new SimpleStringProperty("");
    private final SimpleObjectProperty<Passenger> passenger = new SimpleObjectProperty<Passenger>();
    
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
}
