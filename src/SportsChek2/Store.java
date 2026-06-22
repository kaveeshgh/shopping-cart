/*
 * Storefront, can move between shopping cart and store
 * direct shopper to the pay method 
 * calls all other methods
 * Shopper is here
 */
package SportsChek2;

import java.util.Scanner;
import java.io.*;
import myMethods.*;


public class Store 
{
    
    static Scanner input = new Scanner(System.in);
    static int counter = 0;
    static int cartIndex = 0;
    
    
    // displays all store choices
    public static void storeChoice(Item[] itemsArray, Item[] shoppingCart) throws IOException
    {
        int choice = 0;
        Menus.storeMenu();
        choice = myMethods.Console.getInt(1, "\nenter choice: ", 5);
      
            if(choice==1)
                Running(itemsArray, shoppingCart);
            if(choice==2) 
                Soccer(itemsArray, shoppingCart);
            if(choice==3) 
                Skiing(itemsArray, shoppingCart);
            if(choice==4)
                Camping(itemsArray, shoppingCart);
            if(choice==5)
               EditShoppingCart.editShoppingCart(shoppingCart, itemsArray);
               //storeChoice(itemsArray, shoppingCart);
        
    }
    
    
    // displays all sizes avaliable for item
    // allows user to pick one of them
    public static String getSize(Item[] itemsArray, int item)
    {
        String userSize = "";
        if(!itemsArray[item].size1.equals("n/a"))
        {
            System.out.println("Avalible Sizes for " + itemsArray[item].name + ": ");
            System.out.println(itemsArray[item].size1 + " " + itemsArray[item].size2 + " " + itemsArray[item].size3
            + " " + itemsArray[item].size4 + " " + itemsArray[item].size5 + " " + itemsArray[item].size6 
            + " " + itemsArray[item].size7 + " " + itemsArray[item].size8 + " " + itemsArray[item].size9
            + " " + itemsArray[item].size10);
        
        
        
            userSize = myMethods.Console.getFullString("\n\nEnter size of item: ").toLowerCase();
        
            while(userSize.equals("n/a"))
            {
                System.out.println("size is not apllicable to product, sorry for the inconvenience");
                userSize = myMethods.Console.getFullString("re-enter size of item: ");
            }
                    

            while(!((itemsArray[item].size1.toLowerCase().equals(userSize)) || (itemsArray[item].size2.toLowerCase().equals(userSize)) || 
                (itemsArray[item].size3.toLowerCase().equals(userSize)) || (itemsArray[item].size4.toLowerCase().equals(userSize)) ||
                (itemsArray[item].size5.toLowerCase().equals(userSize)) || (itemsArray[item].size6.toLowerCase().equals(userSize)) || 
                (itemsArray[item].size7.toLowerCase().equals(userSize)) || (itemsArray[item].size8.toLowerCase().equals(userSize)) || 
                (itemsArray[item].size9.toLowerCase().equals(userSize)) || (itemsArray[item].size10.toLowerCase().equals(userSize))))
            {
                        
                System.out.println(Colour.RED + "Invalid size...re-enter" + Colour.RESET);
                userSize = myMethods.Console.getFullString("\nEnter size of item: ");
            }
        
            itemsArray[item].userSize = userSize;
        }
        else userSize = "n/a";
        return userSize;
    }
    
    
    // allows user to add to cart object
    public static void addToCart(Item[] itemsArray,Item[] shoppingCart, String size, int item) throws IOException
    {
        String purchase = "";
        purchase = myMethods.Console.getFullString("Add to Cart? (y/n)");
        if(purchase.startsWith("y"))
        {
            shoppingCart[cartIndex] = new Item(itemsArray[item].idNum, itemsArray[item].name, 
                    itemsArray[item].price, itemsArray[item].size1, itemsArray[item].size2, 
                    itemsArray[item].size3, itemsArray[item].size4, itemsArray[item].size5,
                    itemsArray[item].size6, itemsArray[item].size7,itemsArray[item].size8, 
                    itemsArray[item].size9, itemsArray[item].size10,itemsArray[item].userSize);
            cartIndex++;
            
        }
        
        storeChoice(itemsArray,shoppingCart);
    }
    
    public static void getItem (Item[] itemsArray, Item[] shoppingCart, String userSize, String user, int record) throws IOException
    {
       if(!user.equals("1"))
        {
            for(int i =0; i< readItems.counter;i++)
            {
                if(itemsArray[i].idNum.equals(user))
                {
                    record = i;
                    
                    System.out.println(itemsArray[record].name + "\t$" + itemsArray[record].price);
                    userSize = getSize(itemsArray,record);
                    addToCart(itemsArray, shoppingCart, userSize, record);
                }
            }
        }
        else if(user.equals("1"))
            storeChoice(itemsArray, shoppingCart); 
    }
    
    public static boolean findIdNum (Item[] itemsArray, String user)
    {
        boolean found = false;
        
        if(!user.equals("1"))
        {
            for(int i =0; i< readItems.counter ;i++)
            {
              if(itemsArray[i].idNum.equals(user))
                  found = true;
            } 
        }
        else if(user.equals("1"))
            found = true;
        return found;
    }
    
    //==============================================================================================
    public static void Running(Item[] itemsArray, Item[] shoppingCart) throws IOException
    {
        String user = "";
        String userSize = "";
        int record = 0;
        boolean found;
        counter = Menus.RunningMenu(itemsArray);
        user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
        found = findIdNum(itemsArray, user);
        while(!found)
        {
          System.out.println(Colour.RED + "Invalid ID Number...re-enter" + Colour.RESET); 
          user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
          found = findIdNum(itemsArray, user);
        }
        getItem(itemsArray, shoppingCart, userSize, user, record);
    }
    
    public static void Soccer(Item[] itemsArray,Item[] shoppingCart) throws IOException
    {
        String user = "";
        String userSize = "";
        int record = 0;
        boolean found;
        counter = Menus.SoccerMenu(itemsArray);
        user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
        found = findIdNum(itemsArray, user);
        while(!found)
        {
          System.out.println(Colour.RED + "Invalid ID Number...re-enter" + Colour.RESET); 
          user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
          found = findIdNum(itemsArray, user); 
        }
        getItem(itemsArray, shoppingCart, userSize, user, record);
    }

    public static void Skiing(Item[] itemsArray, Item[] shoppingCart) throws IOException
    {
        String user = "";
        String userSize = "";
        int record = 0;
        boolean found;
        counter = Menus.SkiingMenu(itemsArray);
        user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
        found = findIdNum(itemsArray, user);
        while(!found)
        {
          System.out.println(Colour.RED + "Invalid ID Number...re-enter" + Colour.RESET); 
          user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
          found = findIdNum(itemsArray, user); 
        }
        getItem(itemsArray, shoppingCart, userSize, user, record);
    }

    public static void Camping(Item[] itemsArray, Item[] shoppingCart) throws IOException
    {
        String user = "";
        String userSize = "";
        int record = 0;
        boolean found;
        counter = Menus.CampingMenu(itemsArray);
        user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ".toLowerCase());
        found = findIdNum(itemsArray, user);
        while(!found)
        {
            System.out.println(Colour.RED + "Invalid ID Number...re-enter" + Colour.RESET); 
            user = myMethods.Console.getFullString("\nenter ID Num of the product you'd like to purchase (or 1 to go back): ").toLowerCase();
            found = findIdNum(itemsArray, user); 
        }
        getItem(itemsArray, shoppingCart, userSize, user, record);
    }
    //==============================================================================================
    
    
    // creates new items in shopping cart object
    // fills shopping cart with empty so its not null
    public static Item[] sendShoppingCart()
    {
        Item[] shoppingCart = new Item[20];
        
        String idNum = "", name = "", s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", 
               s7 = "", s8 = "", s9 = "", s10 = "", us = "";
        double price = 0;
        
        for(int i = 0; i < shoppingCart.length; i++)
            shoppingCart[i] = new Item(idNum,name,price, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        
        
        return shoppingCart;
    }

    
    public static void main(String[] args) throws IOException
    {
        Item[] itemsArray = readItems.itemsArray();
        Item[] shoppingCart = sendShoppingCart();
       
        storeChoice(itemsArray,shoppingCart);
       
    }
    
}