package leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2812_more_optimized_unioin_find {

	class UnionFind {
		int[] rank;
		int[] parent;

		UnionFind(int n) {
			rank = new int[n];
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}

		public int find(int u) {
			if (u == parent[u])
				return u;
			return parent[u] = find(parent[u]);
		}

		public void union(int u, int v) {
			int u_parent = find(u);
			int v_parent = find(v);

			if (u_parent == v_parent)
				return;

			if (rank[u_parent] > rank[v_parent]) {
				parent[v_parent] = u_parent;
			} else if (rank[u_parent] < rank[v_parent]) {
				parent[u_parent] = v_parent;
			} else {
				parent[u_parent] = v_parent;
				rank[v_parent] += 1;
			}
		}

		public boolean connected(int u, int v) {
			return (find(u) == find(v));
		}
	}

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

		leetcode_2812_more_optimized_unioin_find cl = new leetcode_2812_more_optimized_unioin_find();
		System.out.println(cl.maximumSafenessFactor(grid1));
	}

	public int maximumSafenessFactor(List<List<Integer>> grid) {
		int n = grid.size();
		if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
			return 0;

		int[][] grid1 = new int[n][n];
		List<int[]> pq = new ArrayList<>();
		int front = 0, back = 0;

		boolean[][] visited = new boolean[n][n];

		int j = 0;
		for (List<Integer> tmp : grid) {
			for (int i = 0; i < n; i++) {
				grid1[j][i] = tmp.get(i);
				if (grid1[j][i] == 1) {
					pq.add(new int[] { j, i, 0 });
					back++;
					grid1[j][i] = 0;
					visited[j][i] = true;
				} else {
					grid1[j][i] = -1;
				}
			}
			j++;
		}

		List<int[]>[] bucket = new ArrayList[2 * n];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<>();
		}

		while (front < back) {
			int[] point = pq.get(front++);
			int i = point[0];
			int j1 = point[1];
			int minDist = point[2];

			grid1[i][j1] = minDist;
			bucket[minDist].add(new int[] { i, j1 });

			for (int[] dir : direc) {
				int new_i = i + dir[0];
				int new_j = j1 + dir[1];

				if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
					continue;

				pq.add(new int[] { new_i, new_j, minDist + 1 });
				back++;
				visited[new_i][new_j] = true;
			}
		}

		return solve(grid1, n, bucket);
	}

	private int solve(int[][] grid, int n, List<int[]>[] bucket) {
		boolean[][] active = new boolean[n][n];

		UnionFind cl = new UnionFind(n * n);
		int dd = 2 * (n - 1);

		for (int threshold = dd; threshold >= 0; threshold--) {
			for (int[] cell : bucket[threshold]) {

				int r = cell[0];
				int c = cell[1];

				active[r][c] = true;

				for (int[] d : direc) {

					int nr = r + d[0];
					int nc = c + d[1];

					if (nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;

					if (!active[nr][nc])
						continue;

					cl.union(r * n + c, nr * n + nc);
				}
			}

			if (active[0][0] && active[n - 1][n - 1] && cl.connected(0, n * n - 1))
				return threshold;
		}

		return 0;
	}
}
