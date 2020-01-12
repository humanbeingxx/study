package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 19:20
 */
public class WatchedVideosByFriendsTest {

    @Test
    public void testWatchedVideosByFriends1() {
        ArrayList<List<String>> watchedVideos = Lists.newArrayList(
                Lists.newArrayList("A", "B"),
                Lists.newArrayList("C"),
                Lists.newArrayList("B", "C"),
                Lists.newArrayList("D"));
        List<String> result = new WatchedVideosByFriends().watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 1);
        assertEquals(result, Lists.newArrayList("B", "C"));
    }

    @Test
    public void testWatchedVideosByFriends2() {
        ArrayList<List<String>> watchedVideos = Lists.newArrayList(
                Lists.newArrayList("A", "B"),
                Lists.newArrayList("C"),
                Lists.newArrayList("B", "C"),
                Lists.newArrayList("D"));
        List<String> result = new WatchedVideosByFriends().watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2);
        assertEquals(result, Lists.newArrayList("D"));
    }

    @Test
    public void testWatchedVideosByFriends3() {
        ArrayList<List<String>> watchedVideos = Lists.newArrayList(
                Lists.newArrayList("bjwtssmu"),
                Lists.newArrayList("aygr", "mqls"),
                Lists.newArrayList("vrtxa", "zxqzeqy", "nbpl", "qnpl"),
                Lists.newArrayList("r", "otazhu", "rsf"),
                Lists.newArrayList("bvcca", "ayyihidz", "ljc", "fiq", "viu"));
        List<String> result = new WatchedVideosByFriends().watchedVideosByFriends(watchedVideos, new int[][]{{3, 2, 1, 4}, {0, 4}, {4, 0}, {0, 4}, {2, 3, 1, 0}}, 3, 1);
        assertEquals(result, Lists.newArrayList("ayyihidz", "bjwtssmu", "bvcca", "fiq", "ljc", "viu"));
    }
}