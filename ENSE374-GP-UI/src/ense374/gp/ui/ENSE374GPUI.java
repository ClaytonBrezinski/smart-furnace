/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense374.gp.ui;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

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
        
        // set up the back end of the program
        Controller controller = new Controller(); 

        Scanner input;

        try
        {
                input = new Scanner(new File("vent.txt"));
        }

        catch (Exception e)
        {
                System.out.println("ERROR: File not found.");
                return;
        }

        int p = 0;
        int c = 0;
        String room = "";

        while (input.hasNext())
        {
                p = input.nextInt();

                if (input.hasNextInt())
                {     
                        c = input.nextInt();
                        controller.addJunction(p, c);

                }
                else
                {
                        room = input.next();
                        controller.addRoom(p, room);

                }

        }

        //controller.debug_printRooms(); //this goes through the system and debug_prints out every leaf node it comes across.
                                 //Doesn't debug_print them in the order in which they were added, but that really doesn't matter.

        //controller.setDesiredRoomTemp("bedroom1", 21, 1);
        //controller.setDesiredRoomTemp("kitchen", 21.5, 0.4);
       // controller.setDesiredRoomTemp("laundryroom", 20, 2);
       // controller.setDesiredRoomTemp("bathroom2", 21, 1);

       // controller.check(22);
        //controller.debug_printRooms();

       // System.out.println("bedroom1: " + controller.getRoomInfo("bedroom1", "temperature") + " " + controller.getRoomInfo("bedroom1", "desiredtemp") + " " + controller.getRoomInfo("bedroom1", "tolerance") + " " + controller.getRoomInfo("bedroom1", "invalid"));



        
        // testing area of the UI 
        int MAX_TEMP = 25;
        int MIN_TEMP = 17;
        
        String[] mainOptions = {"View current vent orientation", "Check current room  temperatures", "Change current room temperatures", "View Warning Status'", "Turn off Smart Furnace"};
        // we will make a function that will get these room names. 
        String[] roomNames = {"bathroom2","livingroom","laundryroom", "kitchen", "bathroom1", "bedroom1"}; // this will need to be pulled from eric's program. 
        
        String[] childRestrictions = {"bedroom1", "laundryroom"};   // child is not allowed to making changes to the bedroom1 or laundryroom
        User[] userArray = {new User("Mom", null, "a"), new User("Child",childRestrictions, "b"), new User("System Tech", null, "p")};   
        
        UI ui = new UI(userArray, mainOptions, roomNames, controller);
    }
    
}
