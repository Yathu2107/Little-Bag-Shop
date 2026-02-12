/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Yathushan
 */
public class Bag {
    String bId,bName,bType;
    double bPrice;
    
    
    public String GetBagID(){
        return bId;
    }
    public void SetBagID(String bagID){
        this.bId=bagID;
    }
    
    
    
    public String GetBagName(){
        return bName;
    }
    public void SetBagName(String bagName){
        this.bName=bagName;
    }
    
    
    
    public String GetBagType(){
        return bType;
    }
    public void SetBagType(String bagType){
        this.bType=bagType;
    }
    
    
    
    public double GetBagPrice(){
        return bPrice;
    }
    public void SetBagPrice(double bagBagPrice){
        this.bPrice=bagBagPrice;
    }
    
    
}
