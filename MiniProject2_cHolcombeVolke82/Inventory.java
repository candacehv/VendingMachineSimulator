import java.io.*;
import java.util.*;

/**
 * This class loads the product inventory from a file
 * @author Candace Holcombe-Volke
 *
 */
public class Inventory 
{
    Scanner input;
    String filePath;  // file to be read in      
    protected static Product productList[] = new Product[15];

    protected static String symbol; 

    /**
     * Creates a BufferedReader inventoryFile to read in the filePath
     * Then, while Scanner nextLine is not empty or null, splits the line into 
     * elements based on a comma delimiter
     * These elements are assigned to the static product array, productList
     */
    public void loadInventory()
    {
        System.out.println("Enter the Inventory data source file path: ");  
        input = new Scanner ( System.in );
        filePath = input.nextLine(); 
        
        try( BufferedReader inventoryFile = new BufferedReader(
            new FileReader(filePath)) )
        {
           int i = 0;
           Scanner nextLine = new Scanner ( inventoryFile ); 
           while ( !nextLine.equals("") && nextLine != null ) 
           {               
               Product product = new Product(); //instance
               String elements [] = inventoryFile.readLine().split( "\\," );
               
               double price = Double.parseDouble(elements[4]); // convert 
               int numAvailable = Integer.parseInt(elements[5]);// convert 
               product = new Product( elements[0], elements[1], // assign
                   elements[2], elements[3], price, numAvailable );
               productList[i] = product; //initialize array elements
               i++;
           }
        }
    
        
        // catches exceptions
        catch (IOException exception )
        {
            System.out.println( "I/O Error: " + exception );
            exception.printStackTrace();
        }
        // catches exceptions from nextLine 
        catch ( NullPointerException exception2 )
        {
            System.out.println( "Inventory successfully loaded." );
        }
    }
    
   /**
    * This method displays the data entered into the productList
    */
    public void displayInventory()
    {
        int i = 0;
        for (i=0; i<15; i++)
        {
            System.out.println( i );
            System.out.println( productList[i] ); 
        }
    }
}
