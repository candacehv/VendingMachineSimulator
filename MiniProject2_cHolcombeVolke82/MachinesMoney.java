/**
 * This class loads the starting money that is loaded into the machine
 * This is not user credit, but the money held by the machine
 * @author Candace Holcombe-Volke
 *
 */

public class MachinesMoney
{
    int value; 
    String denomination;
    int quantity;
    
    public MachinesMoney(String denom, int quant, int val) 
    {
        denomination = denom;
        quantity = quant;
        value = val; 
    }
    
    /*
     * Default constructor, initializes null
     */
    public MachinesMoney() 
    {
        denomination = null;
        quantity = 0;
        value = 0; 
    }

// Get and set methods for denomination, quantity, and value
    public String getDenomination( MachinesMoney elem )
    {
        return elem.denomination;
    }
    
    public int getQuantity( MachinesMoney elem )
    {
        return elem.quantity;
    }
    
    public int getValue(MachinesMoney elem)
    {
        return elem.value;
    }
    
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
    public int getValue()
    {
        return value;
    }
    
    public int getQuantity()
    {
        return quantity;
    }    
    
    /**
     * toString for printing denomination, quantity and value
     */
    public String toString()
    {
        return "" + denomination + quantity + value;
    }
}