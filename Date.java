
/**
 * Date Class will calculate and fourm valid date objects, using various of methods in the process.
 *
 * @author Kai Toledano.
 * @version 2020a.
 */
public class Date // Start of Class Date.
{
  // declaration.
  
  private int _day, _month, _year;
  
  private int JAN_FIRST = 1, MAX_FEB = 28, LEAP_FEB = 29;
  
  private int MAX_DAYS_MONTHS1 = 31, MIN_DAYS_MONTHS = 1, MAX_DAYS_MONTHS2 = 30;
  
  private int MAX_MONTH = 12, MIN_MONTH = 1;
  
  private int MAX_YEAR = 9999, MIN_YEAR = 1000, MID_YEAR = 2000;
  
  private int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6, JUL = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;
  
 
  
  private int day, month, year;
      
   /**
  * Constructor.
  *
  * @param int _day, int _month,int _year
  * @return Date object.
  */
  public Date(int _day, int _month,int _year) //Start of constructor.
  {
      if((_day >= MIN_DAYS_MONTHS && _day <= MAX_DAYS_MONTHS1) && (_month >= MIN_MONTH && _month <= MAX_MONTH) && (_year >= MIN_YEAR && _year <= MAX_YEAR))//First of all, a check for valid input
      {
          if(_month == JAN || _month == MAR || _month == MAY || _month == JUL || _month == AUG || _month == OCT || _month == DEC) // Check for months with MAX_DAYS_MONTHS1. 
          {
              this._day = _day;
              this._month = _month;
              this._year = _year;
          }
          
          else if(_month == APR || _month == JUN || _month == SEP || _month == NOV) // Check for months with MAX_DAYS_MONTHS2.
          {
              if(_day <= MAX_DAYS_MONTHS2) // If a month has MAX_DAYS_MONTHS2, it will be printed.
              {   
                  this._day = _day;
                  this._month = _month;
                  this._year = _year;
              }
              else // Default Date object.
              {
                  this._day = JAN_FIRST;
                  this._month = JAN;
                  this._year = MID_YEAR;  
              }
          }
          
          else if(_month == FEB) // Checks for a month with MAX_FEB.
          {
              if(_day <= MAX_FEB)
              { 
                  this._day = _day;
                  this._month = _month;
                  this._year = _year;
              }
              else if(_year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0)) // Check if the year is a leap year.
              {
                  if(_day <= LEAP_FEB) // Checks if the day is equal or smaller then LEAP_FEB.
                  {
                      this._day = _day;
                      this._month = _month;
                      this._year = _year; 
                  }
                  else // Default Date object.
                  {
                      this._day = JAN_FIRST;
                      this._month = JAN;
                      this._year = MID_YEAR;  
                  }
              }
              else // Default Date object.
              {
                   this._day = JAN_FIRST;
                   this._month = JAN;
                   this._year = MID_YEAR;  
              }
          }
      }
      else // Default Date object.
      {
         this._day = JAN_FIRST;
         this._month = JAN;
         this._year = MID_YEAR;  
      }
        
  } //End of constuctor.
  
  /**
  *  Copy constructor.
  *
  * @param Date other.
  * @return  A copy of a Date object.
  */
  public Date(Date other) //Start of copy constructor.
  {
     _day = other._day;
     _month = other._month;
     _year = other._year;
  } //End of copy constructor.
  
  /**
  *  setDay will alter the the day to the wanted one, if the condition are valid.
  *
  * @param int dayToSet.
  * 
  */
  public void setDay(int dayToSet) // Start of setDay method().
  {
    if(dayToSet >= MIN_DAYS_MONTHS && dayToSet <= MAX_DAYS_MONTHS1) // Checks if the inputed day is valid at all.
    {
        if(_month != FEB && _month != APR && _month != JUN && _month != SEP && _month != NOV) // if the month holds MAX_DAYS_MONTHS1, it will be printed here.
        {
             _day = dayToSet; 
        }
        
        if((dayToSet <= MAX_DAYS_MONTHS2) && _month != FEB) // If a month holds MAX_DAYS_MONTHS2, it will be printed here.
        {  
            _day = dayToSet;
        }
        
        if(_month == FEB) // if the month has MAX_FEB, if so it will be printed here.
        {
            if((_year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0)) && (dayToSet <= LEAP_FEB)) // If the said month is also happening in a leap year, it will be printed here.
            {
               _day = dayToSet; 
            }
            else if((dayToSet <= MAX_FEB)) // If the said month is not happening in a leap year, it will be printed here. 
            {
                _day = dayToSet; 
            }
        }
    }
  } // End of setDay method().
  
  /**
  *  setMonth will alter the the month to the wanted one, if the condition are valid.
  *
  * @param int monthToSet.
  * 
  */
  public void setMonth(int monthToSet) // Start of setMonth method().
  {
    if(monthToSet >= MIN_MONTH && monthToSet <= MAX_MONTH)
    {
         _month = monthToSet; 
    } 
  } // End of setMonth method().
  
  /**
  *  setYear will alter the the year to the wanted one, if the condition are valid.
  *
  * @param int yearToSet.
  * 
  */
  public void setYear(int yearToSet) // Checks if the inputed year is valid at all.
  {
    if(yearToSet >= MIN_YEAR && yearToSet <= MAX_YEAR)
    {
         _year = yearToSet;
    }
  } 
  
  /**
  *  getDay gets the day.
  *
  * * @return _day
  */
  public int getDay() // gets the day.
  {
      return _day;
  }
  
  /**
  *  getMonth gets the month.
  *
  * * @return _month
  */
  public int getMonth() // gets the month.
  {
      return _month;
  }
  
  /**
  *  getYear gets the year.
  *
  * * @return _year
  */
  public int getYear() // gets the year.
  {
      return _year;
  }
  
  /**
  *  the equals method checks if two Dates are, well, equals.
  * * @param Date other
  * * @return true if the items are the same
  */
  public boolean equals(Date other) // Checks if two different Date objects are the same or not.
  {
    if(_day == other._day && _month == other._month && _year == other._year)
    
       return true;
     return false;  
  }
  
  /**
  *  the before method checks if one Date is before another by compairing the days, months and years of them.
  * * @param Date other
  * * @return true if the date before the other one
  */
  public boolean before(Date other) // Checks if a other Date object is before another Date object.
  {
    if(_year < other._year)
    {
            return true;
    }
    
    else if(_year == other._year)
    {
        if(_month < other._month)
        {
            return true;
        }
        
        else if(_month == other._month)
        {
            if(_day < other._day)
                return true;
            return false;
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
  *  the before method checks if one Date is before another by compairing the days, months and years of them.
  * * @param Date other
  * * @return true if the date before the other one
  */
  public boolean after(Date other) // Checks if a other Date object is after another Date object, using the before method.
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
     int difference = 0; 
      
     difference = Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
     
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
  *  the dayInWeek method calculates the specific the in the week, using values between 0 to 6, 0 for saturday and 1 is for sunday and so forth.
  * 
  * * @return the the day
  */
  public int dayInWeek() // Calculates the day in the week that is happening on the Date object.
  {
     int D = _day;
     int M;
     int year = _year;
     
      
     if(_month < MAR)
     {
        year--;
        
        M = _month + DEC; 
     }
     else
     {
         M = _month;
     }
     
     int Y = year % 100;
     int C = year / 100;
     int Day = ((D + ((26*(M + 1)) / 10) + Y + (Y / 4) + (C / 4) - 2 * C) % 7);
    
     Day = Math.floorMod(Day, 7);
        
     return Day;
  }
  
  /**
  *  the tomorrow method calculates the date that occures right after the given date.
  * 
  * * @return new Date(day, month, year))
  */
  public Date tomorrow() // Calculates the next Date that occures after the given Date object.
  {
      this.day = _day;
      this.month = _month;
      this.year = _year;
      
      if(_day == MAX_DAYS_MONTHS1) // If the day is already set to MAX_DAYS_MONTHS1, it will be replaced with the first day of the month, and the month will move to the next one.
      {
          day = JAN_FIRST;
          month++;
          year = _year;
          
          if( _month == MAX_MONTH) // If the month is already set to MAX_MONTH, it will be replaced with the first month of the year, and the year will move to the next one.
          {
               day = JAN_FIRST;
               month = JAN;
                year++;
          }
      }
     
      else if(_day == MAX_DAYS_MONTHS2) // If the day is already set to MAX_DAYS_MONTHS2, it will be replaced with the first day of the month, and the month will move to the next one.
      {
          day = JAN_FIRST;
          month++;
          year = _year;
      }
      else if(_day == MAX_FEB && _month == FEB) // If the day is already set to MAX_FEB, it will be replaced with the first day of the month, and the month will move to the next one.
      {
           day = JAN_FIRST;
           month++;
           year = _year; 
      }
      else if(_month == FEB &&_day == LEAP_FEB && (_year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0))) // If the month is FEB, and leap year is happening, the day will reset itself and
                                                                                                              //the month will move to the next one.
      {
            day = JAN_FIRST;
            month++;
            year = _year;  
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
      if(_day < 10 && _month >= 10)
      {
         return  "0"+_day + "/" + _month + "/" + _year; 
      }
      else if(_month < 10 && _day >= 10)
      {
         return  _day + "/" +"0"+ _month + "/" + _year;
      }
      else if(_day < 10 && _month < 10)
      {
         return  "0"+_day + "/" +"0"+ _month + "/" + _year; 
      }
      else
      {
         return  _day + "/" + _month + "/" + _year; 
      }
  }
} // End of Class Date.
