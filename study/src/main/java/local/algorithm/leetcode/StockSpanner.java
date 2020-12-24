package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    private List<Integer> stocks;
    private List<Integer> nexts;

    public StockSpanner() {
        stocks = new ArrayList<>();
        nexts = new ArrayList<>();
    }

    public int next(int price) {
        int next = 1, prevIndex = stocks.size() - 1;
        while (prevIndex >= 0) {
            if (price < stocks.get(prevIndex)) {
                break;
            }
            next += nexts.get(prevIndex);
            prevIndex -= nexts.get(prevIndex);
        }
        nexts.add(next);
        stocks.add(price);
        return next;
    }
}
