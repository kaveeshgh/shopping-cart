
package SportsChek2;


public class TaxObject
{
    
    
            // fields
            public String province;
            public double HST;
            public double PST;
            public double GST;
            public double standardShip;
            public double expeditedShip;
            
            public TaxObject(String pro, double h, double p, double g, double s, double e)
            {
                province = pro;
                HST = h;
                PST = p;
                GST = g;
                standardShip = s;
                expeditedShip = e;
            }
    }
