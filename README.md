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

* equals methood: Gets a Date object as parameter and checks if its date equals the date of the object that the methood is called upon.

* before methood: Checks if the date of the object that the methood is called upon is before the date of the object that received as parameter.

* after methood: Checks if the date of the object that the methood is called upon is after the date of the object that received as parameter. *The after methood nust use only the before methood!* It can not use the equal methood nor compute an answer using variable values.

* difference methood: Gets a Date object as parameter and compute the number of days between the date of the object that the methood is called upon, and the date of the object that it received as parameter. The result value must be Non-negative.

* toString methood: Returns a formatted date string- day/month/year <-> dd/mm/yyyy.

* tomorrow methood: Returns the following day of the date of the object that the methood is called upon. The returned date is a new date- the object that the methood is called upon remains unchanged!

* dayInWeek methood: Returns which day of the week the date of the object that the methood is called upon represent. Returns an integer in range (0,6). 0- saturday.




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

* equals methood: Gets a FoodItem object 'other' as parameter and returns true if the objects are equal with the exception of their quantity. Return false otherwise.

* isFresh methood: Gets a Date object 'd' as a parameter, and returns true if in this date the FoodItem object is fresh (Expiry date <= some FoodItem object <= Production date). Return false otherwise.

* toString methood: Returns a formatted food item string (one line)- FoodItem: milk CatalogueNumber: 1234   ProductionDate: 14/12/2019    ExpiryDate: 21/12/2019    Quantity: 3.

* olderFoodItem methood: Gets an 'other' FoodItem object as a parameter, and returns true if the object that the methood is called upon had been produced before the object that received as a parameter.

* howManyItems methood: Gets an integer value (currency) and returns the number of (same) *available* items that can be Purchased with it.

* isCheaper methood: Gets an 'other' FoodItem object as a parameter, and returns true if the object that the methood is called upon is cheaper then the object that received as a parameter. Return false otherwise.

  




