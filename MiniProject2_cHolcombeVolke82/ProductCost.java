/**
 * This class holds the product cost information
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class ProductCost
{

    private double cost; 
    
    /**
     * Product Cost constructor with double arg
     * @param prodCost is the base value of the product
     */
    public ProductCost(double prodCost)
    {
        this.cost = prodCost; 
    }

    /**
     * Default Product cost constructor, no args
     */
    public ProductCost()
    {
        this.cost = 0; 
    }
    
    
    /**
     * Set method for product cost
     * @param prodCost is base value
     */
    public void setProductCost( double prodCost)
    {
        this.cost = prodCost;
    }
    
    /**
     * Get method for product cost with no args
     * @return the product cost base value
     */
    public double getProductCost()
    {
        return cost;
    }
    
    public String toString()
    {
        return "Cost: $" + cost/100 + "\n";
    }
}
