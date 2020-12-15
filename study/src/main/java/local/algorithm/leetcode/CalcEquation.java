package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> unionSet = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            if (!unionSet.containsKey(equation.get(0))) {
                unionSet.put(equation.get(0), new Pair<>(equation.get(0), 1D));
            }
            if (!unionSet.containsKey(equation.get(1))) {
                unionSet.put(equation.get(1), new Pair<>(equation.get(1), 1D));
            }
            merge(equation, value, unionSet);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Pair<String, Double> root1 = findRoot(query.get(0), unionSet);
            if (root1 == null) {
                result[i] = -1;
                continue;
            }
            Pair<String, Double> root2 = findRoot(query.get(1), unionSet);
            if (root2 == null || !root2.getKey().equals(root1.getKey())) {
                result[i] = -1;
            } else {
                result[i] = root1.getValue() / root2.getValue();
            }
        }
        return result;
    }

    private void merge(List<String> equation, double rate, Map<String, Pair<String, Double>> unionSet) {
        Pair<String, Double> root1 = findRoot(equation.get(0), unionSet);
        Pair<String, Double> root2 = findRoot(equation.get(1), unionSet);
        if (root1.getKey().compareTo(root2.getKey()) < 0) {
            unionSet.put(root2.getKey(), new Pair<>(root1.getKey(), root1.getValue() / (root2.getValue() * rate)));
        } else {
            unionSet.put(root1.getKey(), new Pair<>(root2.getKey(), rate * root2.getValue() / root1.getValue()));
        }
    }

    private Pair<String, Double> findRoot(String num, Map<String, Pair<String, Double>> unionSet) {
        double rate = 1;
        Pair<String, Double> pair = unionSet.get(num);
        if (pair == null) {
            return null;
        }
        while (!pair.getKey().equals(num)) {
            rate *= pair.getValue();
            num = pair.getKey();
            pair = unionSet.get(num);
        }
        return new Pair<>(pair.getKey(), rate);
    }
}
