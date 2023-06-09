import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        // ************** MyDateTime **************

        System.out.println("************** MyDateTime Demo **************");

        // Get now
        MyDateTime now = MyDateTime.now();
        System.out.println("Now: " + now);

        // Convert from LocalDateTime to java.util.Date
        LocalDateTime localDateTime = LocalDateTime.of(2000, 1, 1, 13, 35);
        MyDateTime fromLocalDateTime = new MyDateTime(localDateTime);
        java.util.Date toUtilDate = fromLocalDateTime.toUtilDate();
        System.out.println("From LocalDateTime to java.util.Date: " + toUtilDate);

        // Convert from java.util.Date to java.sql.Timestamp
        java.util.Date utilDate = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        MyDateTime fromUtilDate = new MyDateTime(utilDate);
        java.sql.Timestamp toSqlTimestamp = fromUtilDate.toSqlTimestamp();
        System.out.println("From java.util.Date to java.sql.Timestamp: " + toUtilDate);

        // Convert from Custom String format
        MyDateTime fromCustomString = new MyDateTime("2000-01-01 13:35:00", MyDateTime.FORMAT_DISPLAY03);
        System.out.println("From custom String format: " + fromCustomString);

        // Selected date operations (can add more if needed)
        MyDateTime now1 = MyDateTime.now();
        MyDateTime oneHourLater = now1.plusHours(1);
        System.out.println("One hour later: " + oneHourLater);
        java.time.Duration oneHour = oneHourLater.minus(now1);
        System.out.println("Duration of one hour: " + oneHour);

        // Output in various formats
        MyDateTime now2 = MyDateTime.now();
        System.out.println("Output format: " + now2.toString(MyDateTime.FORMAT_DISPLAY01));
        System.out.println("Output format: " + now2.toString(MyDateTime.FORMAT_ISO8601));

        // ************** MyDate **************

        System.out.println("************** MyDate Demo **************");

        // Get today
        MyDateTime now3 = MyDateTime.now();
        MyDate today = now3.toMyDate();
        System.out.println("Today: " + today);

        // Convert from custom String format
        MyDate fromCustomString1 = new MyDate("20000101", MyDate.FORMAT_DISPLAY03);
        System.out.println("From custom String format: " + fromCustomString1);

    }
}