package two_pointers;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = { 1,3,2 };
		
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void nextPermutation(int[] nums) {

		if (nums.length > 1) {
			boolean isNextPermutationPossible = false;
			int index = nums.length - 2;
			while (index > -1) {
				int lastIndex = nums.length-1;
				
				while(lastIndex > index) {
					if (nums[index] < nums[lastIndex]) {
						int temp = nums[index];
						nums[index] = nums[lastIndex];
						nums[lastIndex] = temp;
						isNextPermutationPossible = true;
						Arrays.sort(nums, index+1, nums.length);
						break;
					}
					lastIndex--;
				}
				
				index--;
			}

			if (!isNextPermutationPossible) {
				Arrays.sort(nums);
			}

		}
	}
}
