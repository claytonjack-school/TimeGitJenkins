package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {

    @Test
    void testGetTotalSecondsGood() {
        int seconds = Time.getTotalSeconds("05:05:05");
        assertTrue(seconds == 18305, "The seconds were not calculated properly");
    }
    
    @Test
    void testGetTotalSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getTotalSeconds("10:00");
        });
    }

    @Test
    void testGetTotalSecondsBoundary() {
        int minSeconds = Time.getTotalSeconds("00:00:00");
        assertTrue(minSeconds == 0, "The total seconds calculation is incorrect for min time.");

        int maxSeconds = Time.getTotalSeconds("23:59:59");
        assertTrue(maxSeconds == 86399, "The total seconds calculation is incorrect for max time.");
    }

    @Test
    void testGetSecondsGood() {
        int seconds = Time.getSeconds("05:05:05");
        assertTrue(seconds == 5, "The seconds is incorrect.");
    }
    
    @Test
    void testGetSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getSeconds("10:00");
        });
    }

    @Test
    void testGetSecondsBoundary() {
        int minSeconds = Time.getSeconds("00:00:00");
        assertTrue(minSeconds == 0, "The seconds is incorrect for min seconds.");

        int maxSeconds = Time.getSeconds("23:59:59");
        assertTrue(maxSeconds == 59, "The seconds is incorrect for max seconds.");
    }

    @Test
    void testGetTotalMinutesGood() {
        int minutes = Time.getTotalMinutes("05:05:05");
        assertTrue(minutes == 5, "The minutes is incorrect.");
    }
    
    @Test
    void testGetTotalMinutesBad() {
        assertThrows(NumberFormatException.class, () -> {
            Time.getTotalMinutes("10:00:00:01");
        });
    }

    @Test
    void testGetTotalMinutesBoundary() {
        int minMinutes = Time.getTotalMinutes("00:00:00");
        assertTrue(minMinutes == 0, "The minutes is incorrect for min minutes.");

        int maxMinutes = Time.getTotalMinutes("23:59:59");
        assertTrue(maxMinutes == 59, "The minutes is incorrect for max minutes.");
    }

    @Test
    void testGetTotalHoursGood() {
        int hours = Time.getTotalHours("05:05:05");
        assertTrue(hours == 5, "The hours is incorrect.");
    }
    
    @Test
    void testGetTotalHoursBad() {
        assertThrows(NumberFormatException.class, () -> {
            Time.getTotalHours("5:5:5");
        });
    }

    @Test
    void testGetTotalHoursBoundary() {
        int minHours = Time.getTotalHours("00:00:00");
        assertTrue(minHours == 0, "The hours is incorrect for min hours.");

        int maxHours = Time.getTotalHours("23:59:59");
        assertTrue(maxHours == 23, "The hours is incorrect for max hours.");
    }
    
    @Test
    void testGetMillisecondsGood() {
        int milliseconds = Time.getMilliseconds("12:05:05:05");
        assertTrue(milliseconds == 5, "The milliseconds is incorrect.");
    }

}
