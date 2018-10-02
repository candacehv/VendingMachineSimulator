/**
 * This class holds product description information
 * @author Candace Holcombe-Volke
 *
 */
public class ProductDescription
{
    private String description; 
   
    public ProductDescription(String prodDesc)
    {
        this.description = prodDesc; 
    }
    
    public ProductDescription()
    {
        this.description = null; 
    }
    
    
    public void setProductDescription(String descrip)
    {
        this.description = descrip; 
    }
    
    public String getProductDescription()
    {
       return description; 
    }
    
    
    public String toString()
    {
        return "Description: " + description + "\n";
    }
}
