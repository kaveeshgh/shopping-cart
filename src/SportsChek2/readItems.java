/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportsChek2;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;


public class readItems 
{
    static int counter = 0;

    public static Item[] itemsArray() throws IOException
    {
        File inFile = new File ("copyOfItems.txt");
        Scanner reader = new Scanner(inFile);
        
        reader.useDelimiter(";|\n");
        Item[] itemsArray = new Item[100];
        
        String idNum = "", name = "", size1 = "", size2 = "", size3 = "", size4 = "", 
                size5 = "", size6 = "", size7 = "", size8 = "", size9 = "", size10 = "", userSize = ""; 
        double price = 0;
        String[] sizes = new String[10];
        
        
        while(reader.hasNext() && counter < itemsArray.length)
        {
            
            idNum = reader.next();
            name = reader.next();
            price = reader.nextDouble();
            size1 = reader.next();
            size2 = reader.next();
            size3 = reader.next();
            size4 = reader.next();
            size5 = reader.next();
            size6 = reader.next();
            size7 = reader.next();
            size8 = reader.next();
            size9 = reader.next();
            size10 = reader.next();
            
            
            itemsArray[counter] = new Item(idNum,name,price,size1,
                    size2, size3, size4, size5, size6, size7, size8, size9, size10, userSize);
            counter++;
        }
        
        /*
        for(int j=0; j<counter; j++)
        {
            System.out.print(itemsArray[j].idNum + " " +
            itemsArray[j].name + " $" + itemsArray[j].price + " ");
                System.out.print(itemsArray[j].size1 + " ");
                System.out.print(itemsArray[j].size2 + " ");
                System.out.print(itemsArray[j].size3 + " ");
                System.out.print(itemsArray[j].size4 + " ");
                System.out.print(itemsArray[j].size5 + " ");
                System.out.print(itemsArray[j].size6 + " ");
                System.out.print(itemsArray[j].size7 + " ");
                System.out.print(itemsArray[j].size8 + " ");
                System.out.print(itemsArray[j].size9 + " ");
                System.out.print(itemsArray[j].size10 + " ");
            System.out.println("");
        }
        */
        
      return itemsArray;
    }
   
    
   public static void main(String[] args) throws IOException{
         Item[] itemsArray = new Item[100];
    
         
         itemsArray = itemsArray();
         //counter=getCount(itemsArray);
    
         System.out.println(counter);
    }


}
