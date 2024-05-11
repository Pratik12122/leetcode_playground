package arrays;

import java.util.List;

public class MaxDistance {
	public static void main(String[] args) {
		var arrays = List.of(List.of(1,4), List.of(0, 5));
		
		System.out.println(maxDistance1(arrays));
	}
	
	
	// Brute Force 
	public static int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;

        for(int i=0; i< arrays.size(); i++) {
         for(int j=1; j< arrays.size(); j++) {
            List<Integer> iArray = arrays.get(i);
            List<Integer> jArray = arrays.get(j);

            int iMin = iArray.get(0);
            int iMax = iArray.get(iArray.size()-1);

            int jMin = jArray.get(0);
            int jMax = jArray.get(jArray.size()-1);
           
            maxDistance = Math.max(maxDistance, Math.abs(jMax-iMin));
            maxDistance = Math.max(maxDistance, Math.abs(iMax-jMin));
         }   
        }

        return maxDistance;
    }
	
	
	public static int maxDistance1(List<List<Integer>> arrays) {
		int res = 0;
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrays.get(0).size() -1);
		int n = arrays.get(0).size();
		
		
		for(int j=1; j< arrays.size(); j++) {
			n = arrays.get(j).size();
			int cal_1 = Math.abs(arrays.get(j).get(n-1) - min);
			int cal_2 = Math.abs(max - arrays.get(j).get(0));
			
			res = Math.max(res, Math.max(cal_1, cal_2));
			
			min = Math.min(min, arrays.get(j).get(0));
			max = Math.max(max, arrays.get(j).get(n-1));
			
		}
		
		
		return res;
	}
}
