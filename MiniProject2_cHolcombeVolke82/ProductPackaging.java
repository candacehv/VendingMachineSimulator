/**
 * This class holds the product packaging information
 * @author Candace Holcombe-Volke
 *
 */
public class ProductPackaging
{
    String packaging; 
    
    public ProductPackaging(String prodPack)
    {
        this.packaging = prodPack; 
    }
    
    public ProductPackaging()
    {
        this.packaging = null; 
    }

    public void setPackaging(String pack)
    {
        this.packaging = pack;
    }
    
    public String getProductPackaging()
    {
        return packaging;
    }
    
    public String toString()
    {
        return "Packaging: " + packaging + "\n";
    }
}
