package BinarySearch;

import java.util.Arrays;

public class CapacityToShipPackages {

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;

		System.out.println(shipWithinDays(weights, days));
	}

	public static int shipWithinDays(int[] weights, int days) {
		int low = Arrays.stream(weights).max().getAsInt(); // O(n)
		int high = Arrays.stream(weights).sum(); // O(n)

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (canShipCargo(weights, mid, days)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private static boolean canShipCargo(int[] weights, int capacity, int days) {
		int currentCargoWeight = 0;
		int daysNeeded = 1;

		for (int weight : weights) {
			if (currentCargoWeight + weight > capacity) {
				daysNeeded++;
				currentCargoWeight = 0;
			}
			currentCargoWeight += weight;
		}

		return daysNeeded <= days;
	}
}
