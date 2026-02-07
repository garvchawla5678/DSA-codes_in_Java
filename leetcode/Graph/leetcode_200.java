package leetcode.Graph;

public class leetcode_200 {

	static int m;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gris = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(gris));
	}

	public static int numIslands(char[][] grid) {
		m = grid.length;
		n = grid[0].length;

		int island = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					island++;
				}
			}
		}

		return island;
	}

	private static void dfs(char[][] grid, int i, int j) {
		grid[i][j] = '$';

		int[] r = { 0, 0, 1, -1 };
		int[] c = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			int row = i + r[k];
			int col = j + c[k];
			if (row < 0 || row >= m || col < 0 || col >= n)
				continue;
			if (grid[row][col] == '1')
				dfs(grid, row, col);
		}
	}
}
