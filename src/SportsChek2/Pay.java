/**
 * This calculates the amount owed
 * Sends this to PrintInvoice to print a invoice
 */
package SportsChek2;

import java.io.IOException;
import java.util.Arrays;
import myMethods.*;


public class Pay {
    
    public static void printTaxes(TaxObject[] taxes, int countTax){
        System.out.println(Arrays.toString(taxes));
        for(int i=0; i<countTax; i++){
            System.out.println("i is "+i);
            System.out.println("Province: "+taxes[i].province);
            System.out.println("HST: "+taxes[i].HST);
            System.out.println("PST: "+taxes[i].PST);
            System.out.println("GST: "+taxes[i].GST);
            System.out.println("Shipping 1"+taxes[i].standardShip);
            System.out.println("Shipping 2: "+taxes[i].expeditedShip);
        }
    }
    
    public static boolean isValidProvince(TaxObject[] taxes, int countTax, String province){
        boolean isValidProvince = true;
        
        for(int i=0; i<countTax && isValidProvince; i++){
            if(province.equalsIgnoreCase(taxes[i].province))
                isValidProvince = false;
        }
        
        return isValidProvince;
    }
    
    public static String getProvince(TaxObject[] taxes, int countTax){
        String province = "";
        
        province = Console.getFullString("Province: ");
            while(isValidProvince(taxes, countTax,province)){
                System.out.println(Colour.RED+"re-enter a valid province \n"+Colour.RESET);
                
                province = Console.getFullString("Province: ");
            }
            
        return province;
    }
    
    public static void printSubtotal(Item[] cart, int countCart){
        double subTotal = 0.0;
        
        System.out.println("Items: ");
        
        for(int i=0; i<countCart; i++){
            System.out.println("in");
            System.out.println("ID: "+cart[i].idNum + " Name: "+cart[i].name + 
                                " Size: "+cart[i].userSize + " Price: $"+cart[i].price);
            
            subTotal += cart[i].price;
            
            System.out.println("Subtotal: "+subTotal);
        }
    }
    
    public static double getSubtotal(Item[] cart, double shipping, int countCart){
        double subTotal = 0.0;
        
        for(int i=0; i<countCart; i++){
            subTotal += cart[i].price;
        }
        
        subTotal += shipping;
        
        return subTotal;
    }
    
    public static void pay(Item[] cart, int countCart) throws IOException
    {
        String payYN = "y";
        String province = "";
        double HST = 0.0, PST = 0.0, GST = 0.0;
        double standardShip = 0.0, expeditedShip = 0.0;
        String ship = "";
        boolean provinceFound  = true;
        
        double subPrice = 0.0, totalPrice = 0.0, tax = 0.0;
        
        TaxObject[] taxes = ReadTaxesAndShipping.Tax();
        int countTax = ReadTaxesAndShipping.countTaxes();
        
        System.out.println("Count Tax "+countTax);
        
        //Prints the current cost of the cart
        //printSubtotal(cart, countCart);
        
        
        System.out.println("Do you want to pay? (y or n)");
        payYN = Console.getWord();
        if(payYN.toLowerCase().startsWith("y")){
            
            province = getProvince(taxes, countTax);            
            
            //System.out.println(Arrays.toString(taxes));
            //printTaxes(taxes, countTax);
            
            for(int i=0; i<taxes.length && provinceFound; i++){
                if(province.equalsIgnoreCase(taxes[i].province)){
                    province = taxes[i].province;
                    if(taxes[i].HST >= 0.0)
                        HST = taxes[i].HST;
                    if(taxes[i].PST >= 0.0)
                        PST = taxes[i].PST;
                    if(taxes[i].GST >= 0.0)
                        GST = taxes[i].GST;
                    
                    standardShip = taxes[i].standardShip;
                    expeditedShip = taxes[i].expeditedShip;
                    provinceFound = false;
                }
            }    
                
                System.out.println("Standard Shipping: "+standardShip);
                System.out.println("Expedited Shipping: "+expeditedShip+"\n");
                
                System.out.println("Type Of Shipping: ");
                ship = Console.getWord();
                while(!(ship.toLowerCase().startsWith("s"))&&
                      !(ship.toLowerCase().startsWith("e"))){
                    System.out.println(Colour.RED+"re-enter a valid from of shipping"+Colour.RESET);
                    
                    System.out.println("Type Of Shipping: ");
                    ship = Console.getWord();
                }
                
                if(ship.toLowerCase().startsWith("s")){
                    subPrice = getSubtotal(cart,standardShip ,countCart);
                    
                    tax = (HST+PST+GST) * subPrice;
                    totalPrice = subPrice + tax;
                    
                    PrintInvoice.printInvoice(province, HST, PST, GST, standardShip,
                                              subPrice, totalPrice, tax, cart, countCart);
                    
                }
                else{
                    subPrice = getSubtotal(cart,expeditedShip ,countCart);
                    
                    tax = (HST+PST+GST) * subPrice;
                    totalPrice = subPrice + tax;
                    
                    PrintInvoice.printInvoice(province, HST, PST, GST, expeditedShip,
                                              subPrice, totalPrice, tax, cart, countCart);
                    
                }
        }
    }

}