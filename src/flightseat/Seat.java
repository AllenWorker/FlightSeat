/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;


import java.io.Serializable;


/**
 *
 * @author allen
 */
public class Seat  implements Serializable{
    private String seatNum = "";
    private String classType = "";
    private String seatType = "";
    private Passenger passenger = new Passenger();
    
    public Seat(String seatNum, String classType, String seatType, Passenger passenger)
    {
        setSeatNumber(seatNum);
        setClassType(classType);
        setSeatType(seatType);
        setPassenger(passenger);
    }
    
    
    
    
    public String getSeatNumber() 
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
    
    public Passenger getPassenger()
    {
        return passenger;
    }
    
    public final void setSeatNumber(String seatNum) 
    {
        this.seatNum = seatNum;
    }
    
    public final void setClassType(String classType) 
    {
        this.classType = classType;
    }
    
    public final void setSeatType(String seatType) 
    {
        this.seatType = seatType;
    }
    
    public final void setPassenger(Passenger passenger)
    {
        this.passenger = passenger;
    }
    
    @Override
    public String toString()
    {
        if (passenger.getAge().equals(""))
        {
            return "*";
        }
        else 
        {
            return passenger.getAge();
        }
    }
}
