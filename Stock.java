/* ******************************* START TEST Stock ****


************** Test Add method*******************

************** Test toString method

************** Test howMany

************** Test mostExpensive

************** Test howManyPieces

************** Test removeAfterDate
	==> ERROR in removeAfterDate method - if stock is:
Food Item: HotDog Catalogue Number: 1111 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 3
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 18/12/2019 Quantity: 2
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 15
Food Item: Honey Catalogue Number: 4456 Production Date: 14/12/2019 Expiry Date: 19/12/2019 Quantity: 2

and trying to execute removeAfterDate with Date: 18/12/2019
then stock should be:
Food Item: Honey Catalogue Number: 4456 Production Date: 14/12/2019 Expiry Date: 19/12/2019 Quantity: 2
 
while student stock is:
FoodItem:  Milk	CatalogueNumber: 1234	ProductionDate: 14/12/2019	ExpiryDate: 18/12/2019	Quantity: 2
FoodItem:  Honey	CatalogueNumber: 4456	ProductionDate: 14/12/2019	ExpiryDate: 19/12/2019	Quantity: 2


	==> ERROR in removeAfterDate method - if stock is:
Food Item: HotDog Catalogue Number: 1111 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 3
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 18/12/2019 Quantity: 2
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 15
Food Item: Honey Catalogue Number: 4456 Production Date: 14/12/2019 Expiry Date: 19/12/2019 Quantity: 2

and trying to execute removeAfterDate with Date: 22/12/2019
then stock should should be: (empty Stock)
while student stock is:
FoodItem:  Milk	CatalogueNumber: 1234	ProductionDate: 14/12/2019	ExpiryDate: 18/12/2019	Quantity: 2
FoodItem:  Honey	CatalogueNumber: 4456	ProductionDate: 14/12/2019	ExpiryDate: 19/12/2019	Quantity: 2



************** Test order
	==> ERROR in order method - if stock is:
Food Item: HotDog Catalogue Number: 1111 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 3
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 18/12/2019 Quantity: 2
Food Item: Milk Catalogue Number: 1234 Production Date: 14/12/2019 Expiry Date: 17/12/2019 Quantity: 15
Food Item: Honey Catalogue Number: 4456 Production Date: 14/12/2019 Expiry Date: 19/12/2019 Quantity: 2

then order(3) should return the list: Honey
while student method returns: , Honey


************** Test getTempOfStock

************** Test updateStock method

******************************** END TEST STOCK *************************** -5 */


/**
 * Stock Class will display all kinds of FoodItem objects, as well make changes in them objects using various of methods in the process.
 *
 * @author Kai Toledano.
 * @version 2020a.
 */

public class Stock // Start of Stock Class
{
    // declaration.

    private int _numOfItems;

    private final int MAX_ARRAY_NUM = 100;

    private FoodItem[] _stock;

  

    /**
     * The defalut constructor will initialize the _stock array with the MAX_ARREY_NUM as its maximum value,
     * and will set the _numOfItems counter to zero.
     */ 
    public Stock()  // Start of defalut constructor.
    {
        _stock = new FoodItem[MAX_ARRAY_NUM];

        _numOfItems = 0;

    }  // End of defalut constructor.

    /**
     * The getNumOfItems is the counter that will show how much objects are in Stock. 
     * @return _numOfItems
     */
    public int getNumOfItems() // This method keeps tabs on how much items are present.
    {
        return  _numOfItems;
    }

    /**
     * The addItem method will facilitate the addition of FoodItem objects.
     * @param FoodItem newItem
     * @return true if the addition complete, false otherwise.
     */
    public boolean addItem(FoodItem newItem) // The addItem is the method that controls the addition and sorting of FoodItem objects.  
    {
        for(int i = 0; i < _numOfItems; i++)
        {
            if(_stock[i].equals(newItem)) // This condition will take two equal objects and sum their quantity.
            {
                _stock[i].setQuantity(_stock[i].getQuantity() + newItem.getQuantity());
                return true; 
            }
        }

        if(this._numOfItems >= MAX_ARRAY_NUM )
        {
            return false;
        }
        
        for(int i = 0; i < _numOfItems; i++)
        {  

            if(_stock[i].getName().equals(newItem.getName()) || _stock[i].getCatalogueNumber() > newItem.getCatalogueNumber())
            {
                FoodItem temp;

                temp = _stock[i];
                _stock[i] = newItem;
                newItem = temp;
            }

            

        }
        _stock[_numOfItems] = new FoodItem(newItem);
        _numOfItems++;

        return true;
    }

    /**
     * The order method will only print FoodItem objects that are in need of ordering.
     * @param int amount
     * @return orderList
     */
     public String order(int amount) // This method will print a list of items that are in need of order, if the quantity of the items is below the given amount, and if the sum of two same items 
                                     //but not equal is below the given amount as well.                               
    {
        String orderList = ""; 
        int sum = 0;
        String name = "";
        
        for(int i = 1; i < _numOfItems; i++)
        {
            if( i == 1)
            {
                sum = _stock[i - 1].getQuantity();
                name = _stock[i - 1].getName();
            }
            if((name.equals(_stock[i].getName())))
            {
                sum += _stock[i].getQuantity();
            }
            else
            {
                if(sum < amount)
                {
                    if(orderList == "")
                    {
                        orderList += name;
                    }
                    else
                    {
                        orderList += ", " + name;
                    }
                    sum = _stock[i].getQuantity();
                    name = _stock[i].getName();
                }
                else
                {
                    sum = _stock[i].getQuantity();
                    name = _stock[i].getName();
                }
            }
            if(i == _numOfItems - 1)
            {
                if(sum < amount)
                {
                    orderList += ", " + name;
                }
            }
        }
        return orderList;
    }


    /**
     * The howMany method will check how many items can be stored in a range of given temperatures.
     * @param int temp
     * @return productQuantity
     */
    public int howMany(int temp) // Checks how many items can be stored in a range of given temperatures.
    {
        int productQuantity = 0;

        for(int i = 0; i < _numOfItems; i++)
        {
            if(temp >= _stock[i].getMinTemperature() && temp <= _stock[i].getMaxTemperature())
            {
                productQuantity += _stock[i].getQuantity();
            }
            if(_stock[i].getQuantity() == 0)
            {
                productQuantity = 0;
            }
        }

        return productQuantity;
    }
   
    /**
     * Checks for items that thier expiry date is due after a given date, and removes them.
     * 
     * @param Date d
     * 
     */
    public void removeAfterDate(Date d)  // Checks for items that thier expiry date is due on a given date, and removes them.
    {
        for(int i = 0; i < _numOfItems; i++)
        {
            if(_stock[i].getExpiryDate().before(d) || _stock[i].getExpiryDate().equals(d))
            {
                remove(i);
            }
        }
    }

    /**
     * Checks for the most expensive item in Stock.
     * 
     * @return FoodItem(mostExpensive)
     * 
     */
    public FoodItem mostExpensive() // Checks for the most expensive item in Stock.
    {
        if(_numOfItems == 0)
        {
            return null;
        }

        FoodItem mostExpensive = _stock[0];

        for(int i = 1; i < _numOfItems; i++)
        {
            if(_stock[i].getPrice() > mostExpensive.getPrice())
            {
                mostExpensive = _stock[i];
            }
        }

        return new FoodItem(mostExpensive);
    }

    /**
     * Checks how many units can be brought with a given sum of money.
     * 
     * @return howManyPieces
     * 
     */
    public int howManyPieces() // Checks how many units can be brought with a given sum of money.
    {
        if(_numOfItems == 0)
        {
            return 0;
        }

        int howManyPieces = 0;

        for(int i = 0; i < _numOfItems; i++)
        {
            howManyPieces += _stock[i].getQuantity();
        }

        return howManyPieces;
    }

    /**
     * This method subtract items from Stock that appears in a given array.
     * 
     * @param String[] itemList
     * 
     */
    public void updateStock(String[] itemsList) // This method subtract items from Stock that appears in a given array.
    {
        if(_numOfItems == 0 || _stock == null)
        {
        }
        for(int j = 0; j < itemsList.length; j++)
        {
            for(int i = 0; i < _numOfItems; i++)
            {
                if(_stock[i].getName().equals(itemsList[j]) ) // If an item in Stock is found equal, then it will be removed by one and its quantity will be updated to the new quantity.
                {
                    _stock[i].setQuantity(_stock[i].getQuantity()-1);

                    if(_stock[i].getQuantity() == 0) // After substracting an item, the method will check if the new quantity is zero, if so, it will continue to the next same item. (if present) 
                    {                                // and substract the rest of the items that are on the array.
                        remove(i);
                    }
                    break;
                } 
            }  
        }
    }

    private void remove(int i) // This private method will prevent any "holes" form forming in Stock.
    {
        for(int j = i; j < _numOfItems; j++)
        {
            _stock[j] = _stock[j + 1];
            _stock[j + 1] = _stock[_numOfItems - 1];
            
        }
        _numOfItems--;
    }

    /**
     * Checks for the minimum temperature that available, if not the maximum temperature will be returend.
     * 
     * @return mostMin
     * 
     */
    public int getTempOfStock() // Checks for the minimum temperature that available, if not the maximum temperature will be returend.
    {
        if(_numOfItems == 0) 
        {
            return Integer.MAX_VALUE;
        }

        int smallest = _stock[0].getMinTemperature();
        int largest  = _stock[0].getMaxTemperature();

        for(int i = 1; i < _numOfItems; i++)
        {
            if(smallest < _stock[i].getMinTemperature())
            {
                smallest = _stock[i].getMinTemperature();
            }
            if(largest > _stock[i].getMaxTemperature())
            {
                largest = _stock[i].getMaxTemperature();
            }
        }

        if(smallest > largest)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return smallest;
        }
    }

    /**
     * Shows the final Stock in an orderly fashion.
     * 
     * @return totalStock
     * 
     */
    public String toString() // Shows the final Stock in an orderly fashion.
    { 
        String totalStock = "";

        for(int i = 0; i < _numOfItems; i++)
        {
            totalStock += "FoodItem: " + " " + _stock[i].getName() + "\t" + "CatalogueNumber: " + _stock[i].getCatalogueNumber() + "\t" + "ProductionDate: " + _stock[i].getProductionDate() +
            "\t" + "ExpiryDate: " + _stock[i].getExpiryDate() + "\t" + "Quantity: " +_stock[i].getQuantity() + "\n";
        }

        return totalStock;
    }
} // End of Class Stock.
