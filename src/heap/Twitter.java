package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


class Node {
	private Integer tweetId;
	private Long timestamp;
	
	public Node(Integer tweetId, Long timestamp) {
		super();
		this.tweetId = tweetId;
		this.timestamp = timestamp;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}

class Twitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(2, 5);
		twitter.follow(1, 2);
		twitter.follow(1, 2);
		//twitter.postTweet(1, 6);
		System.out.println(twitter.getNewsFeed(1));
		//System.out.println(twitter.getNewsFeed(1));
		//twitter.unfollow(1, 5);
		//System.out.println(twitter.getNewsFeed(1));
	}
	
	private long timestamp = 0;
	private Map<Integer, Set<Integer>> userFollowersMap;
	private Map<Integer, LinkedList<Node>> userTweets;

	public Twitter() {
		userFollowersMap = new HashMap<>();
		userTweets = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		userTweets.computeIfPresent(userId, (key, tweetQueue) -> {
			tweetQueue.add(new Node(tweetId, timestamp++));
			return tweetQueue;
		});

		userTweets.computeIfAbsent(userId, key -> {
			var tweets = new LinkedList<Node>();
			tweets.add(new Node(tweetId, timestamp++));
			follow(userId, userId);
			return tweets;
		});
	}

	public List<Integer> getNewsFeed(int userId) {
		var recentTweets = new ArrayList<Integer>();
		if (userFollowersMap.containsKey(userId)) {
			var minHeap = new PriorityQueue<Node>((a, b) -> Long.compare(b.getTimestamp(), a.getTimestamp()));

			for (Integer followerId : userFollowersMap.get(userId)) {
				List<Node> top10TweetsByUser = findTop10TweetsByUser(followerId);
				minHeap.addAll(top10TweetsByUser);
			}

			while (minHeap.size() > 10) {
				minHeap.poll();
			}

			while (!minHeap.isEmpty()) {
				recentTweets.add(minHeap.poll().getTweetId());
			}

		}
		return recentTweets;
	}

	public void follow(int followerId, int followeeId) {
		if (userFollowersMap.containsKey(followerId)) {
			var followers = userFollowersMap.get(followerId);
			followers.add(followeeId);
		} else {
			var followers = new HashSet<Integer>();
			followers.add(followeeId);
			userFollowersMap.put(followerId, followers);
		}
	}

	public void unfollow(int followerId, int followeeId) {
		userFollowersMap.computeIfPresent(followerId, (key, value) -> {
			value.remove(Integer.valueOf(followeeId));
			return value;
		});
	}

	private List<Node> findTop10TweetsByUser(int userId) {
		int count = 0;
		var resultList = new ArrayList<Node>();
		if (userTweets.containsKey(userId)) {
			for (Node tweetNode : userTweets.get(userId)) {
				if (count >= 10) {
					break;
				}
				resultList.add(tweetNode);
				count++;
			}
		}

		return resultList;
	}

}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
