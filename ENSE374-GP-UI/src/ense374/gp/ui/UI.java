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
    Scanner input = new Scanner(System.in);
    /*
    Purpose: Default constructor
    Arguements: none
    Returns: none
    Notes: will be expanded on, when a UI is created, it will begin the UI process.
    */
    public UI()
    {
        // call UI from here
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
                
        System.out.println("Welcome to Smart Furnace");
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
                    System.out.println("The user: " + listOfUsers[userInt] + " has been selected");
                    userSelected = true;
                }
                else
                {
                    System.out.println("this is not a valid user-number to select, please try another");
                }
            }
            else
            {
                userInt = inUserList(listOfUsers, userSelection);
                // if userSelected is one within the list of users, notify the user and then exit the loop
                if (userInt != -1)
                {
                    System.out.println("The user: " + listOfUsers[userInt] + " has been selected");
                    userSelected = true;
                }
                else
                {
                    System.out.println("this is not a username to select, please try another");
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
    public boolean loginScreen(String username, String usersPassword )
    {
        String inputPassword = "";
        boolean correctPassword = false;
        
        while (correctPassword == false)
        {
            System.out.println("Press x to return and select another user");
            System.out.println("Username: " + username);
            System.out.print("Password: ");
            inputPassword = input.nextLine();
            
            if (inputPassword == usersPassword)
            {
                correctPassword = true;
            }
            else if (inputPassword == "x" || inputPassword == "X")
            {
                return false;
            }
            else
            {
                System.out.println("incorrect password, please try again" + "\n"); 
            }
        }
        return false; // default statement that will never be hit
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

}
    /*
    Purpose:
    Arguements:
    Return:
    Notes: 
    */
