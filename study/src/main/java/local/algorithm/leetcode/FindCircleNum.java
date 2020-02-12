package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                visited[curr] = true;
                int[] friends = M[curr];
                for (int j = 0; j < friends.length; j++) {
                    if (friends[j] == 1 && !visited[j]) {
                        queue.add(j);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
