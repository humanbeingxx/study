package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

public class MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        List<Pair<Integer, Integer>> pdPairs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            pdPairs.add(new Pair<>(profit[i], difficulty[i]));
        }
        pdPairs.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        removeLowEffective(pdPairs);
        int pdIndex = 0, workerIndex = worker.length - 1, maxProfit = 0;
        while (pdIndex < pdPairs.size() && workerIndex >= 0) {
            if (pdPairs.get(pdIndex).getValue() <= worker[workerIndex]) {
                maxProfit += pdPairs.get(pdIndex).getKey();
                workerIndex--;
            } else {
                pdIndex++;
            }
        }
        return maxProfit;
    }

    private void removeLowEffective(List<Pair<Integer, Integer>> pdPairs) {
        Iterator<Pair<Integer, Integer>> iterator = pdPairs.iterator();
        Pair<Integer, Integer> pre = null;
        while (iterator.hasNext()) {
            Pair<Integer, Integer> pair = iterator.next();
            if (pre == null) {
                pre = pair;
            } else {
                if (pre.getValue() <= pair.getValue()) {
                    iterator.remove();
                }
            }
        }
    }
}
