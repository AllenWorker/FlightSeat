/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseat;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author allen
 */
public class Passenger {
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty age = new SimpleStringProperty("");
    
    public Passenger()
    {
        setPassengerName("");
        setAge("");
    }
    
    public Passenger(String name, String age)
    {
        setPassengerName(name);
        setAge(age);
    }
    
    
    public SimpleStringProperty passengerNameProperty() 
    {
        return name;
    }
    
    public SimpleStringProperty ageProperty() 
    {
        return age;
    }
    
    public String getPassengerName() 
    {
        return name.get();
    }
    
    public String getAge() 
    {
        return age.get();
    }
    
    public final void setPassengerName(String name) 
    {
        this.name.set(name);
    }
    
    public final void setAge(String age) 
    {
        this.age.set(age);
    }
}
