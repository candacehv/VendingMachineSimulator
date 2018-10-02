/**
 * This class holds the product ID, name, description, packaging, cost,
 * and quantity information. (Note: productList stores the array of inventory
 * int the Inventory class. 
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class Product 
{
    private String productID; 
    private String name; 
    private String description; 
    private String packaging; 
    protected double cost; 
    protected int quantity; 
    
    
    public String toString()
    {
       return  ""+ productID + name + description + packaging + cost 
           + quantity; 
    }
    
    public Product (String productID, String name, String description, 
        String packaging, double cost, int quantity) 
    {
        this.productID = productID; 
        this.name = name;
        this.description = description;
        this.packaging = packaging;
        this.cost = cost; 
        this.quantity = quantity;
    }
    
    public Product()
    {
        this.name = null;
        this.productID = null; 
        this.description = null;
        this.packaging = null;
        this.cost = 0; 
        this.quantity = 0;
    }
    
    public String getName( Product productList)
    {
        return productList.name; 
    }
    public String getProductID( Product productList)
    {
        return productList.productID; 
    }
    
    public String getDescription( Product productList)
    {
        return productList.description; 
    }
    
    public Double getCost( Product productList)
    {
        return productList.cost; 
    }
    public int getQuantity( Product productList)
    {
        return productList.quantity; 
    }
}
