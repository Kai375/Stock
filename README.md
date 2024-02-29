# Inventory implementation with OOPs (Object-Oriented Programming System).

# Inventory management project, made with Java.

Project description:

The project is separated into several files that coalesce into an inventory management system, each file responsible for a different function in the project and follows Java's OPP concepts.

# Date Class description:

Date Class is responsible for issuing a valid Date object.

Date class will not assume that the parameters given by the user are valid, and if at least one of them is invaild, then the Date object that will be issued is: 01/01/2000.

Date Class recognizes leap years.

It has the following three instance variables:

* day: 1 <= day <= 31.
* month: 1 <= month <= 12.
* year: 4 digit positive integer.

* It has two constructors:

   First constructor gets the three instance variables.

   Second constructor is a copy constructor and it gets a copy of a date object called 'other'.

* Date class has the regular getters. And setters that check the parameters for their validation. If they are invaild, then the date of the object will remain the same.

* equals method: Gets a Date object as parameter and checks if its date equals the date of the object that the methood is called upon.

* before metod: Checks if the date of the object that the methood is called upon is before the date of the object that received as parameter.

* after method: Checks if the date of the object that the methood is called upon is after the date of the object that received as parameter. *The after methood nust use only the before methood!* It can not use the equal methood nor compute an answer using variable values.

* difference method: Gets a Date object as parameter and compute the number of days between the date of the object that the methood is called upon, and the date of the object that it received as parameter. The result value must be Non-   negative.

* toString method: Returns a formatted date string- day/month/year <-> dd/mm/yyyy.

* tomorrow method: Returns the following day of the date of the object that the methood is called upon. The returned date is a new date- the object that the methood is called upon remains unchanged!

* dayInWeek method: Returns which day of the week the date of the object that the methood is called upon represent. Returns an integer in range (0,6). 0- saturday.



# FoodItem Class description:

FoodItem Class is responsible for creating a valid food object.

A FoodItem object comprise from:

1. Name.
2. Catalogue number.
3. Quantity.
4. Production date.
5. Expiry date.
6. Minimum temperature.
7. Maximum temperature.
8. Price.

All said variables are immutable.

FoodItem class will not assume that the parameters given by the user are valid except object from other classes.

* It has two constructors:

   First constructor gets the eight variables that comprise the object. NOTICE: Expiry and Production dates are received as objects!

   If expiry date of a product is before its production date, then its expiry date will be changed to one day after its production date.

     If min temperature > max temperature, then switch between them.

     If fooditem name is empty string, then mark it as "item".

     If cataloge number is not a positive 4 digit number, then mark it as 9999.

     If quantity is negative, then assigne to it the value 0.

     If the price is negative or zero, then assigne it the value 1.


    Second constructor is a copy constructor and it gets a copy of a FoodItem object called 'other'.

* FoodItem class has the regular getters. And setters that check the parameters for their validation. If they are invaild, then the date of the object will remain the same. (Remember the immutability).

* equals method: Gets a FoodItem object 'other' as parameter and returns true if the objects are equal with the exception of their quantity. Return false otherwise.

* isFresh method: Gets a Date object 'd' as a parameter, and returns true if in this date the FoodItem object is fresh (Expiry date <= some FoodItem object <= Production date). Return false otherwise.

* toString method: Returns a formatted food item string (one line)- FoodItem: milk CatalogueNumber: 1234   ProductionDate: 14/12/2019    ExpiryDate: 21/12/2019    Quantity: 3.

* olderFoodItem method: Gets an 'other' FoodItem object as a parameter, and returns true if the object that the methood is called upon had been produced before the object that received as a parameter.

* howManyItems method: Gets an integer value (currency) and returns the number of (same) *available* items that can be Purchased with it.

* isCheaper method: Gets an 'other' FoodItem object as a parameter, and returns true if the object that the methood is called upon is cheaper then the object that received as a parameter. Return false otherwise.

  

# Stock Class description:

Stock Class is responsible for manageing and displaying the items (objects).

An object is counted only ones, even if it has more then one item.

The objects in stock are orderd sequentially without 'holes' and are sorted in ascending order by their catalogue number.

The stock in which the object are stored *must* remain sorted and in ascending order and without holes after each operation.

Stock Class has a default constructor that create an object in which there is an empty array with maximum size.

* getNumOfItems method: Returns the number of items that in the array.

* addItem method: receive a FoodItem and add it to stock.

    If the item is already in stock, it add the new quantity to the existing quantity.

    If the item is not present, then it will be added into a new slot in stock.

    The method returns true upon successful operation, and false otherwise.

    NOTICE: Every item with the same name and catalogue number that has different expiry\production date will receive a new slot in stock, and its quantity will not be added to an existing item quantity.
  
    In this case, the new item must be inserted before the already existing one.
  
    * If there is an items with the same name and catalogue number, it can be automatically assumed that if there is a difference between them, then it is because the expiry\production dates only.
 
* order method: Returns a string that contains a list of items name that needs to be restocked. An item will enter the list if its quantity is less then parameter *amount* that the method got.

    * The method *does not make the order itself*, only return a list.
      
    * The items that the list returns appear in the same order as they appear in stock.
 
    * If there is same items with different expiry\production dates, then their quantity will be counted as one, so if amount <-3 and there is two same items with ones quantity 2, and the others quantity 2, then non of them
     
       will appear on the order list because their total amount > 3.
      
* howMany method: Gets a temperature and returns the number of items that can be stored in stock (quantities of *same* items in different slots count as total). If there is non, then return zero.

* removeAfterDate method: Gets as parameter a Date object 'd' and removes from stock any item that its expiry date is before date 'd'. Take care of any possible 'holes' that might occure.

* howManyPieces method: Returns the number of items that are in stock, or return zero if there is non.

* toString method: Returns a formatted list of items.

* updateStock method: Gets an array of strings that represent items that had been sold, and updates the stock accordingly.

     * It can be assume that all needed items are in stock and there is enough of them. If after the update the quantity of an item is zero, then remove it from stock and Take care of any possible 'holes' that might occure.
 
     * If there is number of same items in stock, then start removing from the *first* occurrence of it and continue if necessary.
 
* getTempOfStock method: Returns the temperature that the stock needs to be in order to contain all items.
 
    *  If the range exist, the method will return the minimum temperature within range. Else  return Integer.MAX_VALUE.
 




* END OF READ ME.
 
      

  
 

    


            









