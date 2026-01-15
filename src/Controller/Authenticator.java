/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.User;
import Model.UserCollection;

import javax.swing.JOptionPane;

/**
 *
 * @author sujalpun
 */
public class Authenticator
{
    private UserCollection users = new UserCollection();

    public Authenticator()
    {
        users.registerUser(new User("admin", "admin123", "admin"));
    }

    public void register(String username, String password)
    {

        if (username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
            return;
        }

        if (users.userExists(username))
        {
            JOptionPane.showMessageDialog(null, "User already exists");
            return;
        }

        users.registerUser(new User(username, password, "user"));
        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

    public User login(String username, String password)
    {

        User user = users.login(username, password);

        if (user == null)
        {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return null;
        }

        JOptionPane.showMessageDialog(null, "Login successful!");
        return user;
    }
}
