package local.interview_internal_reference;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstBiggerNode {

    public List<Integer> findFirstBiggerNodes(List<Integer> nodes) {
        List<Integer> result = new ArrayList<>(nodes.size());
        for (Integer ignored : nodes) {
            result.add(null);
        }
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(Pair.of(i, nodes.get(i)));
            } else {
                Integer topValue = stack.peek().getValue();
                if (topValue >= nodes.get(i)) {
                    stack.push(Pair.of(i, nodes.get(i)));
                } else {
                    while (!stack.isEmpty() && stack.peek().getValue() < nodes.get(i)) {
                        Pair<Integer, Integer> pop = stack.pop();
                        result.set(pop.getKey(), nodes.get(i));
                    }
                    stack.push(Pair.of(i, nodes.get(i)));
                }
            }
        }
        return result;
    }
}
