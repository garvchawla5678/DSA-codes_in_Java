package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int freshOranges = 0;
		Queue<int[]> pq = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					pq.add(new int[] { i, j });
				}

				if (grid[i][j] == 1)
					freshOranges++;
			}
		}

		if (freshOranges == 0)
			return 0;

		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int minutes = 0;
		while (!pq.isEmpty()) {
			int N = pq.size();

			while (N-- > 0) {
				int[] curr = pq.remove();
				int i = curr[0];
				int j = curr[1];

				for (int k = 0; k < 4; k++) {
					int new_i = i + directions[k][0];
					int new_j = j + directions[k][1];

					if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || grid[new_i][new_j] != 1)
						continue;

					grid[new_i][new_j] = 2;
					pq.add(new int[] { new_i, new_j });
					freshOranges--;
				}
			}
			minutes++;
		}

		if (freshOranges == 0)
			return minutes - 1;

		return -1;
	}
}
