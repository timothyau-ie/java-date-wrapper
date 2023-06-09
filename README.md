# java-date-wrapper
A wrapper for various java dates

## Idea
Java has too many Date classes: java.util.Date, LocalDateTime, java.sql.Timestamp and so on. During actual usage, sometimes we are forced to read a Date value in one class, and output in another. The implementation here is wrapper classes (MyDateTime, MyDate) that allow new / constructor taking in various class / formats and outputs in various class / formats, and allowing date operations in this intermediate class as well.

## Example

```
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
```
