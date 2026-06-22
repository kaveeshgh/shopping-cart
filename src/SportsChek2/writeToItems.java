/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsChek2;

import java.util.Scanner;
import java.io.*;


public class writeToItems
{
    
    
    public static void main(String[] args) throws IOException
    {
        
        PrintWriter outputFile = new PrintWriter("items.txt");
        
        String ID = "", name = "";
        double price = 0;
         
        ID = myMethods.Console.getFullString("Enter ID of item: ");
        
        while(!(ID.contains("*")))
        {
            name = myMethods.Console.getFullString("Enter name of item: ");
            price = myMethods.Console.getDouble("Enter item price: ");
            
            outputFile.print(ID + ";" + name + ";" + price + "\n");
            
            ID = myMethods.Console.getFullString("\nEnter ID of item: ");            
        }

        outputFile.close();
       
    }

}
