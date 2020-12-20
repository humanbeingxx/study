package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private final List<String> history;
    private int currentIndex;
    private int maxIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
        maxIndex = 0;
    }

    public void visit(String url) {
        currentIndex++;
        if (history.size() <= currentIndex) {
            history.add(url);
        } else {
            history.set(currentIndex, url);
        }
        maxIndex = currentIndex;
    }

    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(currentIndex + steps, maxIndex);
        return history.get(currentIndex);
    }
}
