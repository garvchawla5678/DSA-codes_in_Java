package leetcode.Graph;

public class leetcode_2316_DSU {

	static int[] rank;
	static int[] parent;
	static int[] size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[][] connections = { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } };
		System.out.println(countPairs(n, connections));
	}

	public static long countPairs(int n, int[][] edges) {
		rank = new int[n];
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
			size[i] = 1;
		}

		for (int[] arr : edges) {
			int a = find(arr[0]);
			int b = find(arr[1]);

			if (a != b) {
				union(a, b);
			}
		}

		long result = 0;
		long remSize = n;
		for (int i = 0; i < n; i++) {
			if (i == parent[i]) {
				result += size[i] * (remSize - size[i]);
				remSize -= size[i];
			}
		}

		return result;
	}

	private static void union(int u, int v) {
		int u_parent = find(u);
		int v_parent = find(v);

		if (u_parent == v_parent)
			return;

		if (rank[u_parent] > rank[v_parent]) {
			parent[v_parent] = u_parent;
			size[u_parent] += size[v_parent];
		} else if (rank[u_parent] < rank[v_parent]) {
			parent[u_parent] = v_parent;
			size[v_parent] += size[u_parent];
		} else {
			parent[u_parent] = v_parent;
			rank[v_parent] += 1;
			size[v_parent] += size[u_parent];
		}
	}

	private static int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}
}
