

/**
 * FoodItem program will display all kind of foods, using various of methods in the process.
 *
 * @author Kai Toledano.
 * @2020a
 */
public class FoodItem // Start of Class FoodItem.
{
  // declaration.
  
  private final int DEFAULT_PRICE = 1;
  
  private final int MAX_CATALOGUE_NUMBER = 9999, MIN_CATALOGUE_NUMBER = 1000;
  
  private final int MIN_QUANTITY = 0;
  
  private final String _name;
  
  private final int  _minTemperature, _maxTemperature;
  
  private final long _catalogueNumber;
  
  private Date _productionDate, _expiryDate;
  
  private int _quantity, _price;
  
  /**
  * Constructor.
  * @param String _name
  * @param long _catalogueNumber
  * @param int _quantity
  * @param Date _productionDate
  * @param Date _expiryDate
  * @param int _minTemperature
  * @param int _maxTemperature
  * @param int _price
  * @return FoodItem object.
  */
  public FoodItem(String _name, long _catalogueNumber, int _quantity, Date _productionDate, Date _expiryDate, int _minTemperature, int _maxTemperature, int _price) //Start of constructor.
  {
      if(_price <= 0) // Checks for a valid price input.
      {
          _price = DEFAULT_PRICE;
      }
      
       if(_name.length() == 0) // Checks for a valid name, if false, will display a default one.
      {
         _name =  "item"; 
      }
      
       if(_catalogueNumber < 0 || _catalogueNumber > MAX_CATALOGUE_NUMBER || _catalogueNumber < MIN_CATALOGUE_NUMBER)// Checks for a valid catalogue number, if false, will dispaly a default one 
      {
         _catalogueNumber = MAX_CATALOGUE_NUMBER; 
      }
      
       if(_quantity <= 0) // Checks for a valid quantity, if false, will display a default one.
      {
         _quantity = MIN_QUANTITY; 
      }
      
       if(_expiryDate.before(_productionDate)) // Checks if a products expiry date is before its production date, if true, will replace the expiry date with the date after the production date.
      {
         _expiryDate = _productionDate.tomorrow(); 
      }
      
      if(_minTemperature > _maxTemperature) // Checks if the min temperature is higher then the max temperture, if true, will replace them with each other.
      {
         int temp = _maxTemperature;
         
         _maxTemperature = _minTemperature;
         
         _minTemperature = temp;
      }
      
      
      this._name = _name;                                      //-----------------------------                                         
      this._catalogueNumber = _catalogueNumber;                //
      this._quantity = _quantity;                              //
      this._productionDate = new Date(_productionDate);        // The final FoodItem product.
      this._expiryDate = new Date(_expiryDate);                //  
      this._minTemperature = _minTemperature;                  //   
      this._maxTemperature = _maxTemperature;                  //----------------------------- 
      this._price = _price;
      
  } //End of constuctor.
  
  /**
  *  Copy constructor.
  *  
  * @param String other._name
  * @param long other._catalogueNumber
  * @param int other._quantity
  * @param Date other._productionDate
  * @param Date other._expiryDate
  * @param int other._minTemperature
  * @param int other._maxTemperature
  * @param int other._price
  * 
  * @return A copy of a FoodItem object.
  */
  public FoodItem(FoodItem other) //Start of copy constructor.
  {
      
    _name = other._name;
    _catalogueNumber = other._catalogueNumber;
    _quantity = other._quantity;
    _productionDate = new Date(other._productionDate);
    _expiryDate = new Date (other._expiryDate);
    _minTemperature = other._minTemperature;
    _maxTemperature = other._maxTemperature;
    _price = other._price;
    
  } //End of copy constructor.
  
  /**
  *  setQuantity will alter the items quantity to the wanted amount, if the condition is valid.
  *
  * @param int n.
  * 
  */
  public void setQuantity(int n) // will alter the items quantity to the wanted amount, if the condition is valid.
  {
     if(n >= 0)
     {
       _quantity = n;  
     }
  }
  
  /**
  *  setProductionDate sets the expiry date (only if not before production date).
  *
  * @param Date d.
  * 
  */
  public void setProductionDate(Date d) // sets the expiry date (only if not before production date).
  {
    if(!d.after(_expiryDate))
    {
       _productionDate =  new Date(d);
    }
  }
  
  /**
  *  setExpiryDate sets the production date (only if not after expiry date).
  *
  * @param Date d.
  * 
  */
  public void setExpiryDate(Date d) // sets the production date (only if not after expiry date).
  {
    if(!d.before(_productionDate))
    {
       _expiryDate = new Date(d);
    }
  }
  
  /**
  *  setPrice sets the price (only if positive).
  *
  * @param int n.
  * 
  */
  public void setPrice(int n) // sets the price (only if positive).
  {
    if(n > 0)
    {
        _price = n;
    }
  }
  
  /**
  *  getCatalogueNumber gets the catalogueNumber.
  *
  * * @return _catalogueNumber
  */
  long getCatalogueNumber() // gets the catalogueNumber.
  {
      return _catalogueNumber;
  }
  
  /**
  *  getName gets the Name.
  *
  * * @return _name
  */
  String getName() // gets the Name.
  {
      return _name;
  }
  
  /**
  *  getQuantity gets the Quantity.
  *
  * * @return _quantity
  */
  int getQuantity() // gets the Quantity.
  {
      return _quantity;
  }
  
  /**
  *  getProductionDate gets the production date.
  *
  * * @return Date
  */
  Date getProductionDate() // gets the production date object.
  {
      return new Date(_productionDate);
  }
  
  /**
  *  getMinTemperature gets the expiry date.
  *
  * * @return Date
  */
  Date getExpiryDate() // gets the expiry date object.
  {
      return new Date(_expiryDate);
  }
  
  /**
  *  getExpiryDate gets the minTemperature.
  *
  * * @return _minTemperature
  */
  int getMinTemperature() // gets the minTemperature.
  {
      return _minTemperature;
  }
  
  /**
  *  getMaxTemperature gets the maxTemperature.
  *
  * * @return _maxTemperature
  */
  int getMaxTemperature() // gets the maxTemperature.
  {
      return _maxTemperature;
  }
  
  /**
  *  getPrice gets the price.
  *
  * * @return price
  */
  int getPrice() // gets the price.
  {
      return _price;
  }
  
  /**
  *  the equals method checks if two fooditems are, well, equals.
  * * @param FoodItem other
  * * @return true if the items are the same
  */
  public boolean equals(FoodItem other) // Checks if two different FoodItem objects are the same or not.
  {
      if(_productionDate.equals(other._productionDate) && _expiryDate.equals(other._expiryDate) && other._price == _price && _name.equalsIgnoreCase(other._name) && 
           _catalogueNumber == other._catalogueNumber && _price == other._price && _minTemperature == other._minTemperature && _maxTemperature == other._maxTemperature)
      
      {
          return true;
      }
      
      return false;
  }
  
  /**
  *  checks if this food item is fresh on the date d.
  * * @param Date d
  * * @return true if the item is fresh
  */
  public boolean isFresh(Date d) // checks if this food item is fresh on the date d or not.
  {
      boolean fresh = false;
      
      if((d.after(_productionDate) || d.equals(_productionDate)) && (d.before(_expiryDate) || d.equals(_expiryDate)))
      {
          fresh = true;
          return fresh;
      }
      
      return fresh;
  }
  
  /**
  *  checks if this food item is older than other food item.
  * * @param FoodItem other
  * * @return true if the item is older
  */
  public boolean olderFoodItem(FoodItem other) // checks if this food item is older than other food item or not.
  {
      if(other._productionDate.after(_productionDate))
      {
          return true;
      }
     
      return false;
  }
  
  /**
  *   returns the number of units of products that can be purchased for a given amount.
  * * @param int amount
  * * @return the number of units can be purchased
  */
  public int howManyItems(int amount) // shows how many units of products that can be purchased for a given amount.
  {
     int totalProducts = (amount / _price); 
     
     if(totalProducts > _quantity)
     {
        totalProducts =  _quantity;
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
     if(other._price > _price)
     {
         return true;
     }
     
     return false;
  }
  
  /**
  *    returns a String that represents this food item.
  * * @overwrite
  * * @return String that represents this food item in the following format:
      FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
  */
  public String toString() // shows the final data in an orderly fashion.
  {
      return "FoodItem: " + _name +"\t"+ "CatalogueNumber: " + _catalogueNumber +"\t"+ "ProductionDate: " + _productionDate +"\t"+ "ExpiryDate: " + _expiryDate +"\t"+ "Quantity: " + _quantity;
  }
} // End of Class FoodItem.
