package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1559_BFS {
	static int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static int m;
	static int n;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
				{ 'f', 'c', 'c', 'c' } };
		System.out.println(containsCycle(grid));
	}

	public static boolean containsCycle(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					if (solve(grid, i, j, -1, -1))
						return true;
				}
			}
		}

		return false;
	}

	private static boolean solve(char[][] grid, int i, int j, int prt_X, int prt_y) {
		Queue<int[]> pq = new LinkedList<>();
		pq.add(new int[] { i, j, -1, -1 });
		visited[i][j] = true;

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int curr_x = tmp[0];
			int curr_y = tmp[1];

			for (int[] direc : directions) {
				int nx = curr_x + direc[0];
				int ny = curr_y + direc[1];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;

				if (grid[nx][ny] != grid[i][j])
					continue;

				if (nx == tmp[2] && ny == tmp[3])
					continue;

				if (visited[nx][ny])
					return true;

				pq.add(new int[] { nx, ny, curr_x, curr_y });
				visited[nx][ny] = true;
			}

		}

		return false;
	}

}
