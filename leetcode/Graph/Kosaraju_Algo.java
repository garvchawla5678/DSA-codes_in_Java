package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Kosaraju_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(0).add(3);
		adj.get(1).add(0);
		adj.get(2).add(1);
		adj.get(3).add(4);
		System.out.println(kosaraju(adj));
	}

	public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[n];

		// step 1 -> topological sort
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				topoSort(adj, i, visited, st);
		}

		// step 2 -> reverse graph
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			for (int j : adj.get(i)) {
				map.get(j).add(i);
			}
		}

		// step 3 -> do dfs in topological sort order
		int scc = 0;
		Arrays.fill(visited, false);
		while (!st.isEmpty()) {
			int curr = st.pop();
			if (!visited[curr]) {
				dfs(map, curr, visited);
				scc++;
			}
		}

		return scc;
	}

	private static void dfs(HashMap<Integer, List<Integer>> map, int u, boolean[] visited) {
		visited[u] = true;

		for (int v : map.get(u)) {
			if (!visited[v])
				dfs(map, v, visited);
		}
	}

	private static void topoSort(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> st) {
		visited[u] = true;

		for (int v : adj.get(u)) {
			if (!visited[v])
				topoSort(adj, v, visited, st);
		}
		st.push(u);
	}
}
