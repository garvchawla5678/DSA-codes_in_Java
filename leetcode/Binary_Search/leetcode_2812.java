package leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2812 {

	static final int[][] direc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	// this solution works but has high time complexity O (BinarySearch * dfs *
	// O(length of theif))
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
		List<int[]> theif = new ArrayList<>();

		int j = 0;
		for (List<Integer> tmp : grid) {
			for (int i = 0; i < n; i++) {
				grid1[j][i] = tmp.get(i);
				if (grid1[j][i] == 1) {
					theif.add(new int[] { j, i });
				}
			}
			j++;
		}

		return solve(grid1, n, theif);
	}

	private static int solve(int[][] grid, int n, List<int[]> theif) {
		if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
			return 0;

		int l = 0, r = 2 * (n - 1);
		int ans = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (safest(grid, n, mid, theif)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	private static boolean safest(int[][] grid, int n, int mid, List<int[]> theif) {
		return solve1(grid, n, 0, 0, mid, theif, Integer.MAX_VALUE, new boolean[n][n]);
	}

	private static boolean solve1(int[][] grid, int n, int i, int j, int mid, List<int[]> theif, int minSafest,
			boolean[][] visited) {
		if (i == n - 1 && j == n - 1) {
			int cal = calculate(theif, i, j);
			minSafest = Math.min(minSafest, cal);

			return minSafest >= mid;
		}

		minSafest = Math.min(minSafest, calculate(theif, i, j));
		if (minSafest < mid)
			return false;

		visited[i][j] = true;

		for (int[] dir : direc) {
			int new_i = i + dir[0];
			int new_j = j + dir[1];

			if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
				continue;

			if (solve1(grid, n, new_i, new_j, mid, theif, minSafest, visited))
				return true;
		}

		visited[i][j] = false;
		return false;
	}

	private static int calculate(List<int[]> theif, int i, int j) {
		int dist = Integer.MAX_VALUE;
		for (int[] row : theif) {
			int x = row[0], y = row[1];

			int distance = (int) (Math.abs(i - x) + Math.abs(j - y));
			dist = Math.min(distance, dist);
		}

		return dist;
	}
}
