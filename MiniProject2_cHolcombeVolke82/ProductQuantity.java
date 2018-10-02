/**
 * This class holds ProductQuantity constructors
 * @author Candace Holcombe-Volke
 *
 */
public class ProductQuantity 
{
    private int productQuantity;
    
    public ProductQuantity( int prodQuant)
    {
        this.productQuantity = prodQuant; 
    }
    
    public ProductQuantity()
    {
        this.productQuantity = 0; 
    }
    
    public void setProductQuantity(int prodQuant)
    {
        productQuantity = prodQuant;
    }
    
    public int getProductQuantity()
    {
        return productQuantity; 
    }
    
    public String toString()
    {
        return "Number available: " + productQuantity + "\n"; 
    }
}
