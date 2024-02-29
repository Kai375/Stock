package date;

/**
 * Date Class will calculate and form valid date objects, using various of methods in the process.
 *
 * @author Kai Toledano.
 */
public class Date // Start of Class Date.
{
  // declaration.
  
  private int day, month, year;
  
  private final int JAN_FIRST = 1, MAX_FEB = 28, LEAP_FEB = 29;
  
  private final int MAX_DAYS_MONTHS1 = 31, MIN_DAYS_MONTHS = 1, MAX_DAYS_MONTHS2 = 30;
  
  private final int MAX_MONTH = 12, MIN_MONTH = 1;
  
  private final int MAX_YEAR = 9999, MIN_YEAR = 1000, MID_YEAR = 2000;
  
  private final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6, JUL = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;

   /**
  * Constructor.
  */
  public Date(int day, int month, int year) //Start of constructor.
  {
      if((day >= MIN_DAYS_MONTHS && day <= MAX_DAYS_MONTHS1) && (month >= MIN_MONTH && month <= MAX_MONTH) && (year >= MIN_YEAR && year <= MAX_YEAR)) // First, a check for valid input
      {
          if(month == JAN || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC) // Check for months with MAX_DAYS_MONTHS1.
          {
              this.day = day;
              this.month = month;
              this.year = year;
          }
          
          else if(month == APR || month == JUN || month == SEP || month == NOV) // Check for months with MAX_DAYS_MONTHS2.
          {
              if(day <= MAX_DAYS_MONTHS2) // If a month has MAX_DAYS_MONTHS2, it will be printed.
              {   
                  this.day = day;
                  this.month = month;
                  this.year = year;
              }
              else // Default Date object.
              {
                  this.day = JAN_FIRST;
                  this.month = JAN;
                  this.year = MID_YEAR;
              }
          }
          
          else
          {
              if(day <= MAX_FEB)
              { 
                  this.day = day;
                  this.month = month;
                  this.year = year;
              }
              else if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) // Check if the year is a leap year.
              {
                  if(day <= LEAP_FEB) // Checks if the day is equal or smaller than LEAP_FEB.
                  {
                      this.day = day;
                      this.month = month;
                      this.year = year;
                  }
                  else // Default Date object.
                  {
                      this.day = JAN_FIRST;
                      this.month = JAN;
                      this.year = MID_YEAR;
                  }
              }
              else // Default Date object.
              {
                   this.day = JAN_FIRST;
                   this.month = JAN;
                   this.year = MID_YEAR;
              }
          }
      }
      else // Default Date object.
      {
         this.day = JAN_FIRST;
         this.month = JAN;
         this.year = MID_YEAR;
      }
        
  } //End of constructor.
  
  /**
  *  Copy constructor.
  */
  public Date(Date other) //Start of copy constructor.
  {
     day = other.day;
     month = other.month;
     year = other.year;

  } //End of copy constructor.
  
  /**
  *  setDay will alter the day to the wanted one, if the condition are valid.
  */
  public void setDay(int dayToSet) // Start of setDay method().
  {
    if(dayToSet >= MIN_DAYS_MONTHS && dayToSet <= MAX_DAYS_MONTHS1) // Checks if the inputted day is valid at all.
    {
        if(month != FEB && month != APR && month != JUN && month != SEP && month != NOV) // if the month holds MAX_DAYS_MONTHS1, it will be printed here.
        {
             day = dayToSet;
        }
        
        if((dayToSet <= MAX_DAYS_MONTHS2) && month != FEB) // If a month holds MAX_DAYS_MONTHS2, it will be printed here.
        {  
            day = dayToSet;
        }
        
        if(month == FEB) // if the month has MAX_FEB, if so it will be printed here.
        {
            if((year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) && (dayToSet <= LEAP_FEB)) // If the said month is also happening in a leap year, it will be printed here.
            {
               day = dayToSet;
            }
            else if((dayToSet <= MAX_FEB)) // If the said month is not happening in a leap year, it will be printed here. 
            {
                day = dayToSet;
            }
        }
    }
  } // End of setDay method().
  
  /**
  *  setMonth will alter the month to the wanted one, if the condition are valid.
  */
  public void setMonth(int monthToSet) // Start of setMonth method().
  {
    if(monthToSet >= MIN_MONTH && monthToSet <= MAX_MONTH)
    {
         month = monthToSet;
    } 
  } // End of setMonth method().
  
  /**
  *  setYear will alter the year to the wanted one, if the condition are valid.
  */
  public void setYear(int yearToSet) // Checks if the inputted year is valid at all.
  {
    if(yearToSet >= MIN_YEAR && yearToSet <= MAX_YEAR)
    {
         year = yearToSet;
    }
  } 
  
  /**
  *  getDay gets the day.
  *
  * * @return _day
  */
  public int getDay() // gets the day.
  {
      return day;
  }
  
  /**
  *  getMonth gets the month.
  *
  * * @return _month
  */
  public int getMonth() // gets the month.
  {
      return month;
  }
  
  /**
  *  getYear gets the year.
  *
  * * @return _year
  */
  public int getYear() // gets the year.
  {
      return year;
  }
  
  /**
  *  the equal's method checks if two Dates are, well, equals.
  * * @param Date other
  * * @return true if the items are the same
  */
  public boolean equals(Date other) // Checks if two different Date objects are the same or not.
  {
      return day == other.day && month == other.month && year == other.year;
  }
  
  /**
  *  the before method checks if one Date is before another by comparing the days, months and years of them.
  * * @param Date other
  * * @return true if the date before the other one
  */
  public boolean before(Date other) // Checks if another Date object is before another Date object.
  {
    if(year < other.year)
    {
            return true;
    }
    
    else if(year == other.year)
    {
        if(month < other.month)
        {
            return true;
        }
        
        else if(month == other.month)
        {
            return day < other.day;
        }
        
        else
        {
             return false;
        }
    }
    
    else
    {
        return false;
    }
  }
  
  /**
  *  the before method checks if one Date is before another by comparing the days, months and years of them.
  * * @param Date other
  * * @return true if the date before the other one
  */
  public boolean after(Date other) // Checks if another Date object is after another Date object, using the before method.
  {
      return other.before(this);
  }
  
  /**
  *  the difference method gets the sum of days that have passed between two dates from the calculateDate method and returns the sum in absolute value.
  * * @param Date other
  * * @return the difference
  */
  public int difference(Date other) // Shows how many days have passed between to Dates.
  {
     int difference;

     difference = Math.abs(calculateDate(day, month, year) - calculateDate(other.day, other.month, other.year));
     
     return difference;
  }
  
  /**
  *  the calculateDate method calculates how many days have passed between two dates and returns the sum to the difference method.
  * * @param int day, int month, int year
  * * @return the sum
  */
  private int calculateDate(int day, int month, int year) // Calculate how many days have passed between to Dates.
  {
      if(month < 3)
      {
          year--;
          month = month + 12;
      }
      
      return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) *306) / 10 + (day - 62);
  }
  
  /**
  *  the dayInWeek method calculates the specific the in the week, using values between 0 and 6, 0 for saturday and 1 is for sunday and so forth.
  * 
  * * @return the day
  */
  public int dayInWeek() // Calculates the day in the week that is happening on the Date object.
  {
     int D = day;
     int M;
      
     if(month < MAR)
     {
        year--;
        
        M = month + DEC;
     }
     else
     {
         M = month;
     }
     
     int Y = year % 100;
     int C = year / 100;
     int Day = ((D + ((26*(M + 1)) / 10) + Y + (Y / 4) + (C / 4) - 2 * C) % 7);
    
     Day = Math.floorMod(Day, 7);
        
     return Day;
  }
  
  /**
  *  the tomorrow method calculates the date that occurs right after the given date.
  * 
  * * @return new Date(day, month, year))
  */
  public Date tomorrow() // Calculates the next Date that occurs after the given Date object.
  {

      if(day == MAX_DAYS_MONTHS1) // If the day is already set to MAX_DAYS_MONTHS1, it will be replaced with the first day of the month, and the month will move to the next one.
      {
          day = JAN_FIRST;
          month++;

          if( month == MAX_MONTH) // If the month is already set to MAX_MONTH, it will be replaced with the first month of the year, and the year will move to the next one.
          {
              month = JAN;
                year++;
          }
      }
     
      else if(day == MAX_DAYS_MONTHS2) // If the day is already set to MAX_DAYS_MONTHS2, it will be replaced with the first day of the month, and the month will move to the next one.
      {
          day = JAN_FIRST;
          month++;
      }
      else if(day == MAX_FEB && month == FEB) // If the day is already set to MAX_FEB, it will be replaced with the first day of the month, and the month will move to the next one.
      {
           day = JAN_FIRST;
           month++;
      }
      else if(month == FEB &&day == LEAP_FEB && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) // If the month is FEB, and leap year is happening, the day will reset itself and
                                                                                                              //the month will move to the next one.
      {
            day = JAN_FIRST;
            month++;
      }
      else // For all other options, the day will move by one.
      {
          day++;
      }
      
      return (new Date(day, month, year));
  }
  
   /**
   *   returns a String that represents Date.
   * * @overwrite
   * * @return String that represents this date in the following format:
        day, month, year 
   */
  public String toString() // shows the final data in an orderly fashion.
  {
      if(day < 10 && month >= 10)
      {
         return  "0"+day + "/" + month + "/" + year;
      }
      else if(month < 10 && day >= 10)
      {
         return  day + "/" +"0"+ month + "/" + year;
      }
      else if(day < 10)
      {
         return  "0"+day + "/" +"0"+ month + "/" + year;
      }
      else
      {
         return  day + "/" + month + "/" + year;
      }
  }
} // End of Class Date.
