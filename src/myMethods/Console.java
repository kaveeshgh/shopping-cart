/*
 * Get varius methods from other programs
 */
package myMethods;

import java.util.Scanner;



public class Console {
    
    //intergers
    
    public static int getInt(){
        Scanner input = new Scanner(System.in);
        int num = 0;
        
        while (!input.hasNextInt()){
            System.out.print("Not a valid interger...re-enter: ");
            input.nextLine();
        }
        
        num = input.nextInt();
        
        return num;
    }
    
    public static int getInt(String prompt){
        System.out.print(prompt);
        return getInt();
    }
    
    public static int getInt(String prompt, int max) {
        int num = 0;

        num = getInt(prompt);

        while (num > max) {
            System.out.print("Enter a interger <= " + max);
            num = getInt(prompt);
        }

        return num;
    }
    
    public static int getInt(int min, String prompt) {
        int num = 0;

        num = getInt(prompt);

        while (num < min) {
            System.out.println("Enter a interger >= " + min);
            num = getInt(prompt);
        }

        return num;
    }
    
    public static int getInt(int min, String prompt, int max) {
        int num = 0;

        num = getInt(prompt);

        while (num < min || num > max) {
            System.out.println("Enter a interger between " + min + " and " + max + ": ");
            num = getInt(prompt);
        }

        return num;
    }
    
    //Doubles
    
    public static double getDouble(){
        Scanner input = new Scanner(System.in);
        double num = 0;
        
        while (!input.hasNextDouble()){
            System.out.print("Not a valid double...re-enter: ");
            input.nextLine();
        }
        
        num = input.nextDouble();
        
        return num;
    }
    
    public static double getDouble(String prompt) {
        System.out.print(prompt);
        return getDouble();
    }
    
    public static double getDouble(String prompt, double max) {
        double num = 0;

        num = getDouble(prompt);

        while (num > max) {
            System.out.println("Enter a double <= " + max);
            num = getDouble(prompt);
        }

        return num;
    }
    
    public static double getDouble(double min, String prompt) {
        double num = 0;

        num = getDouble(prompt);

        while (num < min) {
            System.out.println("Enter a double >= " + min);
            num = getDouble(prompt);
        }

        return num;
    }
    
    public static double getDouble(double min, String prompt, double max) {
        double num = 0;

        num = getDouble(prompt);

        while (num < min || num > max) {
            System.out.println("Enter a double between " + min + " and " + max + ": ");
            num = getDouble(prompt);
        }

        return num;
    }
    
    //Strings
    
    public static boolean checkAlpha(String word){
        int unicode = 0;
        boolean alpha = true;
        
        word = word.toLowerCase();
        
        for (int i=0;i<word.length()&&alpha;i++){
            unicode = (int)word.charAt(i);
            if (!(unicode>=97&&unicode<=122)) alpha = false;
        }
        return alpha;
    }
    
    public static String getWord(){
        Scanner input = new Scanner(System.in);
        String word = "";
        
        word = input.next().trim();
        input.nextLine();
        while(!checkAlpha(word)){
            System.out.println("invalid characters...re-enter:");
            word = input.next().trim();
            input.nextLine();
        }
        return word;
    }
    
    public static String getFullString(String propmt){
        Scanner input = new Scanner(System.in);
        String line = "";
        
        System.out.print(propmt);
        line = input.nextLine().trim();
        
        while(line.isEmpty()){
            System.out.println("missing input . . . ");
            
            System.out.print(propmt);
            line = input.nextLine().trim();
        }
        return line;
    }
    
}
