/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sujalpun
 */
import java.util.LinkedList;

public class UserCollection
{

    private LinkedList<User> users = new LinkedList<>();

    public void registerUser(User user)
    {
        users.add(user);
    }

    public User login(String username, String password)
    {

        for (User u : users)
        {
            if (u.getUsername().equals(username) && u.getPassword().equals(password))
            {
                return u;
            }
        }
        return null;
    }

    public boolean userExists(String username)
    {

        for (User u : users)
        {
            if (u.getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }
}
