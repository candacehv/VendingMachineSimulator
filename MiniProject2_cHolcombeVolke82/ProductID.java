/**
 * This class holds the product ID information
 * @author Candace Holcombe-Volke
 *
 */
public class ProductID
{
    private String productID; 

    public ProductID( String prodID )
    {
        this.productID = prodID; 
    }
    
    public ProductID()
    {
        this.productID = null;
    }
    
    public void setProductID(String id)
    {
        this.productID = id; 
    }
    
    public String getProductID()
    {
        return this.productID;
    }
    
    public String toString()
    {
        return "Item Number: " + productID + "\n"; 
    }    
}