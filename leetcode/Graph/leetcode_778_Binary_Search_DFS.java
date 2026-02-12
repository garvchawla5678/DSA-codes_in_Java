package leetcode.Graph;

public class leetcode_778_Binary_Search_DFS {

	static int m;
	static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };
		System.out.println(swimInWater(grid));
	}

	public static int swimInWater(int[][] grid) {
		m = grid.length;
		int l = 0;
		int r = (int) Math.pow(m, 2) - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;
			boolean[][] visited = new boolean[m][m];
			if (grid[0][0] <= mid && dfs(grid, 0, 0, mid, visited)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return r;
	}

	private static boolean dfs(int[][] grid, int i, int j, int threshold, boolean[][] visited) {
		if (i == m - 1 && j == m - 1) {
			return true;
		}

		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int new_i = i + directions[k][0];
			int new_j = j + directions[k][1];

			if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= m || grid[new_i][new_j] > threshold
					|| visited[new_i][new_j])
				continue;

			if (dfs(grid, new_i, new_j, threshold, visited))
				return true;
		}
		return false;
	}
}
