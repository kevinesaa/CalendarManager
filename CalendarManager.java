
package javaapplication1;

import java.util.Calendar;

/**
 *
 * @author Kevin Esaa
 */
public class CalendarManager {
    
    
    /** Set the filds hour, minutes, seconds and miliseconds to zero.
     * Also change the time to am.
     * @param calendar objeto to change 
     */
    public static void minHour(Calendar calendar)
    {
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
    }
    
    /** Set the filds hour to 23, minutes to 59, seconds to 59
     * and miliseconds 999.
     * Also change the time to pm.
     * @param calendar objeto to change 
     */
    public static void maxHour(Calendar calendar)
    {
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);
    }
    
    /**
     * @return true if calendar is between min and max, both inclusive.
     */
    public static boolean betweenInclusive(final Calendar min,final Calendar calendar,final Calendar max)
    {
        return calendar.compareTo(min)>=0 && calendar.compareTo(max)<=0;
    }
    
    /**
     * @return true if calendar is between min and max, both exclusive.
     */
    public static boolean betweenExclusive(final Calendar min,final Calendar calendar,final Calendar max)
    {
        return calendar.compareTo(min)>0 && calendar.compareTo(max)<0;
    }
    
    public static boolean isToday(final Calendar calendar)
    {
        return isSameDay(Calendar.getInstance(), calendar);
    }
    
    /**Checks if two calendar objects are on the same day ignoring time.*/
    public static boolean isSameDay(final Calendar cal1, final Calendar cal2) 
    {       
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }
    
    /**@return the birthday number*/
    public static int calculateAgeInYears(final Calendar birthday)
    {
        return calculateAgeInYears(birthday,Calendar.getInstance());
    }
    
    /**@return the birthday number*/
    public static int calculateAgeInYears(final Calendar birthday,final Calendar presentDay)
    {
        if(birthday.after(presentDay))
            throw new IllegalArgumentException("Present day must be higher than the birthday.");
        
        int years = presentDay.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        
        if( years>0 && presentDay.get(Calendar.DAY_OF_YEAR) < birthday.get(Calendar.DAY_OF_YEAR))
            years--;
        
        return years;
    }
    
}
