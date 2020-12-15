package local.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 19:44
 */
public class Twitter {

    private static int globalTime = 0;

    class Tweet {
        int id;
        int postTime;

        public Tweet(int id, int postTime) {
            this.id = id;
            this.postTime = postTime;
        }
    }

    private Map<Integer, Set<Integer>> followList;

    private Map<Integer, LinkedList<Tweet>> news;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followList = new HashMap<>();
        news = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!news.containsKey(userId)) {
            news.put(userId, new LinkedList<>());
        }
        LinkedList<Tweet> newsList = news.get(userId);
        newsList.addFirst(new Tweet(tweetId, ++globalTime));
        if (newsList.size() > 10) {
            newsList.removeLast();
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> candidateNews = new ArrayList<>();
        if (news.containsKey(userId)) {
            candidateNews.addAll(news.get(userId));
        }
        if (followList.containsKey(userId)) {
            for (Integer follow : followList.get(userId)) {
                if (follow != userId && news.containsKey(follow)) {
                    candidateNews.addAll(news.get(follow));
                }
            }
        }
        candidateNews.sort((o1, o2) -> o2.postTime - o1.postTime);
        return candidateNews.subList(0, Math.min(10, candidateNews.size())).stream().map(e -> e.id).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followList.containsKey(followerId)) {
            followList.put(followerId, new HashSet<>());
        }
        followList.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId)) {
            followList.get(followerId).remove(followeeId);
        }
    }
}
