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
public class Passenger implements Serializable {
    private transient SimpleStringProperty name = new SimpleStringProperty("");
    private transient SimpleStringProperty age = new SimpleStringProperty("");
    
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
    
     private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(getPassengerName());
        s.writeUTF(getAge());
    }
    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        name = new SimpleStringProperty(s.readUTF());
        age = new SimpleStringProperty(s.readUTF());
    }
}
