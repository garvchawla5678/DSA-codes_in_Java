package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Topological_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
		System.out.println(topologicalsort(n, edges));
	}

	private static ArrayList<Integer> topologicalsort(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
		}

		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfs(map, i, visited, st);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while (!st.isEmpty()) {
			ans.add(st.pop());
		}

		return ans;
	}

	private static void dfs(HashMap<Integer, List<Integer>> map, int u, boolean[] visited, Stack<Integer> st) {
		visited[u] = true;

		for (int v : map.get(u)) {
			if (!visited[v])
				dfs(map, v, visited, st);
		}
		st.push(u);
	}

}
