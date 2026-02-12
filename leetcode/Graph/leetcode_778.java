package leetcode.Graph;

import java.util.HashSet;
import java.util.PriorityQueue;

public class leetcode_778 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };
		System.out.println(swimInWater(grid));
	}

	public static int swimInWater(int[][] grid) {
		int m = grid.length;
		HashSet<String> seen = new HashSet<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		pq.add(new int[] { grid[0][0], 0, 0 });

		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int curr_d = temp[0];
			int i = temp[1];
			int j = temp[2];

			if (i == m - 1 && j == m - 1)
				return curr_d;

			if (seen.contains(i + "," + j))
				continue;
			seen.add(i + "," + j);

			for (int k = 0; k < 4; k++) {
				int new_i = i + directions[k][0];
				int new_j = j + directions[k][1];

				if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= m || seen.contains(new_i + "," + new_j))
					continue;

				int new_d = Math.max(curr_d, grid[new_i][new_j]);
				pq.add(new int[] { new_d, new_i, new_j });

			}
		}
		return -1;
	}
}
