package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 20:24
 */
public class TwitterTest {

    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        List<Integer> feed = twitter.getNewsFeed(1);
        System.out.println(feed);
    }
}