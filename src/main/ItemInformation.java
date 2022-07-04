package main;
public class ItemInformation 
{
    private String itemID;
    private String itemName;
    private double itemPrice;
    private String datePurchase;
    private String custID;
    
    public ItemInformation()// constactor no parameter
    { 
        this.itemID = null;
        this.itemName = null;
        this.datePurchase = null;
        this.custID = null;
        this.itemPrice = 0;
    }
    
    public ItemInformation(String itemID, String itemName, double itemPrice, String datePurchase, String custID)// constactor with parameter
    { 
        this.itemID = itemID;
        this.itemName = itemName;
        this.datePurchase = datePurchase;
        this.custID = custID;
        this.itemPrice = itemPrice;
    }
    
    public String getItemID()
    {
        return itemID;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public double getitemPrice()
    {
        return itemPrice;
    }
    
    public String getDatePurchase()
    {
        return datePurchase;
        
    }
    
    public String getCustID()
    {
        return custID;
    }
    
}
