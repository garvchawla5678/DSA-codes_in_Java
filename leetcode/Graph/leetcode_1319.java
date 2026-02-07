package leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1319 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		System.out.println(makeConnected(n, connections));
	}

	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;

		List<List<Integer>> map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : connections) {
			map.get(arr[0]).add(arr[1]);
			map.get(arr[1]).add(arr[0]);
		}

		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(map, i, visited);
				count++;
			}
		}

		return count - 1;
	}

	private static void dfs(List<List<Integer>> map, int u, boolean[] visited) {
		visited[u] = true;

		for (int v : map.get(u)) {
			if (!visited[v])
				dfs(map, v, visited);
		}
	}
}
