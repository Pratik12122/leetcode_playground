package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {

	public static void main(String[] args) {

	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int[] meeting : intervals) {
			if (!minHeap.isEmpty() && meeting[0] >= minHeap.peek()) {
				minHeap.poll();
			}

			minHeap.add(meeting[1]);
		}

		return minHeap.size();

	}

}
