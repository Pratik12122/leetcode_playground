package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

class Twitter {

	int time = 1;
	Map<Integer, Set<Integer>> followerMap;
	Map<Integer, LinkedList<tweet>> tweetsMap;

	public Twitter() {
		followerMap = new HashMap<>();
		tweetsMap = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		if (tweetsMap.containsKey(userId)) {
			LinkedList<tweet> ll = tweetsMap.get(userId);
			ll.addFirst(new tweet(time++, tweetId));
			tweetsMap.put(userId, ll);
		} else {
			LinkedList<tweet> ll = new LinkedList<tweet>();
			ll.addFirst(new tweet(time++, tweetId));
			tweetsMap.put(userId, ll);
		}
	}

	public List<Integer> getNewsFeed(int userId) {
		// get user tweets
		List<tweet> userTweets = new ArrayList<>();
		if (tweetsMap.containsKey(userId)) {
			userTweets.addAll(tweetsMap.get(userId));
		}

		if (followerMap.containsKey(userId)) {
			for (int follower : followerMap.get(userId)) {
				System.out.println(follower);
				if (tweetsMap.containsKey(follower)) {
					userTweets.addAll(tweetsMap.get(follower));
				}

			}
		}

		PriorityQueue<tweet> minHeap = new PriorityQueue<tweet>((a, b) -> a.time - b.time);

		// build minHeap

		for (tweet t : userTweets) {
			minHeap.add(t);
			if (minHeap.size() > 10) {
				minHeap.poll();
			}
		}

		List<Integer> res = new ArrayList<>();
		
		for(int n=0; n < minHeap.size(); n++) {
			res.add(0);
		}

		int index = minHeap.size() -1;
		
		while (!minHeap.isEmpty()) {
			res.set(index, minHeap.poll().tweetId);
			index--;
		}

		return res;

	}

	public void follow(int followerId, int followeeId) {
		followerMap.computeIfPresent(followerId, (k, v) -> {
			v.add(followeeId);
			return v;
		});

		if (!followerMap.containsKey(followerId)) {
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(followeeId);
			followerMap.put(followerId, set);
		}

	}

	public void unfollow(int followerId, int followeeId) {
		followerMap.computeIfPresent(followerId, (k, v) -> {
			v.remove(followeeId);
			return v;
		});
	}

	public static void main(String[] args) {
		Twitter obj = new Twitter();
		List<int[]> listofArrays = Arrays.asList(new int[] { 1, 5 }, new int[] { 2, 3 }, new int[] { 1, 101 },
				new int[] { 2, 13 }, new int[] { 2, 10 }, new int[] { 1, 2 }, new int[] { 1, 94 }, new int[] { 2, 505 },
				new int[] { 1, 333 }, new int[] { 2, 22 }, new int[] { 1, 11 }, new int[] { 1, 205 },
				new int[] { 2, 203 }, new int[] { 1, 201 }, new int[] { 2, 213 }, new int[] { 1, 200 },
				new int[] { 2, 202 }, new int[] { 1, 204 }, new int[] { 2, 208 }, new int[] { 2, 233 },
				new int[] { 1, 222 }, new int[] { 2, 211 }, new int[] { 1 }, new int[] { 1, 2, 3 }, new int[] { 1 },
				new int[] { 1, 2, 3,4 }, new int[] { 1 });

		for (int[] arr : listofArrays) {
			if (arr.length == 2) {
				obj.postTweet(arr[0], arr[1]);
			} else if (arr.length == 3) {
				obj.follow(arr[0], arr[1]);
			} else if (arr.length == 4) {
				obj.unfollow(arr[0], arr[1]);
			} else {
				System.out.println("[");
				String res = obj.getNewsFeed(arr[0]).stream().map(String::valueOf).collect(Collectors.joining(", "));
				System.out.println(res);
				System.out.println("]");
			}
		}

	}

}


class tweet {
    public int tweetId;
    public int time;

    tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

	@Override
	public String toString() {
		return "tweet [tweetId=" + tweetId + ", time=" + time + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(time, tweetId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tweet other = (tweet) obj;
		return time == other.time && tweetId == other.tweetId;
	}
	
	
    
}
/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
