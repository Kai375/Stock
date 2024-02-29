package item;

import date.Date;
/**
 * FoodItem program will display all kind of foods, using various of methods in the process.
 *
 * @author Kai Toledano.
 */
public class FoodItem // Start of Class FoodItem.
{
  // declaration.
  
  private final int DEFAULT_PRICE = 1;
  
  private final int MAX_CATALOGUE_NUMBER = 9999, MIN_CATALOGUE_NUMBER = 1000;
  
  private final int MIN_QUANTITY = 0;
  
  private final String name;
  
  private final int minTemperature, maxTemperature;
  
  private final long catalogueNumber;
  
  private Date productionDate, expiryDate;
  
  private int quantity, price;
  
  /**
  * Constructor.
  */
  public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, int minTemperature, int maxTemperature, int price) //Start of constructor.
  {
      if(price <= 0) // Checks for a valid price input.
      {
          price = DEFAULT_PRICE;
      }
      
       if(name.length() == 0) // Checks for a valid name, if false, will display a default one.
      {
         name =  "item";
      }
      
       if(catalogueNumber > MAX_CATALOGUE_NUMBER || catalogueNumber < MIN_CATALOGUE_NUMBER)// Checks for a valid catalogue number, if false, will display a default one
      {
         catalogueNumber = MAX_CATALOGUE_NUMBER;
      }
      
       if(quantity <= 0) // Checks for a valid quantity, if false, will display a default one.
      {
         quantity = MIN_QUANTITY;
      }
      
       if(expiryDate.before(productionDate)) // Checks if a product's expiry date is before its production date, if true, will replace the expiry date with the date after the production date.
      {
         expiryDate = productionDate.tomorrow();
      }
      
      if(minTemperature > maxTemperature) // Checks if the min temperature is higher than the max temperature, if true, will replace them with each other.
      {
         int temp = maxTemperature;
         
         maxTemperature = minTemperature;
         
         minTemperature = temp;
      }
      
      
      this.name = name;                                      //-----------------------------
      this.catalogueNumber = catalogueNumber;                //
      this.quantity = quantity;                              //
      this.productionDate = new Date(productionDate);        // The final FoodItem product.
      this.expiryDate = new Date(expiryDate);                //
      this.minTemperature = minTemperature;                  //
      this.maxTemperature = maxTemperature;                  //-----------------------------
      this.price = price;
      
  } //End of constructor.
  
  /**
  *  Copy constructor.
  */
  public FoodItem(FoodItem other) //Start of copy constructor.
  {
      
    name = other.name;
    catalogueNumber = other.catalogueNumber;
    quantity = other.quantity;
    productionDate = new Date(other.productionDate);
    expiryDate = new Date (other.expiryDate);
    minTemperature = other.minTemperature;
    maxTemperature = other.maxTemperature;
    price = other.price;
    
  } //End of copy constructor.
  
  /**
  *  setQuantity will alter the item's quantity to the wanted amount, if the condition is valid.
  */
  public void setQuantity(int n) // will alter the item's quantity to the wanted amount, if the condition is valid.
  {
     if(0 <= n)
     {
       quantity = n;
     }
  }
  
  /**
  *  setProductionDate sets the expiry date (only if not before production date).
  */
  public void setProductionDate(Date d) // sets the expiry date (only if not before production date).
  {
    if(!d.after(expiryDate))
    {
       productionDate =  new Date(d);
    }
  }
  
  /**
  *  setExpiryDate sets the production date (only if not after expiry date).
  */
  public void setExpiryDate(Date d) // sets the production date (only if not after expiry date).
  {
    if(!d.before(productionDate))
    {
       expiryDate = new Date(d);
    }
  }
  
  /**
  *  setPrice sets the price (only if positive).
  */
  public void setPrice(int n) // sets the price (only if positive).
  {
    if(0 < n)
    {
        price = n;
    }
  }
  
  /**
  *  getCatalogueNumber gets the catalogueNumber.
  *
  * * @return catalogueNumber
  */
  public long getCatalogueNumber() // gets the catalogueNumber.
  {
      return catalogueNumber;
  }
  
  /**
  *  getName gets the Name.
  *
  * * @return name
  */
  public String getName() // gets the Name.
  {
      return name;
  }
  
  /**
  *  getQuantity gets the Quantity.
  *
  * * @return quantity
  */
  public int getQuantity() // gets the Quantity.
  {
      return quantity;
  }
  
  /**
  *  getProductionDate gets the production date.
  *
  * * @return Date
  */
  public Date getProductionDate() // gets the production date object.
  {
      return new Date(productionDate);
  }
  
  /**
  *  getMinTemperature gets the expiry date.
  *
  * * @return Date
  */
  public Date getExpiryDate() // gets the expiry date object.
  {
      return new Date(expiryDate);
  }
  
  /**
  *  getExpiryDate gets the minTemperature.
  *
  * * @return minTemperature
  */
 public int getMinTemperature() // gets the minTemperature.
  {
      return minTemperature;
  }
  
  /**
  *  getMaxTemperature gets the maxTemperature.
  *
  * * @return maxTemperature
  */
  public int getMaxTemperature() // gets the maxTemperature.
  {
      return maxTemperature;
  }
  
  /**
  *  getPrice gets the price.
  *
  * * @return price
  */
  public int getPrice() // gets the price.
  {
      return price;
  }
  
  /**
  *  the equal's method checks if two food-items are, well, equals.
  * * @param FoodItem other
  * * @return true if the items are the same
  */
  public boolean equals(FoodItem other) // Checks if two different FoodItem objects are the same or not.
  {
      return productionDate.equals(other.productionDate) && expiryDate.equals(other.expiryDate) && name.equalsIgnoreCase(other.name) &&
              catalogueNumber == other.catalogueNumber && price == other.price && minTemperature == other.minTemperature && maxTemperature == other.maxTemperature;
  }
  
  /**
  *  checks if this food item is fresh on the date d.
  * * @param Date d
  * * @return true if the item is fresh
  */
  public boolean isFresh(Date d) // checks if this food item is fresh on the date d or not.
  {
      return (d.after(productionDate) || d.equals(productionDate)) && (d.before(expiryDate) || d.equals(expiryDate));
  }
  
  /**
  *  checks if this food item is older than other food item.
  * * @param FoodItem other
  * * @return true if the item is older
  */
  public boolean olderFoodItem(FoodItem other) // checks if this food item is older than other food item or not.
  {
      return other.productionDate.after(productionDate);
  }
  
  /**
  *   returns the number of units of products that can be purchased for a given amount.
  * * @param int amount
  * * @return the number of units can be purchased
  */
  public int howManyItems(int amount) // shows how many units of products that can be purchased for a given amount.
  {
     int totalProducts = (amount / price);
     
     if(totalProducts > quantity)
     {
        totalProducts = quantity;
     }
     
     return totalProducts;
  }
  
  /**
  *    checks if this food item is cheaper than other food item.
  * * @param FoodItem other
  * * @return true if this food item is cheaper than other date
  */
  public boolean isCheaper(FoodItem other) // checks if this food item is cheaper than other food item.
  {
      return other.price > price;
  }
  
  /**
  *    returns a String that represents this food item.
  * * @overwrite
  * * @return String that represents this food item in the following format:
      FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
  */
  public String toString() // shows the final data in an orderly fashion.
  {
      return "FoodItem: " + name +"\t"+ "CatalogueNumber: " + catalogueNumber +"\t"+ "ProductionDate: " + productionDate +"\t"+ "ExpiryDate: " + expiryDate +"\t"+ "Quantity: " + quantity;
  }
} // End of Class FoodItem.
