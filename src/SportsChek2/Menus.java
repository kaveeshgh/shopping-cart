/*
 * Shopping menus
 */
package SportsChek2;

import java.io.*;
import myMethods.*;


public class Menus 
{
    
    public static void storeMenu()
    {
        System.out.println(Colour.BLUE + "--------------------------------------" + Colour.RESET);
        System.out.println("WELCOME TO SPORTCHEK");
        System.out.println("1. Running");
        System.out.println("2. Soccer");
        System.out.println("3. Skiing");
        System.out.println("4. Camping");
        System.out.println("5. View Shopping Cart");
    }
    
    public static int RunningMenu(Item[] itemsArray)
    {
        int num = 1;
        
        System.out.println(Colour.CYAN + "\n\nRUNNING" + Colour.RESET);
        System.out.println(Colour.BLUE + "--------------------------------------" + Colour.RESET);
        for (int i =0; i<readItems.counter && itemsArray[i].idNum.startsWith("1");i++)
        System.out.println(itemsArray[i].idNum + "\t" + itemsArray[i].name + "\t" + itemsArray[i].price );
        System.out.println(num + ". Back");
        //System.out.println(num);
        return num;
    }
    
    public static int SoccerMenu(Item[] itemsArray)
    {
        int num = 1;
        
        System.out.println(Colour.YELLOW + "\n\nSOCCER" + Colour.RESET);
        System.out.println(Colour.BLUE + "--------------------------------------" + Colour.RESET);
        for (int i =0; i<readItems.counter;)
        {
            if(itemsArray[i].idNum.startsWith("2"))
            {
                System.out.println(itemsArray[i].idNum + "\t" + itemsArray[i].name + "\t" + itemsArray[i].price);
                i++;
            }
            else
                i++;
        }
        System.out.println(num + ". Back");
        
        return num;
    }
    
    public static int SkiingMenu(Item[] itemsArray)
    {
        int num = 1;
        
        System.out.println(Colour.GREEN + "\n\nSKIING" + Colour.RESET);
        System.out.println(Colour.BLUE + "--------------------------------------" + Colour.RESET);
        for (int i =0; i<readItems.counter;)
        {
            if(itemsArray[i].idNum.startsWith("3"))
            {
                System.out.println(itemsArray[i].idNum + "\t" + itemsArray[i].name + "\t" + itemsArray[i].price);
                i++;
            }
            else
                i++;
        }
        System.out.println(num + ". Back");
        
        return num;
    }
    
    public static int CampingMenu(Item[] itemsArray)
    {
        int num = 1;
        
        System.out.println(Colour.PURPLE + "\n\nCAMPING" + Colour.RESET);
        System.out.println(Colour.BLUE + "--------------------------------------" + Colour.RESET);
        for (int i =0; i<readItems.counter;)
        {
            if(itemsArray[i].idNum.startsWith("4"))
            {
                System.out.println(itemsArray[i].idNum + "\t " + itemsArray[i].name + "\t" + itemsArray[i].price);
                i++;
            }
            else
                i++;
        }
        System.out.println(num + ". Back");
        
        return num;
    }
    
    public static void main(String[] args) throws IOException {
        Item[] itemsArray;
        itemsArray = readItems.itemsArray();
    }
            
}