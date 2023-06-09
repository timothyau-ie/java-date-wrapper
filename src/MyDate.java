
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDate {

    public final static String FORMAT_DISPLAY01 = "dd-MMM-yy";
    public final static String FORMAT_DISPLAY02 = "yyyy/MM/dd";
    public final static String FORMAT_DISPLAY03 = "yyyyMMdd";

    private LocalDate localDate = null;

    public MyDate() {

    }

    public MyDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public MyDate(String dateStr, String format) {
        if (dateStr == null || dateStr.isEmpty()) {
            localDate = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            localDate = LocalDate.parse(dateStr, formatter);
        }
    }

    public MyDate(LocalDateTime localDateTime) {
        this.localDate = localDateTime.toLocalDate();
    }

    public MyDate(java.util.Date date) {
        if (date != null) {
            this.localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
    }

    public boolean hasValue() {
        return localDate != null;
    }

    /**
     * To String
     * @param format
     * @return Date in String format
     */
    public String toString(String format) {
        if (localDate == null) {
            return "";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withLocale(Locale.ENGLISH);
            return localDate.format(formatter);
        }
    }

    public String toString() {
        return localDate != null ? localDate.toString() : "";
    }

    /**
     * To java.time.LocalDate
     * @return Date in java.time.LocalDate format
     */
    public LocalDate toLocalDate() {
        return localDate;
    }

    /**
     * To MyDateTime (at start of day)
     * @return Date in MyDateTime format
     */
    public MyDateTime toMyDateTime() {
        return new MyDateTime(localDate.atStartOfDay());
    }

    public MyDate plusDays(long days) {
        return new MyDate(localDate.plusDays(days));
    }

    public long minus(MyDate myDate) {
        Duration duration = Duration.between(myDate.toLocalDate().atStartOfDay(), localDate.atStartOfDay());
        return duration.toDays();
    }

    public boolean isAfter(MyDate myDate) {
        return localDate.isAfter(myDate.toLocalDate());
    }

    public boolean isBefore(MyDate myDate) {
        return localDate.isBefore(myDate.toLocalDate());
    }

    public boolean isEqual(MyDate myDate) {
        return localDate.isEqual(myDate.toLocalDate());
    }

    public int getYear() {
        return localDate.getYear();
    }


    public java.time.Month getMonth() {
        return localDate.getMonth();
    }

    public int getDayOfMonth() {
        return localDate.getDayOfMonth();
    }

    public java.time.DayOfWeek getDayOfWeek() {
        return localDate.getDayOfWeek();
    }

    public int compareTo(MyDate anotherDate) {
        return this.localDate.compareTo(anotherDate.localDate);
    }
}
