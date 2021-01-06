package local.algorithm.leetcode;

import java.util.*;

public class TweetCounts {

    private Map<String, TreeMap<Integer, Integer>> records;

    public TweetCounts() {
        records = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        records.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> record = records.get(tweetName);
        record.put(time, record.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> record = records.get(tweetName);
        if (record == null) {
            return result;
        }
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 60 * 60;
        } else {
            interval = 60 * 60 * 24;
        }
        for (int start = startTime; start <= endTime; start += interval) {
            int end = Math.min(start + interval, endTime);
            Map.Entry<Integer, Integer> startEntry = record.ceilingEntry(start);
            int count = 0;
            while (startEntry != null && startEntry.getKey() < end) {
                count += startEntry.getValue();
                startEntry = record.higherEntry(startEntry.getKey());
            }
            result.add(count);
        }
        return result;
    }
}
