package topGoogleQuestions;

import java.util.HashMap;

/**
 * Created by HinTi on 2019/9/24.
 * Goal:
 */

class Logger {

    HashMap<String, Integer> messageMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Logger() {

    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageMap.containsKey(message)) {
            int lastTime = messageMap.get(message);
            if (timestamp - 10 < lastTime)
                return false;
            else {
                messageMap.put(message, timestamp);
                return true;
            }
        }
        messageMap.put(message, timestamp);
        return true;
    }
}

public class Problem359 {
}