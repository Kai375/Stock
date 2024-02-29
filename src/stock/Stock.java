package stock;

import item.FoodItem;

import date.Date;
/**
 * Stock Class will display all kinds of FoodItem objects, as well make changes in them objects using various of methods in the process.
 *
 * @author Kai Toledano.
 */

public class Stock // Start of Stock Class
{
    // declaration.
    private int numberOfItems;

    private final int MAX_ARRAY_NUM = 100;

    private final FoodItem[] stock;

    /**
     * The default constructor will initialize the stock array with the MAX_ARRAY_NUM as its maximum value,
     * and will set the numberOfItems counter to zero.
     */ 
    public Stock()  // Start of default constructor.
    {
        stock = new FoodItem[MAX_ARRAY_NUM];

        numberOfItems = 0;

    }  // End of default constructor.

    /**
     * The getNumOfItems is the counter that will show how many objects are in Stock.
     * @return numberOfItems
     */
    public int getNumOfItems() // This method keeps tabs on how many items are present.
    {
        return numberOfItems;
    }

    /**
     * The addItem method will facilitate the addition of FoodItem objects.
     */

    public boolean addItem(FoodItem newItem) // The addItem is the method that controls the addition and sorting of FoodItem objects.
    {
        for(int i = 0; i < numberOfItems; i++)
        {
            if(stock[i].equals(newItem)) // This condition will take two equal objects and sum their quantity.
            {
                 stock[i].setQuantity(stock[i].getQuantity() + newItem.getQuantity());

                 return true;
            }
        }
        
        for(int i = 0; i < numberOfItems; i++)
        {  

            if(stock[i].getName().equals(newItem.getName()) || stock[i].getCatalogueNumber() > newItem.getCatalogueNumber())
            {
                FoodItem temp;

                temp = stock[i];
                stock[i] = newItem;
                newItem = temp;
            }
            if((i + 1 < numberOfItems) && (stock[i].getCatalogueNumber() == stock[i + 1].getCatalogueNumber()) && (stock[i].getExpiryDate().after(stock[i + 1].getExpiryDate())))
            {
                FoodItem temp = stock[i];
                stock[i] = stock[i + 1];
                stock[i+ 1] = temp;
            }
        }

        if(MAX_ARRAY_NUM <= numberOfItems)
        {
            return false;
        }

        stock[numberOfItems] = new FoodItem(newItem);

        numberOfItems++;

        return true;
    }

    /**
     * The order method will only print FoodItem objects that are in need of ordering.
     */
     public String order(int amount) // This method will print a list of items that are in need of order, if the quantity of the items is below the given amount, and if the sum of two same items 
                                     //but not equal is below the given amount as well.                               
    {

    StringBuilder orderList = new StringBuilder();

    for(int i = 0; i < numberOfItems; i++)
    {
        int currentQuantity = stock[i].getQuantity();

        for(int j = 0; j < numberOfItems -1; j++)
        {
            if(stock[i].getName().equals(stock[j].getName()) && stock[i].getCatalogueNumber() == stock[j].getCatalogueNumber())
            {
                currentQuantity += stock[i].getQuantity()+ stock[j].getQuantity();
            }
        }
        if(currentQuantity > stock[i].getQuantity())
        {
            currentQuantity -= stock[i].getQuantity();
        }
        if(currentQuantity < amount)
        {
            orderList.append(stock[i].getName()).append(", ");
        }
    }
    
    if(orderList.isEmpty())
    {
        orderList.append("The inventory is stocked within exceptable limits. ");
    }
        orderList.replace(orderList.length()-2, orderList.length()-1, "");

      return orderList.toString();
    }

    /**
     * The howMany method will check how many items can be stored in a range of given temperatures.
     */
    public int howMany(int temp) // Checks how many items can be stored in a range of given temperatures.
    {
        int productQuantity = 0;

        for(int i = 0; i < numberOfItems; i++)
        {
            if(temp >= stock[i].getMinTemperature() && temp <= stock[i].getMaxTemperature())
            {
                productQuantity += stock[i].getQuantity();
            }
            if(stock[i].getQuantity() == 0)
            {
                productQuantity = 0;
            }
        }

        return productQuantity;
    }
   
    /**
     * Checks for items that their expiry date is due after a given date, and removes them.
     */
    public void removeAfterDate(Date d)  // Checks for items that their expiry date is due on a given date, and removes them.
    {
        int i = 0;

        while(i < numberOfItems)
        {
            if(stock[i].getExpiryDate().before(d) || stock[i].getExpiryDate().equals(d))
            {
               stock[i] = stock[numberOfItems - 1];

               numberOfItems--;
            }
            else
            {
                i++;
            }
        }
        for(int j = 0; j < numberOfItems; j++)
        {
            if(j + 1 < numberOfItems && stock[j].getCatalogueNumber() > stock[j + 1].getCatalogueNumber())
            {
                FoodItem temp;

                temp = stock[j];
                stock[j] = stock[j + 1];
                stock[j + 1]= temp;
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
        if(numberOfItems == 0)
        {
            return null;
        }

        FoodItem mostExpensive = stock[0];

        for(int i = 1; i < numberOfItems; i++)
        {
            if(stock[i].getPrice() > mostExpensive.getPrice())
            {
                mostExpensive = stock[i];
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
        if(numberOfItems == 0)
        {
            return 0;
        }

        int howManyPieces = 0;

        for(int i = 0; i < numberOfItems; i++)
        {
            howManyPieces += stock[i].getQuantity();
        }

        return howManyPieces;
    }

    /**
     * This method subtract items from Stock that appears in a given array.
     */
    public void updateStock(String[] itemsList) // This method subtract items from Stock that appears in a given array.
    {
        for(String s : itemsList)
        {
            int i = 0;

            while(i < numberOfItems)
            {
                if(stock[i].getName().equals(s)) // If an item in Stock is found equal, then it will be removed by one and its quantity will be updated to the new quantity.
                {
                    stock[i].setQuantity(stock[i].getQuantity() - 1);
                }

                if(stock[i].getQuantity() == 0) // After subtracting an item, the method will check if the new quantity is zero, if so, it will continue to the next same item. (if present)
                {                                // and subtract the rest of the items that are on the array.
                    stock[i] = stock[numberOfItems -1];

                    numberOfItems--;
                }
                else
                {
                    i++;
                }
            }
        }
    }

    /**
     * Checks for the minimum temperature that available, if not the maximum temperature will be returned.
     * 
     * @return mostMin
     * 
     */
    public int getTempOfStock() // Checks for the minimum temperature that available, if not the maximum temperature will be returned.
    {
        if(numberOfItems == 0)
        {
            return Integer.MAX_VALUE;
        }

        int smallest = stock[0].getMinTemperature();
        int largest  = stock[0].getMaxTemperature();

        for(int i = 1; i < numberOfItems; i++)
        {
            if(smallest < stock[i].getMinTemperature())
            {
                smallest = stock[i].getMinTemperature();
            }
            if(largest > stock[i].getMaxTemperature())
            {
                largest = stock[i].getMaxTemperature();
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
        StringBuilder totalStock = new StringBuilder();

        for(int i = 0; i < numberOfItems; i++)
        {
            totalStock.append("FoodItem: " + " ").append(stock[i].getName()).append("\t").append("CatalogueNumber: ").append(stock[i].getCatalogueNumber()).append("\t").append("ProductionDate: ").append(stock[i].getProductionDate()).append("\t").append("ExpiryDate: ").append(stock[i].getExpiryDate()).append("\t").append("Quantity: ").append(stock[i].getQuantity()).append("\n");
        }

        return totalStock.toString();
    }
} // End of Class Stock.
