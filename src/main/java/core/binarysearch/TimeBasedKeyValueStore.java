package core.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TimeBasedKeyValueStore {

    // https://leetcode.com/problems/time-based-key-value-store/description/
    static class TimeMap {
        private final Map<String, List<TimeValue>> timeMap;


        public TimeMap() {
            this.timeMap = new HashMap<>();
        }


        public void set(String key, String value, int timestamp) {
            List<TimeValue> timeValues = this.timeMap.computeIfAbsent(key, k -> new ArrayList<>());
            timeValues.add(new TimeValue(value, timestamp));
        }


        public String get(String key, int timestamp) {
            String result = "";
            List<TimeValue> timeValues = this.timeMap.getOrDefault(key, List.of());

            int left = 0;
            int right = timeValues.size() - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                TimeValue current = timeValues.get(mid);

                if (current.timestamp <= timestamp) {
                    result = current.value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }


        record TimeValue(String value, int timestamp) {
        }
    }

}
