/**
 * This is the Vending Machines main class, and holds the main method.
 * 
 * The vending machine holds up to 15 items. 
 * 
 * It can accept any currency and up to 7 denominations of money. 
 * @author Candace Holcombe-Volke
 *
 */
public class VendingMachineSimulator 
{
    /**
     * The main class controls the movement through the machine.
     * It creates instance variables for Product, Inventory, LoadMoney,
     * Menu1, CurrentCredit, UserSelection
     * @param Product
     */
    public static void main( String [] Product )
    {
        Product prod1 = new Product(); 
        Inventory invent = new Inventory();
        LoadMoney load = new LoadMoney(); 
        Menu1 mainMenu = new Menu1(); 
        CurrentCredit currentCredit = new CurrentCredit(); 
        //Read in the products, amount of money loaded into the machine, 
        //and the currency type using loadInvetory()
        load.loadMoney(); //input currency file
        invent.loadInventory();  // input products file
        currentCredit.loadDenoms(); // initialize currency denominations
        mainMenu.displayMenu1(); // displays main menu of commands
        String symbol = load.displayMoneySymbol();  // initialize curr symbol
        UserSelection selection = new UserSelection(); // instance variable
        
        // begin the program loop
        int choice = selection.userSelection(); // user's selection
        while ( choice == 1 || choice == 2 || choice == 3 || choice == 4 ||
            choice == 5 || choice == 9 ) // all valid entries
        {
            switch ( choice )
            {
                case 1: // reprints main menu
                    break;
                    
                case 2: // make a purchase
                    Transact trans = new Transact(); // instance of Transact
                    trans.checkCredit(); // verify enough credit to purchase
                    break;
                    
                case 3: // reprint user's available credit
                    // base value divided by loaded currency value
                   System.out.println("Current Credit: " + symbol + (
                       ( CurrentCredit.totalCredit)
                       /LoadMoney.machineMoney[8].value) );
                    break; 
                    
                case 4: // Show money in machine
                    int i = 6; 
                    System.out.println( "Machine has: " );
                    for ( i = 6; i > -1; i-- )
                    {
                        System.out.println(
                            + load.getQuantity( LoadMoney.machineMoney[i] ) 
                            + " " +
                            load.getDenomination( LoadMoney.machineMoney[i] ));
                    }
                    break;
                    
                case 5: // Display snack options for all items in stock
                    System.out.println( "Snack options: " );
                    int k = 0;
                    System.out.println("Item Number" + "\tItem Name" 
                        + "\tDescription" + "\t\t\t\t" + "Price" );
                    while ( k < 15 )
                    {
                        // verify in stock
                        if ( prod1.getQuantity(Inventory.productList[k]) > 0 )
                        {
                            // prints item ID, name, description, price
                            System.out.println(
                                prod1.getProductID( Inventory.productList[k] ) 
                                + "\t\t" + 
                                prod1.getName( Inventory.productList[k]) 
                                + "\t" + 
                                prod1.getDescription(Inventory.productList[k] )
                                + "\t\t\t" + symbol + 
                                ( prod1.getCost( Inventory.productList[k] )
                                /( LoadMoney.machineMoney[8].value) ) );
                        }
                        k++; // for all items in stock
                    }
                    System.out.println();
                    break;
                    
                case 9: // Cancel and quit
                    int p; 
                    for ( p = 6; p > -1; p--)
                    {
                        // move money from user credit into machine's bank
                        while( CurrentCredit.denomsInserted[p].quantity> 0 )
                        {
                            CurrentCredit.denomsInserted[p].quantity = 
                                (CurrentCredit.denomsInserted[p].quantity - 1); 
                        
                            LoadMoney.machineMoney[p].quantity = 
                                ( LoadMoney.machineMoney[p].quantity +1 );
                        }

                        //Dispense Change
                        int r = 6; 
                        int amountCollected = 0;
                        for (r = 6; r>-1; )
                        {   
                            // while user still has credit left after purchase
                            if( CurrentCredit.totalCredit > 0)
                            {                                              
                                // loop to dispense proper change
                                if( load.getValue(LoadMoney.machineMoney[r]) <= 
                                    CurrentCredit.totalCredit)
                                {
                                    if( amountCollected <= 
                                        prod1.getCost(
                                            Inventory.productList[
                                              selection.selection-1]));
                                    {
                                        // dispense denomination
                                        System.out.println(
                                            "Dispensing one " + 
                                            LoadMoney.machineMoney[r].denomination);
                                        
                                        CurrentCredit.totalCredit = 
                                            (CurrentCredit.totalCredit 
                                            - LoadMoney.machineMoney[r].value);
                                        
                                        amountCollected = (amountCollected 
                                            + LoadMoney.machineMoney[r].value);  
                                        selection.setUserSelection(0);  
                                    }
                                }
                                else
                                {
                                    r--;
                                }  
                            }
                            else
                            {
                                r--; 
                            }
                        }
                    }
                    System.out.println("Have a nice day!");
                    CurrentCredit.totalCredit = 0; 
                    return;
            }
            mainMenu.displayMenu1(); // reprints main menu
            choice = selection.userSelection(); //user selection, cont loop
        }
        
        // if invalid entries
        if (choice != 1 || choice != 2 || choice != 3 || choice != 4 
            ||choice != 9)
        {       
            System.out.println("Error: Invalid Entry. Please make another "
                + "selection.");
            selection.userSelection();
        }
    }
}
