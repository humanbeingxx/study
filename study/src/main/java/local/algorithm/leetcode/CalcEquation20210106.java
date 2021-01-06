package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcEquation20210106 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> union = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            double rate = values[i];
            if (!union.containsKey(first)) {
                union.put(first, new Pair<>(first, 1d));
            }
            if (!union.containsKey(second)) {
                union.put(second, new Pair<>(second, 1d));
            }
            merge(union, first, second, rate);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Pair<String, Double> firstRoot = findRoot(union, query.get(0));
            Pair<String, Double> secondRoot = findRoot(union, query.get(1));
            if (firstRoot != null && secondRoot != null && firstRoot.getKey().equals(secondRoot.getKey())) {
                result[i] = firstRoot.getValue() / secondRoot.getValue();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private void merge(Map<String, Pair<String, Double>> union, String first, String second, double rate) {
        Pair<String, Double> firstRoot = findRoot(union, first);
        Pair<String, Double> secondRoot = findRoot(union, second);
        union.put(secondRoot.getKey(), new Pair<>(firstRoot.getKey(),
                firstRoot.getValue() / (rate * secondRoot.getValue())));
    }

    private Pair<String, Double> findRoot(Map<String, Pair<String, Double>> union, String val) {
        if (!union.containsKey(val)) {
            return null;
        }
        double rate = 1;
        String rootVal = val;
        while (!union.get(rootVal).getKey().equals(rootVal)) {
            rate *= union.get(rootVal).getValue();
            rootVal = union.get(rootVal).getKey();
        }
        union.put(val, new Pair<>(rootVal, rate));
        return union.get(val);
    }
}
