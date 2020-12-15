package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    private Map<Integer, Pair<String, Integer>> checkedIn;
    private Map<Pair<String, String>, List<Integer>> finished;

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        finished = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkedIn.get(id);
        Pair<String, String> range = new Pair<>(checkIn.getKey(), stationName);
        finished.putIfAbsent(range, new ArrayList<>());
        finished.get(range).add(t - checkIn.getValue());
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<String, Object> range = new Pair<>(startStation, endStation);
        if (!finished.containsKey(range)) {
            return 0;
        }
        List<Integer> costs = finished.get(range);
        return costs.stream().mapToInt(e -> e).average().getAsDouble();
    }
}
