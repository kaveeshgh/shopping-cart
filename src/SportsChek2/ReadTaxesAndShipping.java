/*
 * read from the "taxes.txt" file \
 * into objects
 */
package SportsChek2;

import java.util.Scanner; 
import java.util.Arrays;
import java.io.*;

public class ReadTaxesAndShipping {
    
    
    
    public static TaxObject[] Tax() throws IOException
    {
        File inFile = new File("taxes.txt");
        Scanner reader = new Scanner(inFile);
        reader.useDelimiter(";|\n");
        
        TaxObject[] taxesArray = new TaxObject[12];
        
        String province = "";
        double HST = 0, PST = 0, GST = 0, standardShip = 0, expeditedShip = 0;
        int counter = 0;
        
        while (reader.hasNext() && counter<taxesArray.length)
        {
            province = reader.next();
            HST = reader.nextDouble();
            PST = reader.nextDouble();
            GST = reader.nextDouble();
            standardShip = reader.nextDouble();
            expeditedShip = reader.nextDouble();
            
            /*
            System.out.println(province);
            System.out.println(HST);
            System.out.println(PST);
            System.out.println(GST);
            System.out.println(standardShip);
            System.out.println(expeditedShip);
            */
            
            
            taxesArray[counter] = new TaxObject(province, HST, PST, GST, standardShip, expeditedShip);
            counter++;
        }
        
      /*   for (int i =0; i<counter; i++)
        {
            System.out.println(taxesArray[i].province + " " + taxesArray[i].HST + " " + 
                    taxesArray[i].PST + " " + taxesArray[i].GST + " " + taxesArray[i].standardShip + " "
                    + taxesArray[i].expeditedShip);
        }
      */
         
           return taxesArray; 
    }
    
    
    public static int countTaxes() throws IOException{
        File inFile = new File("taxes.txt");
        Scanner reader = new Scanner(inFile);
        reader.useDelimiter(";|\n");
        
        TaxObject[] taxesArray = new TaxObject[12];
        
        String province = "";
        double HST = 0, PST = 0, GST = 0, standardShip = 0, expeditedShip = 0;
        int counter = 0;
        
        while (reader.hasNext() && counter<taxesArray.length)
        {
            province = reader.next();
            HST = reader.nextDouble();
            PST = reader.nextDouble();
            GST = reader.nextDouble();
            standardShip = reader.nextDouble();
            expeditedShip = reader.nextDouble();
            
            taxesArray[counter] = new TaxObject(province, HST, PST, GST, standardShip, expeditedShip);
            counter++;
        }
                
        return counter;
    }
    
    
    
}