package ps.google.design;

import com.oracle.tools.packager.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use a hashtable to keep track the last occurance of a message.
 * Proactive cleanning can be done by maintaining another TreeSet to keep track of the messages in the time-stamp order.
 */
public class LoggerRateLimiter {

    Map<String, Integer> lastOccur;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        lastOccur = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lastOccur.containsKey(message)) {
            if (timestamp - lastOccur.get(message) < 10) {
                return false;
            }
        }
        lastOccur.put(message, timestamp); //update time stamp;
        return true;
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar"));

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo"));

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar"));

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo"));

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
