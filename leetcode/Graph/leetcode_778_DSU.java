package leetcode.Graph;

public class leetcode_778_DSU {

	class DSU {
		int[] parent;
		int[] rank;

		public DSU(int n) {
			parent = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}

		int find(int u) {
			if (parent[u] == u)
				return u;

			return parent[u] = find(parent[u]);
		}

		void union(int u, int v) {
			int u_parent = find(u);
			int v_parent = find(v);
			if (u_parent == v_parent)
				return;

			if (rank[u_parent] > rank[v_parent])
				parent[v_parent] = u_parent;
			else if (rank[u_parent] < rank[v_parent])
				parent[u_parent] = v_parent;
			else {
				parent[u_parent] = v_parent;
				rank[v_parent]++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };
		leetcode_778_DSU cl = new leetcode_778_DSU();
		System.out.println(cl.swimInWater(grid));
	}

	public int swimInWater(int[][] grid) {
		int n = grid.length;
		DSU dj = new DSU(n * n);
		int[][] weight = new int[n * n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				weight[grid[i][j]] = new int[] { i, j };
			}
		}

		boolean[] active = new boolean[n * n];
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < n * n; i++) {
			int wt = i;
			int ii = weight[i][0];
			int jj = weight[i][1];
			int idx = ii * n + jj;
			active[idx] = true;

			for (int k = 0; k < 4; k++) {
				int new_ii = ii + directions[k][0];
				int new_jj = jj + directions[k][1];

				if (new_ii >= 0 && new_ii < n && new_jj >= 0 && new_jj < n && active[new_ii * n + new_jj]) {
					int new_neigh = new_ii * n + new_jj;
					dj.union(idx, new_neigh);
				}
			}
			if (dj.find(0) == dj.find(n * n - 1)) {
				return wt;
			}
		}

		return -1;
	}
}
