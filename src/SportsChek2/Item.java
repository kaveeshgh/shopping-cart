
package SportsChek2;


public class Item 
{

        //fields
        public String idNum;
        public String name;
        public double price;
        public String size1;
        public String size2;
        public String size3;
        public String size4;
        public String size5;
        public String size6;
        public String size7;
        public String size8;
        public String size9;
        public String size10;
        public String userSize;


        //constructor
        //used to construct the record with fields as parameters
        public Item(String i, String n, double p, String s1, String s2, String s3, String s4, String s5, 
                String s6, String s7, String s8, String s9, String s10, String us)
        {
            idNum = i;
            name = n;
            price = p; 
            size1 = s1;
            size2 = s2;
            size3 = s3;
            size4 = s4;
            size5 = s5;
            size6 = s6;
            size7 = s7;
            size8 = s8;
            size9 = s9;
            size10 = s10;
            userSize = us;
            
        }
}