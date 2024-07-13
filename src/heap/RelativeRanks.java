package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks {
	public static void main(String[] args) {
		int[] scores = { 10, 3, 8, 9, 4 };
		System.out.println(findRelativeRanks(scores));
	}

	public static String[] findRelativeRanks(int[] score) {
		String[] ranks = new String[score.length];
		var indexPositionMap = new HashMap<Integer, Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

		for (int i = 0; i < score.length; i++) {
			indexPositionMap.put(score[i], i);
			maxHeap.offer(score[i]);
		}

		int rank = 1;

		while (!maxHeap.isEmpty()) {
			int playerScore = maxHeap.poll();
			String playerRank = rank <= 3 ? getRank(rank) : String.valueOf(rank);
			ranks[indexPositionMap.get(playerScore)] = playerRank;
			rank++;
		}

		return ranks;
	}

	private static String getRank(int rank) {
		if (rank == 1) {
			return "Gold Medal";
		} else if (rank == 2) {
			return "Silver Medal";
		} else {
			return "Bronze Medal";
		}
	}
}
