package leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_2812_optimized {

	static final int[][] direc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };
		List<List<Integer>> grid1 = new ArrayList<>();
		for (int[] row : grid) {
			List<Integer> tmp = new ArrayList<>();
			for (int i : row)
				tmp.add(i);

			grid1.add(tmp);
		}

		for (List<Integer> tmp : grid1)
			System.out.println(tmp);

		System.out.println(maximumSafenessFactor(grid1));
	}

	public static int maximumSafenessFactor(List<List<Integer>> grid) {
		int n = grid.size();
		int[][] grid1 = new int[n][n];
		Queue<int[]> pq = new LinkedList<>();
		int[][] dist = new int[n][n];

		for (int[] row : dist)
			Arrays.fill(row, 1000);
		boolean[][] visited = new boolean[n][n];

		int j = 0;
		for (List<Integer> tmp : grid) {
			for (int i = 0; i < n; i++) {
				grid1[j][i] = tmp.get(i);
				if (grid1[j][i] == 1) {
					pq.add(new int[] { j, i, 0 });
					dist[j][i] = 0;
					visited[j][i] = true;
				}
			}
			j++;
		}

		while (!pq.isEmpty()) {
			int[] point = pq.poll();
			int i = point[0];
			int j1 = point[1];
			int minDist = point[2];

			dist[i][j1] = minDist;

			for (int[] dir : direc) {
				int new_i = i + dir[0];
				int new_j = j1 + dir[1];

				if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
					continue;

				pq.add(new int[] { new_i, new_j, minDist + 1 });
				visited[new_i][new_j] = true;
			}
		}

		for (int[] row : dist)
			System.out.println(Arrays.toString(row));

		return solve(grid1, n, dist);
	}

	private static int solve(int[][] grid, int n, int[][] dist) {
		if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
			return 0;

		int l = 0, r = 2 * (n - 1);
		int ans = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (safest(grid, n, mid, dist)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	private static boolean safest(int[][] grid, int n, int mid, int[][] dist) {
		return solve1(grid, n, 0, 0, mid, dist, Integer.MAX_VALUE, new boolean[n][n]);
	}

	private static boolean solve1(int[][] grid, int n, int i, int j, int mid, int[][] dist, int minSafest,
			boolean[][] visited) {
		if (i == n - 1 && j == n - 1) {
			int cal = dist[i][j];
			minSafest = Math.min(minSafest, cal);

			return minSafest >= mid;
		}

		minSafest = Math.min(minSafest, dist[i][j]);
		if (minSafest < mid)
			return false;

		visited[i][j] = true;

		for (int[] dir : direc) {
			int new_i = i + dir[0];
			int new_j = j + dir[1];

			if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
				continue;

			if (solve1(grid, n, new_i, new_j, mid, dist, minSafest, visited))
				return true;
		}

		return false;
	}
}
