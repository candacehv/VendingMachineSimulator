/**
 * This class holds the product name information
 * 
 * It has a constructor with string parameter, and defaul with no params
 * It has set and get methods and a toString
 * @author Candace Holcombe-Volke
 *
 */
public class ProductName
{
    private String name; 
    
    public ProductName(String prodName)
    {
        this.name = prodName; 
    }
    
    public ProductName()
    {
        this.name = null; 
    }
    
    public void setProductName(String prodName)
    {
        this.name = prodName; 
    }
    
    public String getProductName()
    {
        return name; 
    }
    
    
    public String toString()
    {
        return "Item Name: " + name + "\n"; 
    }
}
