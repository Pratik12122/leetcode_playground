package matrix;

public class LargestLocalValuesInaMatrix {
	public static void main(String[] args) {

	}

	public int[][] largestLocal(int[][] grid) {
		int n = grid.length;
		int[][] result = new int[n-2][n-2];
		
		for(int x=0; x < result.length ; x++) {
			for(int y = 0; y< result.length; y++) {
				for(int i=x; i<3;i++) {
					for(int j = y; j< 3; j++) {
						result[x][y] = Math.max(result[x][y], grid[i][j]);
					}
				}
			}
		}
		return result;
	}
}
