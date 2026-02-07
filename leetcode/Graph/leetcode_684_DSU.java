package leetcode.Graph;

import java.util.Arrays;

public class leetcode_684_DSU {

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

	public static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		parent = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int[] arr : edges) {
			int a = find(arr[0]);
			int b = find(arr[1]);

			if (a == b)
				return new int[] { arr[0], arr[1] };

			union(arr[0], arr[1]);
		}

		return new int[] {};
	}

	private static int find(int v) {
		if (v == parent[v])
			return v;
		return parent[v] = find(parent[v]);
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
}
