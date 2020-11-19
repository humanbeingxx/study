package local.algorithm;

import java.util.*;

public class FindItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> itineraryMap = new HashMap<>();
        int count = tickets.size();
        for (List<String> ticket : tickets) {
            itineraryMap.putIfAbsent(ticket.get(0), new ArrayList<>());
            itineraryMap.get(ticket.get(0)).add(ticket.get(1));
        }
        for (Map.Entry<String, List<String>> entry : itineraryMap.entrySet()) {
            List<String> value = entry.getValue();
            value.sort(String::compareTo);
        }
        List<String> result = new ArrayList<>();
        rec(itineraryMap, "JFK", count, result);
        return result;
    }

    private boolean rec(Map<String, List<String>> itineraryMap, String begin, int count, List<String> result) {
        result.add(begin);
        List<String> nexts = itineraryMap.get(begin);

        if (nexts == null || nexts.isEmpty()) {
            if (count == 0) {
                return true;
            } else {
                result.remove(result.size() - 1);
                return false;
            }
        }

        List<String> copy = new ArrayList<>(nexts);
        for (String next : copy) {
            nexts.remove(next);
            count--;
            if (rec(itineraryMap, next, count, result)) {
                return true;
            }
            count++;
            nexts.add(next);
        }
        result.remove(result.size() - 1);
        return false;
    }
}
