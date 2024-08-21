package two_pointers;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 0, 1, 1, 1, 0, 2, 2, 2 };
		new SortColors().sortColors(nums);

		System.out.println(Arrays.toString(nums));
	}

	public void sortColors(int[] nums) {
		int r = 0;
		int b = nums.length - 1;

		int i = 0;

		while (i < nums.length) {
			if (nums[i] == 1) {
				i++;
			} else if (nums[i] == 0) {
				nums[i] = nums[r];
				nums[r] = 0;
				r++;
				i++;
			} else {
				if (b <= i) {
					break;
				} else {
					nums[i] = nums[b];
					nums[b] = 2;
					b--;
				}
			}
		}
	}

}
