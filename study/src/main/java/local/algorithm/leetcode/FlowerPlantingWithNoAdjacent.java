package local.algorithm.leetcode;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        boolean[][] graph = makeGraph(n, paths);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int flower = decideFlower(graph[i], answer);
            answer[i] = flower;
        }
        return answer;
    }

    private int decideFlower(boolean[] neighs, int[] answer) {
        boolean f1 = true, f2 = true, f3 = true, f4 = true;
        for (int i = 0; i < neighs.length; i++) {
            if (neighs[i] && answer[i] != 0) {
                if (answer[i] == 1) {
                    f1 = false;
                } else if (answer[i] == 2) {
                    f2 = false;
                } else if (answer[i] == 3) {
                    f3 = false;
                } else {
                    f4 = false;
                }
            }
        }
        if (f1) {
            return 1;
        }
        if (f2) {
            return 2;
        }
        if (f3) {
            return 3;
        }
        return 4;
    }

    private boolean[][] makeGraph(int n, int[][] paths) {
        boolean[][] graph = new boolean[n][n];
        for (int[] path : paths) {
            graph[path[0] - 1][path[1] - 1] = true;
            graph[path[1] - 1][path[0] - 1] = true;
        }
        return graph;
    }
}
