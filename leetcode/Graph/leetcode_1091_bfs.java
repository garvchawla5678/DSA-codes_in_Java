package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1091_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(shortestPathBinaryMatrix(grid));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

		if (m == 0 || n == 0 || grid[0][0] != 0)
			return -1;

		Queue<int[]> pq = new LinkedList<>();
		grid[0][0] = 1; // visited
		pq.add(new int[] { 0, 0 });

		int level = 0;
		while (!pq.isEmpty()) {
			int N = pq.size();

			while (N-- > 0) {
				int[] temp = pq.remove();

				int x = temp[0];
				int y = temp[1];
				if (x == m - 1 && y == n - 1)
					return level + 1;

				for (int[] arr : directions) {
					int new_x = x + arr[0];
					int new_y = y + arr[1];
					if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
						continue;

					if (grid[new_x][new_y] == 0) {
						pq.add(new int[] { new_x, new_y });
						grid[new_x][new_y] = 1;
					}
				}
			}
			level += 1;
		}
		return -1;
	}
}
