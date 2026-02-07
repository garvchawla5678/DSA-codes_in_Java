package leetcode.Graph;

import java.util.PriorityQueue;

public class leetcode_1631 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
		leetcode_1631 cl = new leetcode_1631();
		System.out.println(cl.minimumEffortPath(heights));
	}

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;

		int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.add(new int[] { 0, 0, 0 });
		result[0][0] = 0;

		while (!pq.isEmpty()) {
			int[] temp = pq.remove();
			int effort = temp[0];
			int x = temp[1];
			int y = temp[2];

			if (x == m - 1 && y == n - 1)
				return result[m - 1][n - 1];

			if (effort > result[x][y])
				continue;

			for (int[] arr : directions) {
				int new_x = x + arr[0];
				int new_y = y + arr[1];

				if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
					continue;

				int diff = (int) Math.abs(heights[x][y] - heights[new_x][new_y]);
				int eff = Math.max(diff, effort);
				if (eff < result[new_x][new_y]) {
					result[new_x][new_y] = eff;
					pq.add(new int[] { eff, new_x, new_y });
				}

			}
		}

		return result[m - 1][n - 1];
	}
}
