package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 5;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		dfs(n, edges);
	}

	public static void dfs(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
			map.get(arr[1]).add(arr[0]);
		}
		boolean[] visited = new boolean[n];
		List<Integer> ans = new ArrayList<>();
		dfs_display(map, 0, visited, ans);
		System.out.println(ans);
	}

	private static void dfs_display(HashMap<Integer, List<Integer>> map, int u, boolean[] visited, List<Integer> ans) {
		if (ans.size() == n) {
			return;
		}
		if (visited[u])
			return;

		visited[u] = true;
		ans.add(u);

		for (int neigh : map.get(u)) {
			if (!visited[neigh]) {
				dfs_display(map, neigh, visited, ans);
			}
		}
	}
}
