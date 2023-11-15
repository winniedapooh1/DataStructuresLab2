//File: TestDate.java
//* This file contains enough information for you to complete Assign 2.
//* If you want to learn more about handling dates, see the code in package: assign2_date_demo.

//* YOU DONOT NEED TO CHANGE THIS FILE.
//*   Just use them as a reference for handling date values.

//* This file is for demo how to use the new Java 8 API.
//*   for handling dates related to Assign 2.

package assign2_template;

//* For Assign 2, you only need the 2 classes below if your operating system date and time is in USA format.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Cindy Li
 */
public class TestDate {

    public static void main(String[] args) {
        //1. create LocalDate objects
        
        //Use method: 
        //  static LocalDate 	of(int year, int month, int dayOfMonth)
        //Get a LocalDate object based on the given year, month, and dayOfMonth.
        //Example 1:         
        //For the date in US format: 9/30/2018 (Sep. 30, 2018)
        //   call static method of(int year, int month, int dayOfMonth), where the parameters mean:
        //      year in the local date value
        //      month in the local date value, 1 for January, 2 for February, etc.
        //      dayOfMonth: the day of the month in the local date value.
        LocalDate date1 = LocalDate.of(2021, 8, 13);  //August 13, 2021
        LocalDate date2 = LocalDate.of(2018, 9, 30);  //September 30, 2018

        System.out.println("d1: " + date1);
        System.out.println("d2: " + date2);

        //2. Compare two Date values
        //2.1 use different methods: isBefore(...), isAfter(...), equals(...)
        if (date1.isAfter(date2)) {
            System.out.println("\n" + date1 + " is after " + date2);
        }

        if (date1.equals(date2)) {
            System.out.println(date1 + " is on same date as " + date2);
        }

        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        }

        //2.2 use one method: compareTo(...)
        if (date1.compareTo(date2) > 0) {
            System.out.println(date1 + " is after " + date2);
        } else if (date1.compareTo(date2) == 0) {
            System.out.println(date1 + " is on same date as " + date2);
        } else {
            System.out.println(date1 + " is before " + date2);
        }

        //3. Format local date values      

        //**********You will need these 3 things in Assign 2.************//
        
        //make a date from year, month, day
        LocalDate localDate = LocalDate.of(2009, 9, 10);  //Sep. 10, 2009
        System.out.println(localDate);

        //format a date
        //get a DateTimeFormatter object using the format pattern: like 9/10/2009
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // 9/10/2009
        //use the DateTimeFormatter to format the localDate value in the pattern: "M/d/yyyy".
        System.out.println(dateFormatter.format(localDate));

        //date value comparison
        //make a date from year, month, day         
        LocalDate today = LocalDate.now();             //current date
        LocalDate christmas = LocalDate.of(2021, 12, 24); // 12/24/2021
        System.out.println("today: " + today);
        System.out.println("christimas: " + christmas);
        System.out.println("has christmas passed this year? " + today.isAfter(christmas));

    }
}

/*-----Program Output
d1: 2021-08-13
d2: 2018-09-30

2021-08-13 is after 2018-09-30
2021-08-13 is after 2018-09-30
2009-09-10
9/10/2009
today: 2021-09-03
christimas: 2021-12-24
has christmas passed this year? false
*/
