package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//@Link : https://leetcode.com/problems/last-stone-weight/description/
public class LastStoneWeight {

	public static void main(String[] args) {
		int[] nums = {2,7,4,1,8,1};
		
		System.out.println(lastStoneWeight(nums));
	}

	public static int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> maxHeap 
			= new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		for(int n : stones) {
			maxHeap.offer(n);
		}
		
		while(maxHeap.size() > 1) {
			int y = maxHeap.poll();
			int x = maxHeap.poll();
			
			if(x != y) {
				maxHeap.offer(y-x);
			}
		}

		return maxHeap.size() == 1 ? maxHeap.poll() : 0;

	}

}
