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
        String[] userArray = {"a","b","c"};
        String[] mainOptions = {"View current vent orientation", "Check current room  temperatures", "Change current room temperatures", "View Warning Status'", "Turn off Smart Furnace", "Logout"};
        UI ui = new UI();
        ui.mainScreen("a", mainOptions);
        ui.loginScreen("a", "qq");
        int userSelection = ui.welcomeScreen(userArray);
    }
    
}
