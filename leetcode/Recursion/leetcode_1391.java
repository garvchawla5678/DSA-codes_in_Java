package leetcode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1391 {

	int m;
	int n;
	boolean[][] visited;
	Map<Integer, List<int[]>> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 2, 4, 3 }, { 6, 5, 2 } };
		leetcode_1391 cl = new leetcode_1391();
		System.out.println(cl.hasValidPath(grid));
	}

	public boolean hasValidPath(int[][] grid) {
		map = new HashMap<>();

		for (int i = 1; i <= 6; i++) {
			if (!map.containsKey(i))
				map.put(i, new ArrayList<>());

			switch (i) {
			case 1:
				map.get(i).add(new int[] { 0, -1 });
				map.get(i).add(new int[] { 0, 1 });
				break;
			case 2:
				map.get(i).add(new int[] { -1, 0 });
				map.get(i).add(new int[] { 1, 0 });
				break;
			case 3:
				map.get(i).add(new int[] { 0, -1 });
				map.get(i).add(new int[] { 1, 0 });
				break;
			case 4:
				map.get(i).add(new int[] { 0, 1 });
				map.get(i).add(new int[] { 1, 0 });
				break;
			case 5:
				map.get(i).add(new int[] { -1, 0 });
				map.get(i).add(new int[] { 0, -1 });
				break;
			case 6:
				map.get(i).add(new int[] { -1, 0 });
				map.get(i).add(new int[] { 0, 1 });
				break;
			}
		}

		m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];

		return dfs(grid, 0, 0);
	}

	private boolean dfs(int[][] grid, int i, int j) {
		if (i == m - 1 && j == n - 1) {
			return true;
		}
		visited[i][j] = true;

		for (int[] options : map.get(grid[i][j])) {
			int new_x = i + options[0];
			int new_y = j + options[1];

			if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n || visited[new_x][new_y])
				continue;

			// check for backward propagation
			boolean valid = false;
			for (int[] opt : map.get(grid[new_x][new_y])) {
				if (opt[0] + new_x == i && opt[1] + new_y == j) {
					valid = true;
					break;
				}
			}

			if (valid && dfs(grid, new_x, new_y))
				return true;
		}

		return false;
	}
}
