import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class MyDateTime {

    public final static String FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public final static String FORMAT_DISPLAY01 = "dd-MMM-yy EEEE h:mma";
    public final static String FORMAT_DISPLAY02 = "dd-MMM-yy h:mm a";
    public final static String FORMAT_DISPLAY03 = "yyyy-MM-dd HH:mm:ss";

    private LocalDateTime localDateTime = null;

    public MyDateTime() {

    }

    public MyDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public MyDateTime(String dateTimeStr, String format) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            localDateTime = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            localDateTime = LocalDateTime.parse(dateTimeStr, formatter);
        }
    }

    public MyDateTime(java.util.Date date) {
        if (date != null) {
            this.localDateTime = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }
    }

    public boolean hasValue() {
        return localDateTime != null;
    }

    public static MyDateTime now() {
        return new MyDateTime(LocalDateTime.now());
    }

    public String toString() {
        return localDateTime != null ? localDateTime.toString() : "";
    }

    /**
     * To String
     * @param format
     * @return Date Time in String format
     */
    public String toString(String format) {
        if (localDateTime == null) {
            return "";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withLocale(Locale.ENGLISH);
            return localDateTime.format(formatter);
        }
    }

    /**
     * To java.time.LocalDateTime
     * @return Date Time in java.time.LocalDateTime format
     */
    public java.time.LocalDateTime toLocalDateTime() {
        return localDateTime;
    }

    /**
     * To java.sql.Timestamp (for MySQL R/W)
     * @return Date Time in java.time.LocalDateTime format
     */
    public java.sql.Timestamp toSqlTimestamp() {
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * To java.util.Date (for MongoDB R/W)
     * @return Date Time in java.util.Date format
     */
    public java.util.Date toUtilDate() {
        return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * To MyDate
     * @return Date in MyDate format
     */
    public MyDate toMyDate() {
        return new MyDate(localDateTime);
    }

    public MyDateTime plusMonths(long months) {
        return new MyDateTime(localDateTime.plusMonths(months));
    }

    public MyDateTime plusHours(long hours) {
        return new MyDateTime(localDateTime.plusHours(hours));
    }

    public Duration minus(MyDateTime myDateTime) {
        Duration duration = Duration.between(myDateTime.toLocalDateTime(), localDateTime);
        return duration;
    }

    public int compareTo(MyDateTime anotherDateTime) {
        return this.localDateTime.compareTo(anotherDateTime.localDateTime);
    }

    public boolean isAfter(MyDateTime wbDateTime) {
        return localDateTime.isAfter(wbDateTime.toLocalDateTime());
    }

    public boolean isBefore(MyDateTime wbDateTime) {
        return localDateTime.isBefore(wbDateTime.toLocalDateTime());
    }

    public boolean isEqual(MyDateTime wbDateTime) {
        return localDateTime.isEqual(wbDateTime.toLocalDateTime());
    }
}