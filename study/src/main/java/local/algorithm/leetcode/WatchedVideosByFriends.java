package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 18:56
 */
public class WatchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> friendWatched = new HashMap<>();
        List<Integer> friendList = new ArrayList<>();
        friendList.add(id);
        for (int i = 0; i < level; i++) {
            List<Integer> temp = new ArrayList<>();
            for (Integer f : friendList) {
                int[] fs = friends[f];
                for (int oneFriend : fs) {
                    if (oneFriend != id) {
                        temp.add(oneFriend);
                    }
                }
            }
            friendList = temp;
        }

        for (Integer friend : friendList) {
            List<String> oneWatched = watchedVideos.get(friend);
            for (String w : oneWatched) {
                friendWatched.put(w, friendWatched.getOrDefault(w, 0) + 1);
            }
        }
        return friendWatched.entrySet().stream().sorted((o1, o2) -> {
            int ic = o1.getValue() - o2.getValue();
            if (ic != 0) {
                return ic;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
