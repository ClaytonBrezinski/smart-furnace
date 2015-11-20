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
public class User 
{
    private String name;
    private String[] accessRestrictions;
    private String userPassword;
    public User()
    {
        name = null;
        accessRestrictions = null;
        userPassword = null;
    }
    public User(String toName, String[] toRestrict, String toUserPassword)
    {
        name = toName;
        accessRestrictions = toRestrict;
        userPassword = toUserPassword;
    }
    public String getName()
    {
        return name;
    }
    public String[] getAccessRestrictions()
    {
        return accessRestrictions;
    }
    public boolean isCorrectUserPassword(String submittedPassword)
    {
        if ( userPassword.equals(submittedPassword))
        {
            return true;
        }
        else
        {  
            return false;
        }
    }
}
