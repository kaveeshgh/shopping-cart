
package SportsChek2;

import myMethods.*;
import java.io.*;


public class EditShoppingCartK 
{   
     
    // fills cart so that the programm can be tested
    public static void fillCart(Item[] shoppingCart)
    {
        String idNum = "17260", name = "Sleeping Bag", s1 = "1", s2 = "2", s3 = "3", s4 = "4", s5 = "5", s6 = "6", 
               s7 = "7", s8 = "8", s9 = "9", s10 = "10", us = "";
        double price = 14.5;

        
        shoppingCart[0] = new Item(idNum,name,price,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        idNum = "12540";
        name = "4-Person Tent";
        price = 20.99;
        us = "N/A";
        
        shoppingCart[1] = new Item(idNum,name,price,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        idNum = "14720";
        name = "Nike Shoes";
        price = 30.99;
        us = "10";
        
        shoppingCart[2] = new Item(idNum,name,price,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        idNum = "13660";
        name = "Fila Shoes";
        price = 29.99;
        us = "5";
        
        shoppingCart[3] = new Item(idNum,name,price,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        idNum = "27140";
        name = "Swimming Trunks";
        price = 15.34;
        us = "7";

        shoppingCart[4] = new Item(idNum,name,price,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
        idNum = "22930";
        name = "Swimming Cap";
        price = 5.55;
        us = "5.5";
 
        idNum = "";
        name = "";
        price = 0;
        us = "";
        
        for(int i = 5; i < shoppingCart.length; i++)
            shoppingCart[i] = new Item(idNum,name,price, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, us);
    }
    
    
    // prints subtotal of the items in the shopping cart so far
    public static void printSubtotal(Item[] shoppingCart, int counter)
    {
        
        double subTotal = 0.0;
        
        for(int i = 0; i < counter; i++)
            subTotal += shoppingCart[i].price;
        
        System.out.println(Colour.BLUE + "\n----------------------------------"
                + "--------------------------------------------" + Colour.RESET);
        System.out.format("%1s%1.2f", "SubTotal: \t\t\t\t\t\t\t      $", + subTotal);
        
    }
    
    
    // prints the id number of the item, 
    // the name, the price, and size they chose
    public static int menu(Item[] shoppingCart, int counter)
    {     

        counter = 0;
        
        System.out.println("\n\t\t\t\tShopping Cart");
        System.out.println("\t\t\t\t    " + Colour.RED + "-----" + Colour.RESET);
        
    
        System.out.println(Colour.BLUE + "ID\t\t\tName\t\t\tPrice\t\t\tSize" + Colour.RESET);
        for(int i = 0; i < shoppingCart.length; )
        {
            if((shoppingCart[i].idNum.equals("")))
                i++;
                
            else
            {
                System.out.format("%n%4s%22s%22s%3.2f%22s", shoppingCart[i].idNum,
                shoppingCart[i].name, "$", shoppingCart[i].price, shoppingCart[i].userSize);
                i++;
                counter++;
            }
        }
        
        printSubtotal(shoppingCart, counter);
           
        System.out.println("\n\n1. Remove Item");
        System.out.println("2. Edit Item");
        System.out.println("3. Go back to shopping");
        System.out.println("4. Go to pay");
        
        return counter;
        
    }
   
    
    // allows user to change the size of an item if they decide to
    // lists all the sizes for that item again to remind user 
    public static void editItem(Item[] shoppingCart, int counter) 
    {
        
        String ID = "", userSize = "";
        boolean found = false;
        
        if(counter > 0)
        {
            ID = myMethods.Console.getFullString("\nEnter ID of the item you want to edit: ");

            while(!found)
            {

                for(int i = 0; i < shoppingCart.length;i++)
                {

                    if(shoppingCart[i].idNum.equals(ID))
                    {
                        System.out.println("Avalible Sizes for " + shoppingCart[i].name + ": ");
                        
                        System.out.format("%7s%7s%7s%7s%7s%7s%7s%7s%7s%7s", shoppingCart[i].size1, 
                        shoppingCart[i].size2, shoppingCart[i].size3, shoppingCart[i].size4, shoppingCart[i].size5, 
                        shoppingCart[i].size6, shoppingCart[i].size7, shoppingCart[i].size8, shoppingCart[i].size9, 
                        shoppingCart[i].size10);
                        
                        userSize = myMethods.Console.getFullString("\n\nEnter new size of item: ");
                       

                        while(!((shoppingCart[i].size1.equals(userSize)) || (shoppingCart[i].size2.equals(userSize)) || 
                                 (shoppingCart[i].size3.equals(userSize)) || (shoppingCart[i].size4.equals(userSize)) ||
                                 (shoppingCart[i].size5.equals(userSize)) || (shoppingCart[i].size6.equals(userSize)) || 
                                 (shoppingCart[i].size7.equals(userSize)) || (shoppingCart[i].size8.equals(userSize)) || 
                                 (shoppingCart[i].size9.equals(userSize)) || (shoppingCart[i].size10.equals(userSize))))
                        {
                                System.out.println(Colour.RED + "Invalid size...re-enter" + Colour.RESET);
                                userSize = myMethods.Console.getFullString("\nEnter new size of item: ");
                        }
                        
                        shoppingCart[i].userSize = userSize;
                        found = true;
                        
                    }
                }


                if(!found)
                {
                    System.out.println(Colour.RED + "Invalid ID number..." + Colour.RESET);
                    ID = myMethods.Console.getFullString("\nEnter ID of the item you want removed: "); 
                }
            }
        }
        
        else
           System.out.println(Colour.RED + "No items currently in Shopping Cart");
        
    }
    
    
    // allows user to remove an item from the shopping cart
    // makes all fields "" or 0 and next time the cart prints,
    // it dosent print that item that was removed 
    public static void removeItem(Item[] shoppingCart, int counter)
    {
        
        String ID = "";
        boolean found = false;
        
        if(counter > 0)
        {
            ID = myMethods.Console.getFullString("\nEnter ID of the item you want removed: ");

            while(!found)
            {

                for(int i = 0; i < shoppingCart.length;i++)
                {
                    if(shoppingCart[i].idNum.equals(ID))
                    {
                        shoppingCart[i].idNum = "";
                        shoppingCart[i].name = "";
                        shoppingCart[i].price = 0; 
                        shoppingCart[i].userSize = "";
                        

                        found = true;
                    }
                }


                if(!found)
                {
                    System.out.println(Colour.RED + "Invalid ID number..." + Colour.RESET);
                    ID = myMethods.Console.getFullString("\nEnter ID of the item you want removed: "); 
                }

            }
        }
        
        else
            System.out.println(Colour.RED + "No items currently in Shopping Cart");
    }
    
    
    // driver of the programm, allows user to 
    // remove an item, edit an item, go back to shoppimg and go to pay menu 
    public static void editShoppingCart(Item[] shoppingCart) throws IOException
    {
   
        int choice = 0, counter = 0;
        String prompt = "\nWhat do you want to do? ";
        
        counter = menu(shoppingCart, counter);
        choice = myMethods.Console.getInt(1, prompt, 5);
 
        
        while(choice != 3 && choice != 4)
        {
            switch(choice)
            {
                case 1: removeItem(shoppingCart, counter);
                        break; 
                        
                case 2: editItem(shoppingCart, counter); break;
            }
            
            counter = menu(shoppingCart, counter);
            choice = myMethods.Console.getInt(1, prompt, 5);
        }
        
        if(choice == 4);
            Pay.pay(shoppingCart, counter);
    }

    
 
    public static void main(String[] args) throws IOException
    {
        Item[] shoppingCart = new Item[20];
   
        
        fillCart(shoppingCart);
        
        editShoppingCart(shoppingCart);
    }
    
}
