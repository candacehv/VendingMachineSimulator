import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class loads the currency file
 * The first 7 elements are available denominations the machine can accept
 * The 8th element holds the currency type
 * The 9th element holds the currency symbol (eg. $)
 * 
 * money is loaded into the static array machineMoney[]
 * @author Candace Holcombe-Volke
 *
 */
public class LoadMoney 
{
    Scanner input; 
    String filePath;   // Input File
    String denomination; 
    int quantity; 
    int value;
    public static LoadMoney machineMoney[] = new LoadMoney[9];
    LoadMoney moneyHolder;
    
    // Construct for currency denomination, loaded quantity, and value modifier
    public LoadMoney(String denom, int quant, int val) 
    {
        denomination = denom;
        quantity = quant;
        value = val; 
    }
    
    /**
     * This class loads in the file with the currency information.
     * 
     */
    public LoadMoney[] loadMoney()
    {
        System.out.println("Enter the currency data source file path: ");   
        input = new Scanner ( System.in );
        
        filePath = input.nextLine();
                
        // buffered reader to read in file
        try( BufferedReader moneyFile = new BufferedReader(
            new FileReader(filePath)))
        {
           int i = 0;
           Scanner nextLine2 = new Scanner (moneyFile); 
           while ( !nextLine2.equals("") || nextLine2 != null) 
           {
               // loads amount and denominations of money that is put into 
               //the machine into array machineMoney
               moneyHolder = new LoadMoney(); 
               String loadedMoney [] = moneyFile.readLine().split("\\:");               
               {
                   moneyHolder = new LoadMoney(loadedMoney[0], 
                   Integer.parseInt(loadedMoney[1]), 
                   Integer.parseInt(loadedMoney[2]) );
                   machineMoney[i] = moneyHolder; // initialize
                   i++;
               }
            }
        }
        
        // catch input exceptions
        catch (IOException exception)
        {
            System.out.println("I/O Error: " + exception );
            exception.printStackTrace();
        }
       
        // catch null pointer from original read in 
        catch (NullPointerException exception)
        {
            System.out.println("Currency Successfully Loaded. " );

        }
        return machineMoney;
    }
    
    
    // LoadMoney default constructor
    public LoadMoney()
    {
        String denomination = "Not initialized."; 
        int quantity = 0; 
        int value = 0;
    }
    
    /**
     * This method displays the contents of machineMoney
     * 
     */
    public void displayMachineMoney(LoadMoney machineMoney[])
    {
        int i = 0;
        for (i=0; i<9; i++)
        {
            System.out.println(i);
            System.out.println(machineMoney[i]); 
        }
    }
    
    /**
     * This method finds and returns the currency symbol from the currency file
     * @param i is an integer and is the location
     * @return
     */
    public String displayMoneySymbol()
    {
        String denoms = getDenomination(machineMoney[8]);
        return denoms;
    }
    
    /**
     * 
     * @param i array location placeholder
     * @return the string denomination of the machine money array location
     */
    public String displayDenom(int i)
    {
        int k = i;
        return getDenomination(machineMoney[k]);
    }
    
    
    
    // GET, SET, AND toString METHODS FOR machineMoney
    
    /**
     * 
     * @param elem LoadMoney element
     * @return denomination of the element
     */
    public String getDenomination( LoadMoney elem )
    {
        return elem.denomination;
    }
    /**
     * 
     * @param arrayLocation LoadMoney element index number
     * @return denomination of the element
     */
    public String getDenomination(int arrayLocation)
    {
        int i = arrayLocation;
        return machineMoney[i].denomination;
    }
    
    /**
     * 
     * @param elem LoadMoney element
     * @return quantity of the LoadMoney element 
     */
    public int getQuantity( LoadMoney elem )
    {
        return elem.quantity;
    }
    
    /**
     * 
     * @param elem LoadMoney element
     * @return value of the LoadMoney element
     */
    public int getValue(LoadMoney elem)
    {
        return elem.value;
    }
    
    /**
     * 
     * @param the denomination of element
     */
    public void setDenomination(String denom)
    {
        this.denomination = denom;
    }
    
    public void setQuantity(int quant)
    {
        this.quantity = quant;
    }
    
    public void setValue(int val)
    {
        this.value = val;
    }
    
    /**
     * 
     * @return value of the element 
     */
    public int getValue()
    {
        return value;
    }
    
    public int getQuantity()
    {
        return quantity;
    }    
    
    public String toString()
    {
        return "" + denomination + quantity + value;
    }
}
