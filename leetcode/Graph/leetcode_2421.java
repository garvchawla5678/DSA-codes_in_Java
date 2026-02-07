package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class leetcode_2421 {

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = { 1, 3, 2, 1, 3 };
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
		System.out.println(numberOfGoodPaths(vals, edges));
	}

	public static int numberOfGoodPaths(int[] vals, int[][] edges) {
		int n = vals.length;
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] arr : edges) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}

		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(vals[i]))
				map.put(vals[i], new ArrayList<>());
			map.get(vals[i]).add(i);
		}

		int result = n;
		boolean[] isactive = new boolean[n];

		for (int val : map.keySet()) {
			List<Integer> nodes = map.get(val);

			for (int u : nodes) {
				for (int v : adj.get(u)) {
					if (isactive[v])
						union(u, v);
				}
				isactive[u] = true;
			}

			HashMap<Integer, Integer> freq = new HashMap<>();
			for (int u : nodes) {
				int p = find(u);
				freq.put(p, freq.getOrDefault(p, 0) + 1);
			}

			for (int count : freq.values()) {
				int formula = (count * (count - 1)) / 2;
				result += formula;
			}
		}

		return result;
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
