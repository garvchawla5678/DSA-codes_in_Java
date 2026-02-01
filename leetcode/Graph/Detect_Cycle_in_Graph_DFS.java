package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Detect_Cycle_in_Graph_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 2, 3 } };
		System.out.println(isCyclic(n, edges));
	}

	public static boolean isCyclic(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
		}
		boolean[] visited = new boolean[n];
		boolean[] inRecursion = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i] && isCyclicDfs(map, i, visited, inRecursion)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicDfs(HashMap<Integer, List<Integer>> map, int u, boolean[] visited,
			boolean[] inRecursion) {
		visited[u] = true;
		inRecursion[u] = true;

		for (int v : map.get(u)) {

			if (visited[v] == false && isCyclicDfs(map, v, visited, inRecursion))
				return true;
			else if (inRecursion[v])
				return true;
		}
		inRecursion[u] = false;
		return false;
	}
}
