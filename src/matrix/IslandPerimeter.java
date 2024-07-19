package matrix;

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] nums = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

		System.out.println(new IslandPerimeter().islandPerimeter(nums));
	}

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += markPerimeter(grid, i, j);
				}
			}
		}

		return perimeter;
	}

	private int markPerimeter(int[][] grid, int i, int j) {
		int count = 4;
		if (j != 0 && grid[i][j - 1] != 0)
			count--;
		if (j != grid[i].length - 1 && grid[i][j + 1] != 0)
			count--;

		if (i != 0 && grid[i - 1][j] != 0)
			count--;
		if (i != grid.length - 1 && grid[i + 1][j] != 0)
			count--;

		return count;
	}

}
