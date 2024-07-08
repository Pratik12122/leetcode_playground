package two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople {
	public static void main(String[] args) {
		int[] people = {	};
		int limit = 3;
		
		System.out.println(numRescueBoats(people, limit));
	}

	public  static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
	}
}
