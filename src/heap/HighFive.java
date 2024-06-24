package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive {

	public static void main(String[] args) {
		int[][] items = { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 },
				{ 1, 100 }, { 2, 100 }, { 2, 76 } };

		int[][] averageScores = highFive(items);

		for (int[] score : averageScores) {
			System.out.println(Arrays.toString(score));
		}
	}

	public static int[][] highFive(int[][] items) {
		var scoreMap = new HashMap<Integer, PriorityQueue<Integer>>();

		for (int[] scoreDetails : items) {
			int id = scoreDetails[0];
			int score = scoreDetails[1];

			scoreMap.computeIfAbsent(id, k -> new PriorityQueue<Integer>()).add(score);

			if (scoreMap.get(id).size() > 5) {
				scoreMap.get(id).poll();
			}
		}

		var resultMap = new HashMap<Integer, Integer>();

		for (var studentId : scoreMap.keySet()) {
			var heap = scoreMap.get(studentId);
			int sum = 0;

			while (!heap.isEmpty()) {
				sum += heap.poll();
			}

			var average = sum / 5;
			resultMap.put(studentId, average);

		}

		int[][] result = new int[resultMap.size()][2];

		int index = 0;

		for (var entry : resultMap.entrySet()) {
			result[index][0] = entry.getKey();
			result[index][1] = entry.getValue();

			index++;
		}

		return result;
	}
}
