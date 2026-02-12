/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.List; // Correct List import
import java.util.ArrayList;
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
public class BagDetails {
    
    public void AddNewBag(Bag newBag){
        String BagData = newBag.GetBagID()+", "+
                          newBag.GetBagName()+", "+
                          newBag.GetBagType()+", "+
                          newBag.GetBagPrice();
        
        try{
            Writer output;
            output = new BufferedWriter(new FileWriter("C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Bags.txt", true));
            output.append(BagData);
            output.append("\n");
            output.close();
            JOptionPane.showMessageDialog(null, "New Bag has been Added");
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String[][] GetAllbags() {
        String filePath = "C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Bags.txt";
        String[][] bagData = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int rowCount = 0;

            // First, count the number of lines (bags) in the file
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }
            reader.close();

            // Create a 2D array based on the number of bags
            bagData = new String[rowCount][4];  // 4 columns (BagID, BagName, BagType, BagPrice)

            // Re-open the file to read bag data
            reader = new BufferedReader(new FileReader(filePath));
            int currentIndex = 0;

            // Populate the 2D array with bag data
            while ((line = reader.readLine()) != null) {
                String[] bags = line.split(", ");
                bagData[currentIndex][0] = bags[0]; // BagID
                bagData[currentIndex][1] = bags[1]; // BagName
                bagData[currentIndex][2] = bags[2]; // BagType
                bagData[currentIndex][3] = bags[3]; // BagPrice
                currentIndex++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bagData; // Return the bag data array
    }
    
    // Method to search bags by bag type
    public String[][] SearchBagsByBagType(String bagType) {
        String filePath = "C:\\Users\\Yathushan\\Documents\\NetBeansProjects\\Database\\appData\\Bags.txt";
        List<String[]> filteredBags = new ArrayList<>();

    try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Read the file line by line
        while ((line = reader.readLine()) != null) {
            String[] bag = line.split(", ");

            // Ensure that bagType comparison is case-insensitive and trimmed
            if (bag[2].trim().equalsIgnoreCase(bagType.trim())) {
                filteredBags.add(bag); // Add the matching bag to the list
            }
        }

        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Convert List to 2D String array
    return filteredBags.toArray(new String[0][4]); // Assuming 4 columns: BagID, BagName, BagType, BagPrice
    }
}
