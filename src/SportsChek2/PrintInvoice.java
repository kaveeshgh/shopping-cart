/*
 * Creates a file called invoice that holds:
 *  - Name of store
 *  - Items
 *   > Name
 *   > Pice
 *   > ID Number
 *  - Subtotal
 *  - Taxes
 *   > Either HST
 *   > Or any combination of PST & GST
 *  - Provence to send to
 *  - Shipping Costs & Number of Days
 *  - Total
 *  - Make it look nice
 *  - 25
 * 
 */
package SportsChek2;

import java.io.*;

public class PrintInvoice {
    
    public static void printInvoice(String province, double HST, double PST, double GST,
                                    double shipping, double subPrice, double totalPrice,
                                    double tax, Item[] cart, int count) throws IOException{
        PrintWriter outputFile = new PrintWriter("invoice.txt");
        
        outputFile.println("-----------------------------------------------");
        outputFile.println("|                 Sport Check                 |");
        outputFile.println("|                                             |");
        
        
       
        
        for(int i=0; i<count; i++){
            outputFile.format("%1s%37s%5s","| ID: ",cart[i].idNum,"|\n");
            outputFile.format("%1s%32s%5s","|  - Name: ",cart[i].name,"|\n");
            outputFile.format("%1s%32s%5s","|  - Size: ",cart[i].userSize,"|\n");
            outputFile.format("%1s%33s%5s","| Price: $",cart[i].price,"|\n");
            outputFile.println("|                                             |");
        }
        
        outputFile.println("|                                             |");
        outputFile.format("%1s%31s%5s", "| Province: ",province,"|\n"); 
         if(HST != 0.0)
            outputFile.format("%1s%35.2f%5s","| HST: $", HST,"|\n");
        else{
            if(PST != 0.0 && GST != 0.0){
                outputFile.format("%1s%35.2f%5s","| PST: $", PST,"|\n");
                outputFile.format("%1s%35.2f%5s","| GST: $", GST,"|\n");
            }
            else if(PST != 0.0)
                outputFile.format("%1s%35.2f%5s","| PST: $", PST,"|\n");
            
            else
                outputFile.format("%1s%35.2f%5s","| GST: $", GST,"|\n");
        }
         
        outputFile.format("%1s%30.2f%5s","| Shipping: $", shipping,"|\n");
        outputFile.format("%1s%29.2f%5s","| Sub Price: $", subPrice,"|\n");
        outputFile.format("%1s%29.2f%5s","| Tax Price: $", tax,"|\n");
        outputFile.format("%1s%27.2f%5s","| Total Price: $", totalPrice,"|\n");
        outputFile.println("-----------------------------------------------");
        
        
        outputFile.close();
        
        System.out.println("Invoice has been printed...");
        System.out.println("Thanks for Shopping at SportsChek2!");
    }
      
    
    /*
    public static void main(String[] args) throws IOException{
        String province = "Ontario";
        double HTS = 0.13, PST = 0.0, GST = 0.0;
        double shipping = 3.68;
        double subPrice = 18.23, totalPrice = 19.54, tax = 0.80;
        
        printInvoice(province, HTS, PST, GST, shipping, subPrice, totalPrice, tax);
    }
    */
}