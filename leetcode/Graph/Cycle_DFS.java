package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cycle_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
		System.out.println(isCycle(V, edges));
	}

	public static boolean isCycle(int V, int[][] edges) {
		// Code here
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < V; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
			map.get(arr[1]).add(arr[0]);
		}
		boolean[] visited = new boolean[V];

		// here we have used loop bcz if there are multiple components(disconnected
		// graph) then a single dfs call from this func wouldn't be able to check all
		// components.
		for (int i = 0; i < V; i++) {
			if (!visited[i] && isCycleDfs(map, i, visited, -1)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCycleDfs(HashMap<Integer, List<Integer>> map, int u, boolean[] visited, int parent) {

		visited[u] = true;

		for (int v : map.get(u)) {
			if (v == parent)
				continue;

			if (visited[v])
				return true;

			if (isCycleDfs(map, v, visited, u))
				return true;
		}
		return false;
	}
}
