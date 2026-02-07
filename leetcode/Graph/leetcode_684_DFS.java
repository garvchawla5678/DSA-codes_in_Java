package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_684_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

	public static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int[] arr : edges) {
			int u = arr[0];
			int v = arr[1];
			boolean[] visited = new boolean[n + 1];

			if (map.containsKey(u) && map.containsKey(v) && dfs(map, u, v, visited)) {
				return arr;
			}
			if (!map.containsKey(u))
				map.put(u, new ArrayList<>());
			if (!map.containsKey(v))
				map.put(v, new ArrayList<>());

			map.get(u).add(v);
			map.get(v).add(u);
		}

		return new int[] {};
	}

	private static boolean dfs(HashMap<Integer, List<Integer>> map, int u, int v, boolean[] visited) {
		visited[u] = true;

		if (u == v)
			return true;

		for (int adj : map.get(u)) {
			if (visited[adj])
				continue;

			if (dfs(map, adj, v, visited))
				return true;
		}
		return false;
	}
}
