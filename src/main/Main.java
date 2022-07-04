package main;
import java.util.*;
public class Main 
{
    
    //All counter customer queue storage
    private static Queue counter1 = new LinkedList(); //item that less than 5
    private static Queue counter2 = new LinkedList(); //item that less than 5
    private static Queue counter3 = new LinkedList(); //item that more than 5
    
    
    public static Queue getCounter1()
    {
        return counter1;
    }
    
    public static Queue getCounter2()
    {
        return counter2;
    }
    
    public static Queue getCounter3()
    {
        return counter3;
    }

  
    public static void main(String[] args) 
    {
        new MainUI(); //Start the main ui
    }
   
}
