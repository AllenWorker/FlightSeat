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
public class Passenger implements Serializable {
    private String name = "";
    private String age = "";
    
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
    
    public String getPassengerName() 
    {
        return name;
    }
    
    public String getAge() 
    {
        return age;
    }
    
    public final void setPassengerName(String name) 
    {
        this.name = name;
    }
    
    public final void setAge(String age) 
    {
        this.age = age;
    }
}
