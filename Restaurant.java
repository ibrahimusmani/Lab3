
package lab3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Restaurant {
    // Some global variables for the class
    ArrayList names = new ArrayList();
    ArrayList times = new ArrayList();
    ArrayList dates = new ArrayList();
    int xl =1, large=3, med= 8, small=4, flag=0, visit;
    
    // My main function for this class
    public void Main() {
        Scanner scanf = new Scanner(System.in);
        String res;
        String[] order = new String[20];
        Arrays.fill(order, "");
        int time;
        //Taking reservation details
        System.out.println ("Welcome to the Restaurant");
        System.out.println("Your good name sir?");
        names.add(scanf.nextLine());
        System.out.println ("What table would you like to reserve? (xl, large, med, small)");
        res= scanf.nextLine();
        //I will not put any constraints over date because it will create multiple conditions
        //This is a very trivial detail
        System.out.println("At what date would you like to visit the Restaurant?");
        dates.add(scanf.nextInt());
        System.out.println("At what time would you like to visit the Restaurant? (In 24-hours format)");
        visit = scanf.nextInt();
        if (visit<11||visit>22)
        {
            flag = 1;
            System.out.println("Restaurant is closed at this time");
        }
        else
        {
            flag = 0;
            times.add(visit);
        }
        System.out.println("For how many hours would you like to reserve the table?");
        time= scanf.nextInt();
        if (visit+time>22)
        {
            flag = 1;
            System.out.println("Time span too long, we have to close restaurant");
            
        }
        //Reserving table
        System.out.println(reservation(res,time)+"\n");
        int i=0;
        //Getting order details
        if(flag==0){
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
        }
        //Preparing order
        System.out.println(prepareOrder (order,res,time)+"\n");
        //Serving order
        System.out.println(serve(order,i,res) +"\n");
        System.out.println(schedule());
        flag = 0;
        
        
    }
    //Funtion to reserve a table
     public String reservation(String table, int time){
         if (flag==0){
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
         else
             return "Error";
              
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
        if(null==res||flag==1)
            return "Error";
        else switch (res) {
            case "xl":
            case "XL":
            case "Xl":
                if (wait<=time*60)
                {
                    return "You'll have to wait for "+wait+" minutes";
                }
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
                    return "Serving " + abc.toString();
                }
                else
                    return "Error";
        
        default:
            return "Error";
    }
}
    public String schedule()
    {
        String output="";
        int size= names.size();
        for (int i=0;i<size;i++)
        {            
            output+= names.get(i).toString() + "\t\t" + dates.get(i).toString() + "th\t" + times.get(i).toString() + "hrs\n";
        }
        if (flag == 1)
            return "Error";
        else{
            System.out.println("Monthly Report");
            System.out.println("Name\t\tDate\tTime");
            return output;}
    }
}
