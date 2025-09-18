package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Lesson08_DateTime implements Lesson {
    @Override public String getName() { return "lesson08_datetime"; }
    @Override public String getDescription() { return "LocalDate/Time, Instant/ZonedDateTime, Period/Duration, format/parse"; }

    @Override
    public void run() {
    /*
     * QUICK NOTES
     * - LocalDate/LocalTime/LocalDateTime have no timezone. ZonedDateTime adds ZoneId.
     * - Instant is a moment on the UTC timeline. Convert via atZone()/toInstant().
     * - Period = date-based amount (years/months/days); Duration = time-based amount.
     * - Always format/parse with DateTimeFormatter; pattern is case-sensitive.
     */
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        Period period = Period.between(today, nextWeek);

        LocalTime now = LocalTime.now();
        LocalDateTime meeting = LocalDateTime.of(today, LocalTime.of(14, 30));
        ZonedDateTime meetingUtc = meeting.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC);

        Instant start = Instant.now();
        Instant end = start.plusSeconds(5);
        Duration d = Duration.between(start, end);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // 24h format
        String formatted = meeting.format(fmt);
        LocalDate parsed = LocalDate.parse("2025-01-15");

        System.out.println("today=" + today + " nextWeek=" + nextWeek + " periodDays=" + period.getDays());
        System.out.println("now=" + now + " meetingLocal=" + formatted + " meetingUTC=" + meetingUtc);
        System.out.println("duration(ms)=" + d.toMillis() + " parsed1=" + parsed);
    }

    /*
     * PRACTICE (try before peeking!)
     * 1) Create a ZoneId for "America/New_York" and print the meeting time in that zone.
     * 2) Compute days until the end of the month from today (hint: today.with(TemporalAdjusters.lastDayOfMonth())).
     * 3) Parse "17/09/2025" with pattern "dd/MM/yyyy" and print plus 10 days.
     * 
     * ANSWERS
     * 1) ZonedDateTime ny = meeting.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York"));
     *    System.out.println("meeting NY=" + ny);
     * 2) LocalDate end = today.with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
     *    long days = java.time.temporal.ChronoUnit.DAYS.between(today, end);
     *    System.out.println("days to month-end=" + days);
     * 3) DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     *    LocalDate d2 = LocalDate.parse("17/09/2025", f2);
     *    System.out.println(d2.plusDays(10));
     * 
     * GOTCHAS
     * - Never use old java.util.Date/Calendar in new code unless required.
     * - Don’t assume system default zone; be explicit for cross-timezone logic.
     * - Pattern letters matter: M=month, m=minute; H=24h, h=12h.
     */

    public static void main(String[] args) { new Lesson08_DateTime().run(); }
}
