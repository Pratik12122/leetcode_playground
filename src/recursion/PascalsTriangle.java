package recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		int n = 4;
		var obj = new PascalsTriangle();
		obj.getRow(n).forEach(System.out::println);
	}

	public List<Integer> getRow(int n) {
		var result = new ArrayList<Integer>();

		int[][] matrix = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			int val = find(n, i, n, matrix);
			result.add(val);
		}

		return result;
	}

	private int find(int i, int j, int n, int[][] matrix) {
		System.out.println("finding value for i=" + i + " j=" + j + " n=" + n);
		if (i == 0 || j == n || j==0) {
			return 1;
		}

		if (matrix[i][j] != 0) {
			return matrix[i][j];
		}
		
		int res = find(i - 1, j - 1, n - 1, matrix) +  find(i - 1, j, n - 1, matrix);

		matrix[i][j] = res;
		
		return matrix[i][j];
	}
}
