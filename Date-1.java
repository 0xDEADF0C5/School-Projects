// Erik Neu
// Class represents the date, using day, month, and year, and can increment the date by one day, as well as test if
// two dates are the same date

public class Date {
  
  // fields initializing day, month, and year, respectively
  private int day = 0;
  private int month = 0;
  private int year = 0;
  
  // constructor for date that inputs day, month, and year, resepectively, as integers
  public Date (int day , int month , int year) {
    super();
    // storing inout day into day field
    this.day = day;
    // storing input month into month field
    this.month = month;
    // storing input year into year field
    this.year = year;
  }
  
  // method returns day of Date
  public int getDay() {
    return this.day;
  }
  
  // method returns month of Date
  public int getMonth() {
    return this.month;
  }
  
  // method returns year of Date
  public int getYear() {
    return this.year;
  }
  
  // method increments Date by one day
  public void incrementDay() {
    if (this.getDay() == 31) {
      this.day = 1;
      if (this.getMonth() == 12) {
        this.month = 1;
        this.year = this.year + 1;
      }
      else {
        this.month = this.month + 1;
      }
    }
    else {
      this.day = this.day + 1;
    }
  }
  
  // override of toString method from Object so that date is printed as day/month/year
  @Override
  public String toString() {
    return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
  }
  
  // override of equals 
  @Override
  public boolean equals(Object o) {
    // typecasting o to store as Date a
    Date a = (Date) o;
    if ((this.getDay() == a.getDay()) && (this.getMonth() == a.getMonth())) {
      return true;
    }
    else {
      return false;
    }
  }
}