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
        UI ui = new UI();
        ui.loginScreen("a", "qq");
        int userSelection = ui.welcomeScreen(userArray);
    }
    
}
