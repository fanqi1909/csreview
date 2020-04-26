package contest.c173;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Q1 {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ISO_DATE);
        LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ISO_DATE);
        int diff = (int) d1.until(d2, ChronoUnit.DAYS);
        return Math.abs(diff);
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.daysBetweenDates("1971-06-29", "2010-09-23"));
        System.out.println(q1.daysBetweenDates("2010-09-23", "1971-06-29"));
    }
}
