/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JOptionPane;

/**
 *
 * @author Yathushan
 */
public class UserAppLogins {
    public void AddNewUser(User newUser){
        String UserData = newUser.GetFirstName()+", "+
                          newUser.GetLastName()+", "+
                          newUser.GetUserType()+", "+
                          newUser.GetUsername()+", "+
                          newUser.GetPassword();
        
        try{
            Writer output;
            output = new BufferedWriter(new FileWriter("C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Users.txt",true));
            output.append(UserData);
            output.append("\n");
            output.close();
            JOptionPane.showMessageDialog(null, "New user has been registered");
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    // Validate user login
    public boolean ValidateLogin(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Users.txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
            String[] userData = line.split(", ");

            
            if (userData.length == 5) {
                String storedUsername = userData[3]; 
                String storedPassword = userData[4]; 

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    reader.close();
                    return true;  
                }
            } else {
                // Handle the case where the data format is incorrect
                JOptionPane.showMessageDialog(null, "Data format error in the file: " + line);
            }
        }
            
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        return false; 
    }
   
    
    public String[][] GetAllUsers() {
        String filePath = "C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Users.txt";
        String[][] userData = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int rowCount = 0;

            // First, count the number of lines (users) in the file
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }
            reader.close();

            // Create a 2D array based on the number of users
            userData = new String[rowCount][5];

            // Re-open the file to read user data
            reader = new BufferedReader(new FileReader(filePath));
            int currentIndex = 0;

            // Now, populate the 2D array with user data
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 5) {
                    userData[currentIndex][0] = data[0]; // First Name
                    userData[currentIndex][1] = data[1]; // Last Name
                    userData[currentIndex][2] = data[2]; // UserType
                    userData[currentIndex][3] = data[3]; // Username
                    userData[currentIndex][4] = data[4]; // Password
                    currentIndex++;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userData; // Return the user data array
    }
}

