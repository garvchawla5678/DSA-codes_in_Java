package leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class Detect_Cycle_Using_DSU {

	static int[] rank;
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
		System.out.println(isCyclic(V, edges));
	}

	public static boolean isCyclic(int n, int[][] edges) {
		List<List<Integer>> map = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
			map.get(arr[1]).add(arr[0]);
		}

		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int u = 0; u < n; u++) {
			for (int v : map.get(u)) {
				if (u < v) {
					int u_parent = find(u);
					int v_parent = find(v);

					if (u_parent == v_parent)
						return true;

					union(u, v);
				}
			}
		}

		return false;
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
