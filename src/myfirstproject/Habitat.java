package myfirstproject;
/**
 * Write a description of class Habitat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Habitat
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Habitat
     */
    public Habitat()
    {
        // initialise instance variables
        type = "paille";
    }

    public void setHabitat(String type){
        this.type = type;
    }
    
    public String getHabitat(){
        return this.type;
    }
    
    
}
