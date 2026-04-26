package leetcode.Graph;

public class leetocde_1559_DSU {

	static int[] parent;
	static int[] rank;

	static void union(int x, int y) {
		int parent_x = find(x);
		int parent_y = find(y);

		if (parent_x == parent_y)
			return;

		if (rank[parent_x] > rank[parent_y]) {
			parent[parent_y] = parent_x;
		} else if (rank[parent_x] < rank[parent_y]) {
			parent[parent_x] = parent_y;
		} else {
			parent[parent_x] = parent_y;
			rank[parent_y]++;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
				{ 'f', 'c', 'c', 'c' } };
		System.out.println(containsCycle(grid));
	}

	public static boolean containsCycle(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		parent = new int[m * n];
		rank = new int[m * n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int idx = i * n + j;
				parent[idx] = idx;
				rank[idx] = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			int rIdx = i * n;
			for (int j = 0; j < n; j++) {
				int curr = j + rIdx;
				char ch = grid[i][j];

				if (j + 1 < n && grid[i][j + 1] == ch) {
					if (find(curr) == find(curr + 1))
						return true;

					union(curr, curr + 1);
				}

				if (i + 1 < m && grid[i + 1][j] == ch) {
					if (find(curr) == find(curr + n))
						return true;

					union(curr, curr + n);
				}
			}
		}

		return false;
	}
}
