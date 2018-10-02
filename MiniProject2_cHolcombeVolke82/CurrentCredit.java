import java.util.Scanner;
/**
 * This method manages the user's available credit by using an array
 * of quantity of denominations inserted multiplied by the machineMoney
 * value multiplier
 * 
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class CurrentCredit 
{
    //denomsInserted holds the number of each denomination inserted
    // current currency file for US money is set up such that:
    // [0] holds nickels, ... [6] holds 20 dollar bills
    
    // main array that holds user credit
    protected static CurrentCredit denomsInserted[] = new CurrentCredit[9];
    // variable that sums the total credit (quantity * value)
    protected static double totalCredit = 0; 
    
    //Instance variables
    Inventory inv = new Inventory(); 
    MachinesMoney macMo = new MachinesMoney();
    LoadMoney load = new LoadMoney();
    String denomination; // currency denomination 
    int quantity; // number inserted by user
    int value; // multiplier
    int arrayLocation; // element number of denomsInserted array
    
    
    /**
     * 
     * @param quant is the quantity of the denomination inserted
     */
    public CurrentCredit( int quant )
    {
        int newQuantity = quant;
    }
    
    
    /**
     * Constructor with quantity and array location
     * @param quant is the quantity of the denomination inserted
     * @param element is the location in the array (which denomination)
     */
    public CurrentCredit( int quant, int element )
    {
        int newQuantity = quant;
        arrayLocation = element; 
    }
    
    /**
     * This method adds the newly inserted quantity to the current quantity
     * for each inserted denomination.
     * 
     * Then it sums the credit and updates totalCredit
     * @param quant newly inserted quantity of denomination
     * @param element which array element (denomination)
     */
    public void addCurrentCredit( int quant, int element )
    {
        int newQuantity = quant;
        arrayLocation = element; 
        CurrentCredit.denomsInserted[arrayLocation].quantity =
            ( CurrentCredit.denomsInserted[arrayLocation].quantity 
                + newQuantity );
        
        CurrentCredit.totalCredit = CurrentCredit.totalCredit +
           (((CurrentCredit.denomsInserted[arrayLocation]).quantity)
           *(LoadMoney.machineMoney[arrayLocation].value));
    }
        
    /**
     * This method initializes array with quantity of 0
     */
    public void loadDenoms()
    {
        int i = 0;
        for ( i = 0; i < 9; i++ )
        {
            CurrentCredit.denomsInserted[i] = new CurrentCredit(0); 
        }
    }
    
    /**
     * Default constructor, creates null, no params
     */
    public CurrentCredit()
    {
        quantity = 0;
        arrayLocation = 0; 
    }

    int addMore = 1; // while == 1, continues add money loop

    int quantEntered = 0; 
    
    /**
     * Accepts the money inserted and adds to credit
     * @param int quant entered is the number of each denomination 
     * inserted into the machine
     */
    public void collectMoney()
    {
        LoadMoney load = new LoadMoney();
        Scanner input = new Scanner ( System.in );
        
        int currencyPaid = input.nextInt(); 
        
        if ( currencyPaid == 0 )
        {
            System.out.println( "Press 3 to confirm you want to return to the"
                + " Main Menu." );
            return; 
        }

        if ( currencyPaid > 0 && currencyPaid < 8 )
        {
            System.out.print("Enter Quantity ");
            quantEntered = input.nextInt();        
            System.out.println("Money accepted.");
            
            addCurrentCredit( quantEntered, (currencyPaid-1) );
          System.out.println( "Press 1 to add more money, 2"
          + " to make a purchase, 3 to return to main menu." );
        }

        if (currencyPaid == 8)
        {
             System.out.println( "Press 2 to continue." );
        }
        
        if (currencyPaid == 0)
        {
            return;
        }
    } // end while loop to add more money
                    
    
    /**
     * Get method for denomsInserted quantity
     * @param arrLocation denomsInserted array element
     * @return quantity of that denomination inserted by user
     * @param int i is used as a placeholder for array element number
     */
    public double getQuantity( int arrLocation )
    {
        int i = arrayLocation;
        return CurrentCredit.denomsInserted[i].quantity;
    }
    
    /**
     * 
     * @param element array location
     * @return the quantity of denomination of that array element
     */
    public double getQuantity( CurrentCredit element )
    {
        return element.quantity;
    }
    
    /**
     * 
     * @param arrLocation is array element item
     * @param quantChange is the change in the quantity of denom, + or -
     * @return CurrentCredit type number of denominations of user input
     */
    public double setQuantity( int arrLocation, int quantChange )
    {
        int i = arrayLocation;
        denomsInserted[i].quantity = ( denomsInserted[i].quantity 
            + quantChange ); 
        return CurrentCredit.denomsInserted[i].quantity;
    }
    /**
     * 
     * @param arrayLocation array element
     * @return the string denomination for that element location
     */
    public String getDenomination( int arrayLocation )
    {
        int i = arrayLocation;
        return CurrentCredit.denomsInserted[i].denomination; 
    }
    
    // toString for printing
    public String toString()
    {
        return "Current Credit: " + CurrentCredit.totalCredit; 
    }
} // end CurrentCredit class
