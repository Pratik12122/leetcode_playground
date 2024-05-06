package BinarySearch;

public class IsMajorityElement {
	public static void main(String[] args) {
		int[] nums = { 2,4,5,5,5,5,5,6,6 };
		int target = 5;
		int count = binarySearch(nums, target, 0, nums.length - 1, 0);
		boolean isMajority = count > (nums.length/2);
		System.out.println(isMajority);
		
		
		int left = new Solution().lower_bound(nums, target);
		int right = new Solution().upper_bound(nums, target);
		
		
	}

	static int binarySearch(int[] nums, int target, int left, int right, int count) {
		System.out.println("Finding Target b/w " + left + " and " + right + " and Count is " + count);
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				count += 1;
			}
			return count + binarySearch(nums, target, left, mid - 1, 0) + binarySearch(nums, target, mid + 1, right, 0);
		}
		return count;
	}

}


class Solution {
    // Returns the index of the first element equal to or greater than the target.
    // If there is no instance of the target in the list, it returns the length of the list.
    int lower_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;
            
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] >= target) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return index;
    }
    
    // Returns the index of the first element greater than the target.
    // If there is no instance of the target in the list, it returns the length of the list.
    int upper_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] > target) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return index;
    }
    
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = lower_bound(nums, target);
        int nextToLastIndex = upper_bound(nums, target);
        
        return nextToLastIndex - firstIndex > nums.length / 2;
    }
}
