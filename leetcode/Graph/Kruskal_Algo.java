package leetcode.Graph;

import java.util.Arrays;

public class Kruskal_Algo {

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
		System.out.println(spanningTree(V, edges));
	}

	public static int spanningTree(int V, int[][] edges) {
		parent = new int[V];
		rank = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		int sum = 0;
		Arrays.sort(edges, (a, b) -> a[2] - b[2]);
		for (int[] arr : edges) {
			int u = arr[0];
			int v = arr[1];
			int weight = arr[2];

			if (find(u) != find(v)) {
				union(u, v);
				sum += weight;
			}
		}

		return sum;
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
