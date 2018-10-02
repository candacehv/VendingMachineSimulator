import java.util.*;


/**
 * This method completes a transaction
 * It checks what item the user wants to buy, and verifies enough
 * available credit. 
 * Then it updates inventory (subtracts 1 from purchased item)
 * Then it updates totalCredit
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class Transact 
{
    // get user selection
    Product prod1 = new Product();
    Scanner input = new Scanner( System.in );
 
    LoadMoney load = new LoadMoney();
    CurrentCredit currentCredit = new CurrentCredit();
    UserSelection select = new UserSelection();
    VendingMachineSimulator vendSim = new VendingMachineSimulator();
    
    // ensure enough credit to purchase
    public void checkCredit()
    {
        System.out.println( "Enter money: " );
        int addMore = 1; 
        while ( addMore == 1) 
        {
            // Until user has entered all their money
            System.out.println("Press 1 To add " + 
                load.getDenomination(LoadMoney.machineMoney[0]) + ".");  
            System.out.println("Press 2 To add " + 
                load.getDenomination(LoadMoney.machineMoney[1]) + ".");
            System.out.println("Press 3 To add " + 
                load.getDenomination(LoadMoney.machineMoney[2]) + ".");
            System.out.println("Press 4 To add " + 
                load.getDenomination(LoadMoney.machineMoney[3]) + ".");
            System.out.println("Press 5 To add " + 
                load.getDenomination(LoadMoney.machineMoney[4]) + ".");
            System.out.println("Press 6 To add " + 
                load.getDenomination(LoadMoney.machineMoney[5]) + ".");
            System.out.println("Press 7 To add " + 
                load.getDenomination(LoadMoney.machineMoney[6]) + ".");
            System.out.println("Press 8 to skip to purchasing item.");
            System.out.println("Press 0 To Cancel Transaction.");
            
            currentCredit.collectMoney(); // accepts money 
            
            addMore = input.nextInt();
        }
        
        if ( addMore == 3 )
        {
            return;
        }
        
        try
        {
            // Check if user has inserted enough money, selection within range
            // and item in stock
            System.out.println( "Enter an Item Number: ");
            int selection = input.nextInt(); 
            if (prod1.getCost( Inventory.productList[selection-1] ) 
                <= CurrentCredit.totalCredit &&
                prod1.getQuantity( Inventory.productList[selection-1] ) > 0
                && ( selection-1 ) >= 0 && ( selection-1) < 16)
            {
                // vend item
                System.out.println( "Vending your " + 
                    prod1.getName( Inventory.productList[selection-1] ) 
                + " now." );
                
                // Update Inventory
                Inventory.productList[selection-1].quantity = 
                   ( prod1.getQuantity(Inventory.productList[selection-1])-1 );
                
                // Update total credit
                CurrentCredit.totalCredit = 
                    ( CurrentCredit.totalCredit - 
                    prod1.getCost(Inventory.productList[selection-1]) );
                
                int p = 6; // loop variable
                for ( p = 6; p > -1; p-- )
                {
                    // move money from user credit into machine's bank
                    while( CurrentCredit.denomsInserted[p].quantity> 0)
                    {
                        CurrentCredit.denomsInserted[p].quantity = 
                            ( CurrentCredit.denomsInserted[p].quantity - 1 ); 
                    
                        LoadMoney.machineMoney[p].quantity = 
                            ( LoadMoney.machineMoney[p].quantity +1 );
                    }

                    //Dispense Change
                    int r = 6; // loop variable
                    int amountCollected = 0; // total collected to 
                    //check against item cost
                    for ( r = 6; r>-1; )
                    {   
                        // while user still has credit left after purchase
                        if( CurrentCredit.totalCredit > 0)
                        {                                              
                            // loop to dispense proper change
                            if( load.getValue(LoadMoney.machineMoney[r] ) <= 
                                CurrentCredit.totalCredit)
                            {
                                if( amountCollected <= 
                                    prod1.getCost(
                                        Inventory.productList[selection-1]) );
                                {
                                    // dispense denomination
                                    System.out.println(
                                        "Dispensing one " + 
                                        LoadMoney.machineMoney[r].denomination);
                                    
                                    CurrentCredit.totalCredit = 
                                        (CurrentCredit.totalCredit 
                                            - LoadMoney.machineMoney[r].value );
                                    
                                    amountCollected = (amountCollected 
                                        + LoadMoney.machineMoney[r].value );   
                                    select.setUserSelection( 0 );  
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
            }
            
            else if (prod1.getCost(Inventory.productList[selection-1]) 
                > CurrentCredit.totalCredit )
            {
                // Not enough money
                System.out.println( "Enter more credit." );
                return;
            }   

            else if( prod1.getQuantity(
                Inventory.productList[selection-1]) <= 0 )
            {
                // Not in stock
                System.out.println( "Sorry, fresh out! Try another item." );
                return;
            }
            
            else if ( (selection-1) < 0 || (selection-1) > 14)
            {
                // Invalid numeric entry
                System.out.println( "Invalid. Try again." );
                return;
            }  
    
        }
        
         // catches user input outside of array range
        catch( ArrayIndexOutOfBoundsException exception )
        {
            System.out.print( "Invalid entry. Select another item." );
            return; 
        }
        
        // catches user input mismatch error
        catch ( InputMismatchException exception )
        {
            System.out.println( "Error. Invalid entry. Please try again." );
            return;
        }
    }
}
