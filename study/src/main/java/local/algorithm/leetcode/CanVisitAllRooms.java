package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[][] keys = new boolean[rooms.size()][rooms.size()];
        boolean[][] used = new boolean[rooms.size()][rooms.size()];
        Set<Integer> visited = new HashSet<>(rooms.size());
        for (int i = 0; i < rooms.size(); i++) {
            for (Integer key : rooms.get(i)) {
                keys[i][key] = true;
            }
        }
        return rec(0, keys, used, visited);
    }

    private boolean rec(int currentRoom, boolean[][] keys, boolean[][] used, Set<Integer> visited) {
        visited.add(currentRoom);
        for (int i = 0; i < keys[currentRoom].length; i++) {
            if (keys[currentRoom][i] && !used[currentRoom][i]) {
                used[currentRoom][i] = true;
                if (rec(i, keys, used, visited)) {
                    return true;
                }
            }
        }
        return visited.size() == keys.length;
    }
}
