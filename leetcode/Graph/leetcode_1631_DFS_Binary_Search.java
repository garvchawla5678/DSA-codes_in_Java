package leetcode.Graph;

public class leetcode_1631_DFS_Binary_Search {

	static int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	static int m;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
		leetcode_1631 cl = new leetcode_1631();
		System.out.println(cl.minimumEffortPath(heights));
	}

	public int minimumEffortPath(int[][] heights) {
		m = heights.length;
		n = heights[0].length;

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				min = Math.min(min, heights[i][j]);
				max = Math.max(max, heights[i][j]);
			}
		}
		int l = 0;
		int r = max - min;
		while (l < r) {
			int mid = l + (r - l) / 2;
			boolean[][] visited = new boolean[m][n];
			if (dfs(0, 0, mid, visited, heights)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return r;
	}

	private boolean dfs(int i, int j, int threshold, boolean[][] visited, int[][] heights) {
		if (i == m - 1 && j == n - 1)
			return true;

		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int new_x = i + directions[k][0];
			int new_y = j + directions[k][1];

			if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n || visited[new_x][new_y])
				continue;

			int diff = (int) Math.abs(heights[i][j] - heights[new_x][new_y]);
			if (diff <= threshold && dfs(new_x, new_y, threshold, visited, heights)) {
				return true;
			}
		}

		return false;
	}
}
