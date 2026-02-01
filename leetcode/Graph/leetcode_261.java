package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree(n, edges));
	}

	public static boolean validTree(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
			map.get(arr[1]).add(arr[0]);
		}
		boolean[] visited = new boolean[n];

		if (isCycleDfs(map, 0, visited, -1))
			return false;

		int count = 0;
		for (boolean t : visited) {
			if (t)
				count++;
		}
		return count == n;
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
