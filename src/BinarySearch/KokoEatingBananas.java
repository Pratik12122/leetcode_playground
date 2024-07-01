package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = {805306368,805306368,805306368};
		int h = 1000000000;
		
		System.out.println(minEatingSpeed(piles, h));
	}

	public static int minEatingSpeed(int[] piles, int h) {

		Arrays.sort(piles);

		int low = 1;
		int high = piles[piles.length - 1] < h ? h : piles[piles.length - 1];

		int minBanana = high;

		while (low <= high) {
			int mid = (low+high)/2;
			if(tryToEatBanana(piles, mid, h) <= h) {
				high = mid-1;
				minBanana=mid;
			} else {
				low = mid +1;
			}
		}

		return minBanana;
	}

	private static int tryToEatBanana(int[] piles, int mid, int h) {
		int totalHours = 0;
		
		for(int i=piles.length-1; i>=0; i--) {
			if(piles[i] <= mid) {
				totalHours+= 1;
			}else if(piles[i]%mid == 0) {
				totalHours+= piles[i]/mid;
			}else 
				totalHours += 1 + (piles[i]/mid);
			}
			
			if(totalHours > h) {
				return h+1;
			}
		return totalHours;
	}
}
