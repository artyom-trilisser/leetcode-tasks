package io.leetcode.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private final Map<String, List<TimedValue>> storage;

    public TimeMap() {
        this.storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimedValue> values = storage.getOrDefault(key, new ArrayList<TimedValue>());

        values.add(new TimedValue(timestamp, value));
        storage.put(key, values);
    }

    public String get(String key, int timestamp) {
        List<TimedValue> values = storage.get(key);

        if(values == null) return "";

        int left = 0;
        int right = values.size() - 1;
        String res = "";

        while(left <= right) {
            int middle = (left + right)/2;

            if( values.get(middle).timeStamp <= timestamp) {
                res = values.get(middle).value;
                left = middle + 1;
            } else if(timestamp < values.get(middle).timeStamp) {
                right = middle - 1;
            }
        }
        return res;
    }

    static class TimedValue {
        int timeStamp;
        String value;

        public TimedValue(int timeStamp, String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

}
