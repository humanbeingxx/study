package local.algorithm;

import lombok.Data;

import java.util.List;

public class WeightedRoundRobin<T> {

    @Data
    public static class Node<T> {
        private T val;
        private int weight;

        public Node(T val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    private List<Node<T>> nodes;

    private int[] currWeight;

    public WeightedRoundRobin(List<Node<T>> nodes) {
        this.nodes = nodes;
        currWeight = new int[nodes.size()];
    }

    public Node<T> next() {
        int index = -1;
        int totalWeight = 0;
        for (int i = 0; i < nodes.size(); i++) {
            currWeight[i] += nodes.get(i).weight;
            totalWeight += nodes.get(i).weight;
            if (index == -1 || currWeight[index] < currWeight[i]) {
                index = i;
            }
        }
        currWeight[index] -= totalWeight;
        return nodes.get(index);
    }
}
