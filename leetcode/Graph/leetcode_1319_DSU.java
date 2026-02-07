package leetcode.Graph;

public class leetcode_1319_DSU {

	static int[] rank;
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		System.out.println(makeConnected(n, connections));
	}

	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;

		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		int components = n;
		for (int[] arr : connections) {
			int a = find(arr[0]);
			int b = find(arr[1]);

			if (a != b) {
				union(a, b);
				components--;
			}
		}

		return components - 1;
	}

	private static void union(int u, int v) {
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

	private static int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}
}
