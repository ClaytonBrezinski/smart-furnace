/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense374.gp.ui;

/**
 *
 * @author Dolan
 */
public class ENSE374GPUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // testing area
        int MAX_TEMP = 25;
        int MIN_TEMP = 17;
        
        String[] mainOptions = {"View current vent orientation", "Check current room  temperatures", "Change current room temperatures", "View Warning Status'", "Turn off Smart Furnace"};
        String[] roomNames = {"Q","R","S"}; // this will need to be pulled from eric's program. 
        
        String[] childRestrictions = {"Bedroom1", "bedroom2"};
        User[] userArray = {new User("Mom", null, "a"), new User("Child",childRestrictions, "b"), new User("System Tech", null, "p")};   
        
        UI ui = new UI(userArray, mainOptions, roomNames);
    }
    
}
