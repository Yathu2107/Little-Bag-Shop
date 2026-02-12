/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Yathushan
 */
public class User {
    String fName, lName, uName, pwd, uType;
    
    public String GetFirstName(){
        return fName;
    }
    public void SetFirstName(String FirstName){
        this.fName=FirstName;
    }
    
    
    public String GetLastName(){
        return lName;
    }
    public void SetLastName(String LastName){
        this.lName=LastName;
    }
    
    
    public String GetUsername(){
        return uName;
    }
    public void SetUsername(String Username){
        this.uName=Username;
    }
    
    
    public String GetPassword(){
        return pwd;
    }
    public void SetPassword(String Password){
        this.pwd=Password;
    }
    
    
    public String GetUserType(){
        return uType;
    }
    public void SetUserType(String UserType){
        this.uType=UserType;
    }
    
}
