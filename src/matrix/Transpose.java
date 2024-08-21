package matrix;

public class Transpose {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6}};
		System.out.println(transpose(matrix));
	}

	public static int[][] transpose(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		
		int[][] res = new int[c][r];
		
		
		for(int i=0; i<matrix.length ; i++) {
			for(int j=c-1; j>=0 ; j--) {
				res[j][i] = matrix[i][j];
			}
		}
		
		
		return res;
	}
}
