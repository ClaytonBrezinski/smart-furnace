/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense374.gp.ui;
import java.util.Scanner;
/**
 *
 * @author Dolan
 */
public class UI 
{
    private Scanner input = new Scanner(System.in);
    private User user;
    /*
    Purpose: Default constructor
    Arguements: none
    Returns: none
    Notes: will be expanded on, when a UI is created, it will begin the UI process.
    */
    public UI(User[] users, String[] mainScreenOptions, String[] roomNames)
    {
        // create list of users
        String[] userNames = createListOfUsers(users);
        boolean successfulLogin = false;
        
        while (successfulLogin == false)
        {
            int userChoice = welcomeScreen(userNames);
            this.user = users[userChoice];
            if (loginScreen(user.getName()) == true)
            {
                successfulLogin = true;
            }
        }
        while (successfulLogin == true)
        {
            int mainScreenChoice = mainScreen(user.getName(), mainScreenOptions);
            switch(mainScreenChoice)
            {
                case 0: currentVentOrientation();
                        break;
                case 1: currentRoomTemperatures();
                        break;
                case 2: changeRoomTemperatures(roomNames);
                        break;
                case 3: warningSystemStatus();
                        break;
                case 4: System.exit(0);
                        break;
            }
        // call UI from here
        }
    }
    
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    private void currentRoomTemperatures()
    {
        
        System.out.println('\n' + "Current room temperatures");
        System.out.println("press any key to return");
        // have output here
        
        
        String userSelection = input.nextLine();
        return;
    }
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    private void currentVentOrientation()
    {
        System.out.println('\n' + "Current vent orientation");
        System.out.println("press any key to return");
        // have output here
        
        String userSelection = input.nextLine();
        return;
    }
    /*
    Purpose: Provide a first screen to the user and allow them to select a user
    Arguements: String[]- list of registered users
    Returns: int - the user within the String[] listOfUsers that was selected
    Notes:  can improve by having this call loginScreen when the user is determined. 
            will likely have to remove String[] from the arguements and place it 
            in the class variables. 
    */
    public int welcomeScreen(String[] listOfUsers)
    {
        boolean userSelected = false;
        int userInt = -1;
        String userSelection;
                
        System.out.println('\n' + "Welcome to Smart Furnace");
        while (userSelected == false)
        {
            System.out.println("Please select a user:");
            // i = 1 and .length + 1 so that format is 1. ### 2. ### etc. not 0. ### 1. ###
            for (int i = 1; i < listOfUsers.length + 1; i++)
            {
                System.out.println(i + ". " + listOfUsers[i - 1]);
            }
            userSelection = input.nextLine();
            
            /* 
            determine if the user has selected the user based off of the name 
            or based off of the number beside the name. Following this, check if 
            the user exists in the given array of users. If so, print the 
            selected user. If not, prompt the user to select another one.
            
            */
            boolean isAnInteger = isInteger(userSelection);
            if (isAnInteger == true)
            {
                userInt = Integer.parseInt(userSelection) - 1;
                if (userInt >= 0 && userInt <= listOfUsers.length) 
                {
                    System.out.println('\n' + "The user: " + listOfUsers[userInt] + " has been selected");
                    userSelected = true;
                }
                else
                {
                    System.out.println('\n' + "this is not a valid user-number to select, please try another");
                }
            }
            else
            {
                userInt = inUserList(listOfUsers, userSelection);
                // if userSelected is one within the list of users, notify the user and then exit the loop
                if (userInt != -1)
                {
                    System.out.println('\n' + "The user: " + listOfUsers[userInt] + " has been selected");
                    userSelected = true;
                }
                else
                {
                    System.out.println('\n' + "this is not a username to select, please try another");
                }
            }
        }
        // make sure that userInt > 0
        assert (userInt > 0);
        return userInt;
    }
    /*
    Purpose:    provide a login screen for the selected user and to allow the user to return
                back to the welcome screen
    Arguements: String- selected username from the welcome screen, String- corresponding user's password
    Return:     boolean- returns false if the user wants to select another username, returns true if successful password match
    Notes:  to expand on this, I could add a functionality such that there is a timed 
            lockout after 5 unsuccessful password attempts
    */
    public boolean loginScreen(String username)
    {
        String inputPassword = "";
        boolean correctPassword = false;
        
        while (correctPassword == false)
        {
            System.out.println('\n' + "Press x to return and select another user");
            System.out.println("Username: " + username);
            System.out.print("Password: ");
            inputPassword = input.nextLine();
            
            if ( user.isCorrectUserPassword(inputPassword) == true)
            {
                correctPassword = true;
                return true;
            }
            else if (inputPassword.equalsIgnoreCase("x"))
            {
                return false;
            }
            else
            {
                System.out.println("incorrect password, please try again" + '\n'); 
            }
        }
        return false; // default statement that will never be hit
    }


    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    public int mainScreen(String user, String[] mainOptions)
    {
        String userSelection;
        int userChoice = -1;
        boolean validChoice = false;
        System.out.println('\n' + "Welcome " + user + ",");
        while (validChoice == false)
        {
            System.out.println("What would you like to do?:");
            for (int i = 0; i < mainOptions.length; i++)
            {
                System.out.println((i + 1) + ". " + mainOptions[i]);
            }

            userSelection = input.nextLine();
            boolean isAnInteger = isInteger(userSelection);
            if (isAnInteger == true)
            {
                userChoice = Integer.parseInt(userSelection) - 1;
                if (userChoice >= 0 && userChoice <= mainOptions.length)
                {
                  return userChoice;
                }
                else
                {
                    System.out.println("This is an invalid choice, please try another");
                }
            }
            else
            {
                System.out.println("Please enter a number to select your choice");
            }
        }
        // default return statement - should never be hit.
        return userChoice;
    }
    
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    public void changeRoomTemperatures(String[] rooms)
    {
        String userSelection;
        int userChoice = -1;
        boolean validChoice = false;
        System.out.println("Change Current Temperatures");
        while (validChoice == false)
        {
            System.out.println("Which room temperature would you like to change?:");
            for (int i = 0; i < rooms.length; i++)
            {
                System.out.println((i + 1) + ". " + rooms[i]);
            }
            
            userSelection = input.nextLine();
            boolean isAnInteger = isInteger(userSelection);
            if (isAnInteger == true)
            {
                userChoice = Integer.parseInt(userSelection) - 1;
                if (userChoice >= 0 && userChoice <= rooms.length)
                {
                  if ( userHasAccess(rooms[userChoice]) == true)
                  {
                      
                  }
                }
                else
                {
                    System.out.println("This is an invalid choice, please try again");
                }
            }
            else
            {
                System.out.println("Please enter a number to select your choice");
            }
        }
        // default return statement - should never be hit.
    }
    
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */    
    private boolean userHasAccess(String roomSelected)
    {
        // get room restrictions from user class
        String[] restrictions = user.getAccessRestrictions();
        if (restrictions == null)
        {
            return true; // this is for users that do not have any restrictions 
        }
        for (int i = 0; i < restrictions.length; i++)
        {
            if (roomSelected == restrictions[i])
            {
                return false;
            }            
        }
        // default statement if user does have access. 
        return true;
    }
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    public void warningSystemStatus()
    {
        // have to grab: double waterDetectorStatus, double coDetectorStatus
        // temp variables:
        double waterDetectorStatus = 0.0; double coDetectorStatus = 0.0;
        
        System.out.println('\n' + "Warning System Status");
        System.out.println("Water Detector: " + interperateWaterStatus(waterDetectorStatus));
        System.out.println("Carbon Monoxide Detector: " + interperateCOStatus(coDetectorStatus));
        System.out.println("Press 'V' to view the warning logs, Press any key to exit");
        String userSelection = input.nextLine();
        if (userSelection.equalsIgnoreCase("V"))
        {
           warningSystemLogs();
        }
        else
        {
            return;
        }
    }
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
    private void warningSystemLogs()
    {
        System.out.println('\n' + "Warning system logs");
        System.out.println("press any key to return");
        
        
        String userSelection = input.nextLine();
        return;
        // needs to end with a return call to warning system status.
    }
    /*
    Purpose: area where its easy to set suitable levels of water being detected
    Arguements: double- the reading from the water detector
    Return: string- statment of water level that a user will understand
    Notes: 
    */
    
    /*
    Purpose:
    Arguements:
    Return:
    Notes: change back to private
    */
    public void tempChangeRequest(String roomToBeChanged,int MAX_TEMP, int MIN_TEMP)
    {
        boolean validChoice = false;
        
        System.out.println("Change Current Temperatures");
        System.out.println("Please enter the temperature you wish to change " + roomToBeChanged + " to");
        String userTemperature = input.nextLine();
        while (validChoice == false)
        {
            if (isInteger(userTemperature) == true)
            {
                int newTemp = Integer.parseInt(userTemperature);
                if (newTemp >= MAX_TEMP || newTemp <= MIN_TEMP)
                {
                    System.out.println("This is an invalid temperature, " + MIN_TEMP + " and " + MAX_TEMP + " are your bounds");
                    System.out.println("Please try another");
                }
                else
                {
                        validChoice = true;
                }
            }
        }
        // return to change room temperatures
    }
    
    private String interperateWaterStatus(double waterDetectorStatus)
    {
        // can't use case here since Java doesnt support use of double, float, or booleans in case statements :(
        if (waterDetectorStatus < 0.0)
        {
            return "Error with the water detector, please contact support";
        }
        else if (waterDetectorStatus == 0.0)
        {
            return "Good";
        }
        else if (waterDetectorStatus > 0.0 && waterDetectorStatus < 2.0)
        {
            return "Small amounts of water detected";
        }
        else if (waterDetectorStatus > 2.0)
        {
            return "Large amounts of water detected";
        }
        else 
        {
            return "error in interperating water status";
        }
    }
    
    private String interperateCOStatus(double coDetectorStatus)
    {
        if (coDetectorStatus < 0.0)
        {
            return "Error with the CO detector, please contact support";
        }
        else if (coDetectorStatus == 0.0)
        {
            return "Good";
        }
        else if (coDetectorStatus > 0.0 && coDetectorStatus < 2.0)
        {
            return "Small amounts of CO detected, please leave the building and call support";
        }
        else if (coDetectorStatus > 2.0)
        {
            return "Large amounts of CO detected, leave immediately and call emergency services";
        }
        else 
        {
            return "error in interperating CO status";
        }
    }
    
     /*
    Purpose:    to determine if the given string is located within the given String[]. 
                This function will ignore all cases within each string
    Arguements: String[]- given array that is to be looked through, String- string we are looking for in String[]
    Return: int: -1 if match not found, if match found, return a positive integer.
    Notes: 
    */
    private int inUserList(String[] userList, String selection)
    {
        for (int i = 0; i < userList.length; i++)
        {
            if (userList[i].equalsIgnoreCase(selection) == true)
            {
                return i;
            }
        }
        return -1;
    }
    /*
    Purpose: determine if the given string is an integer
    Arguements: String - given string
    Return: boolean - true if it's an integer, false if it is not
    Notes: 
    */
    private boolean isInteger(String str) 
    {
        if (str == null) 
        {
            return false;
        }
        int length = str.length();
        if (length == 0) 
        {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') 
        {
            if (length == 1) 
            {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) 
        {
            char c = str.charAt(i);
            if (c < '0' || c > '9') 
            {
                return false;
            }
        }
        return true;
    }
    /*
    Purpose:
    Arguements:
    Return:
    Notes: Can get it to not return anything and instead make calls from within the function to the other calls.
    */ 
    private String[] createListOfUsers(User[] users)
    {
        String[] listOfUsers = new String [users.length];
        for (int i = 0; i < users.length; i++)
        {
            listOfUsers[i] = users[i].getName();
        }
        return listOfUsers;
    }
            
}   

