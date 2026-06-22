
package myMethods;


public class NumCalc {
    
    public static int random(int min, int max){
        int num = 0;
        
        if ((max<min) || (max<0) || (min<0))
            num = -1;
        else
            num = (int) (min+Math.random() * (max-min+1));
        
        return num;
    }
    
    public static void random(int min, int max, int[] array){
        for(int i=0; i<array.length; i++){
            array[i] = NumCalc.random(min, max);
        }
    }
    
}
