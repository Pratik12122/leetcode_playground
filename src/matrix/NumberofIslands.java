package matrix;

public class NumberofIslands {
	public static void main(String[] args) {
		char[][] chrs = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println(new NumberofIslands().numIslands(chrs));
	}

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == '1') {
					grid[i][j] = 'i';
					mark(grid, i+1, j);
					mark(grid, i, j+1);
				}

		int count = 0;

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == 'i')
					count++;

		return count;
	}

	void mark(char[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
			if (grid[i][j] == '1') {
				grid[i][j] = '0';
				mark(grid, i + 1, j);
				mark(grid, i, j + 1);
				mark(grid, i - 1, j);
				mark(grid, i, j - 1);
			}
		}

	}
}
