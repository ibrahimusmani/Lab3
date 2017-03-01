
package lab3;

import java.util.Arrays;
import java.util.Scanner;


public class Restaurant {
    // Some global variables for the class
    int xl =1, large=3, med= 8, small=4, flag=0;
    
    // My main function for this class
    public void Main() {
        Scanner scanf = new Scanner(System.in);
        String res;
        String[] order = new String[20];
        Arrays.fill(order, "");
        int time;
        //Taking reservation details
        System.out.println ("Welcome to the Restaurant");
        System.out.println ("What table would you like to reserve? (xl, large, med, small)");
        res= scanf.nextLine();
        System.out.println("For how many hours would you like to reserve the table?");
        time= scanf.nextInt();
        //Reserving table
        System.out.println(reservation(res,time)+"\n");
        int i=0;
        //Getting order details
        System.out.println("What would you like to eat sir? (press enter to add new item and type done to complete order!)");
        while(true)
        {
            
            order[i] =scanf.nextLine();
            if ("done".equals(order[i]))
            {
                order[i]="";
                break;
            }
            i++;
        }
        //Preparing order
        System.out.println(prepareOrder (order,res,time)+"\n");
        //Serving order
        System.out.println(serve(order,i,res) +"\n");
        
        
    }
    //Funtion to reserve a table
     public String reservation(String table, int time){
        switch(table){
            case "xl": case "XL": case "Xl":
                if (xl==0)
                    return "Sorry sir Extra-Large table is not available";
                else{
                    xl--;
                    return "Extra large table for 12 booked for you for " + time +" hours sir";
                }
                //break;
            case "Large": case "large":
                if (large==0)
                    return "Sorry sir Large table is not available";
                else
                {
                    large--;
                    if (time<=2)
                        return "Large table for 6 booked for you for "+time+" hours sir";
                    else
                        return "Large table for 6 booked for you for "+2+" hours sir because we have too many guests today!";
                }
                //break;
            case "Med": case "med": case "Medium": case "medium":
                if (med==0)
                    return "Sorry sir Medium table is not available";
                else
                {
                    med--;
                    if (time<=2)
                        return "Medium table for 4 booked for you for "+time+" hours sir";
                    else
                        return "Medium table for 4 booked for you for "+2+" hours sir because we have too many guests today!";
                }    
                //break;
            case "Small": case "small":
                if (small==0)
                    return "Sorry sir Small table is not available";
                else
                {
                    small--;
                    if (time<=2)
                        return "Small table for 2 booked for you for "+time+" hours sir";
                    else
                        return "Small table for 2 booked for you for "+2+" hours sir because we have too many guests today!";
                }    
                //break;
            default: 
                return "Invalid choice";
        }
              
    }
   
    //Function to prepare order
    public String prepareOrder(String s[], String res, int time){
        int wait;
        int x=0;
        for (int i=0;i<20;i++)
        {
            if (s[i].equals("")) {
            } else {
                x++;
            }
        }
        wait= x*30;
        if(null==res)
            return "Error";
        else switch (res) {
            case "xl":
            case "XL":
            case "Xl":
                if (wait<=time*60)
                    return "You'll have to wait for "+wait+" minutes";
                else
                {
                    flag =1;
                    return "We cannot prepare order because of shortage of time";
                }
            case "Large":
            case "large":
            case "Med":
            case "med":
            case "medium":
            case "Medium":
            case "Small":
            case "small":
                if (time<=2)
                {
                    if (wait<=time*60)
                        return "You'll have to wait for "+wait+" minutes";
                    else{
                        flag =1;
                        return "We cannot prepare order because of shortage of time";                
                    }
                }    
                else
                {
                    if (wait<=2*60)
                        return "You'll have to wait for "+wait+" minutes";
                    else
                    {
                        flag=1;
                        return "We cannot prepare order because of shortage of time";
                    }
                }
            default:
                return "Error";
        }
    
    }
    
    //Function to serve the prepared order
    public String serve(String s[], int i,String res){
        //String abc="";
        StringBuilder abc = new StringBuilder();
        if(null==res)
            return "Error";
        else switch (res) {
            case "xl":
            case "XL":
            case "Xl":
            case "Large":
            case "large":
            case "Med":
            case "med":
            case "medium":
            case "Medium":
            case "Small":
            case "small":
                if (flag==0)
                {
                    for(int x=1;x<i;x++){
                        if (x==i-1)
                            abc=abc.append(s[x]);
                        else
                            abc=abc.append(s[x]).append(", ");
                    }
                    return "serving " + abc.toString();
                }
                else
                    return "Error";
        
        default:
            return "Error";
    }
}
}
