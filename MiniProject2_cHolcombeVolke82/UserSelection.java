import java.util.InputMismatchException;
import java.util.Scanner;  // Import scanner

/**
 * This method collects the user's choice of what to do next.
 * 
 * @param: Scanner input is the user's console input and is assigned to 
 * int selection
 * @return: int selection returns user's menu choice
 * 
 * @author: Candace Holcombe-Volke
 */


public class UserSelection
{        
    protected int selection;
    
    public int userSelection() 
    {
        Scanner input = new Scanner ( System.in ); 
        try
        {
            selection = input.nextInt();  
            if (selection == 6 || selection == 7 || selection == 8 
                || selection == 0)
            {
                System.out.println("Error: invalid entery. Please make"
                    + " another selection.");
                userSelection();
            }
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Error: Invalid Entry. Please make"
                + " another selection." );
            userSelection(); 
        }
        
        return selection;
    }
    
    public void setUserSelection( int sel) 
    {
        selection = sel; 
    }
    
    public int getUserSelection() 
    {
        return selection; 
    }
}
