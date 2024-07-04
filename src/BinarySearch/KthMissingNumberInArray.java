package BinarySearch;

public class KthMissingNumberInArray {
	public static void main(String[] args) {

	}

	public int findKthPositive(int[] arr, int k) {
		int left =0;
		int right = arr.length-1;
		
		while(left < right) {
			
			int mid = left + (right-left)/ 2;
			
			if(arr[mid] - mid - 1 < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return left+k;
	}
}
