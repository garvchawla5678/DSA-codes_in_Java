package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_3286_BFS {

	static final int[] direc = { 0, 1, 0, -1, 0 };
	static final int N = 50000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1, 0 } };
		int health = 3;
		List<List<Integer>> grid1 = new ArrayList<>();
		for (int[] row : grid) {
			List<Integer> tmp = new ArrayList<>();
			for (int i : row)
				tmp.add(i);

			grid1.add(tmp);
		}

		System.out.println(findSafeWalk(grid1, health));
	}

	public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
		int n = grid.size(), m = grid.get(0).size();
		int[][] grid1 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid1[i][j] = grid.get(i).get(j);
			}
		}

		int[] dq = new int[N];
		int front = N >> 1, back = N >> 1;
		int[] maxH = new int[n * m];
		Arrays.fill(maxH, -1);

		dq[back++] = 0;
		maxH[0] = health - grid1[0][0];

		int[] res = new int[n * m];
		// boolean[] visited = new boolean[n * m];
		Arrays.fill(res, 200);
		res[0] = grid1[0][0];

		while (front < back) {
			int idx = dq[front++];
			int curH = maxH[idx];
			int i = idx / m;
			int j = idx % m;

			if (idx == n * m - 1) {
				return curH > 0;
			}

			for (int a = 0; a < 4; a++) {
				int new_i = i + direc[a];
				int new_j = j + direc[a + 1];
				int cal = new_i * m + new_j;

				if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= m)
					continue;

				int H2 = curH - grid1[new_i][new_j];

				if (H2 > maxH[cal]) {
					maxH[cal] = H2;
					if (grid1[new_i][new_j] == 1)
						dq[back++] = cal;
					else
						dq[--front] = cal;
				}
			}

		}

		return false;
	}
}
