package training.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


// https://leetcode.com/problems/design-twitter/description/
class Twitter {
    private final Map<Integer, HashSet<Integer>> following;
    private final Map<Integer, List<Tuple>> tweets;

    private int timestamp;


    record Tuple(int tweetId, int timestamp) {
    }


    public Twitter() {
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();

        this.timestamp = 0;
    }


    public void postTweet(int userId, int tweetId) {
        timestamp = timestamp + 1;
        this.tweets.computeIfAbsent(userId, key -> new ArrayList<>()).add(new Tuple(tweetId, timestamp));
    }


    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> following = this.following.getOrDefault(userId, new HashSet<>());
        following.add(userId);

        Queue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Tuple::timestamp).reversed());

        for (int followee : following) {
            List<Tuple> tweets = this.tweets.getOrDefault(followee, List.of());
            priorityQueue.addAll(tweets);
        }

        List<Integer> result = new ArrayList<>(priorityQueue.size());
        while (result.size() < 10 && !priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().tweetId);
        }

        return result;
    }


    public void follow(int followerId, int followeeId) {
        this.following.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }


    public void unfollow(int followerId, int followeeId) {
        this.following.computeIfPresent(followerId, (key, values) -> {
            values.remove(followeeId);
            return values;
        });
    }
}
