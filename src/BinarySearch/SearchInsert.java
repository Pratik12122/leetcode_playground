package BinarySearch;

public class SearchInsert {

	public static void main(String[] args) {
		int[] nums = {4,3,0,0};
		int target =0;
		
		
		System.out.println(searchInsert(nums, target));
	}
	
	 public static int searchInsert(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length-1;
	        int mid = (left+right)/2; 
	        while(left <= right){
	                mid = (left+right)/2; 
	               // if(nums[mid] == target) return mid;

	                if(nums[mid] < target) right = mid-1 ;
	                else left=mid+1;
	        }

	       return left;


	    }
}
