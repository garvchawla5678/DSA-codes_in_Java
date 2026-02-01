package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle_BFS {

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
		// graph) then a single bfs call from this func wouldn't be able to check all
		// components.
		for (int i = 0; i < V; i++) {
			if (!visited[i] && isCycleBfs(map, i, visited, -1)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCycleBfs(HashMap<Integer, List<Integer>> map, int u, boolean[] visited, int parent) {
		int[] pair = new int[2];
		pair[0] = u;
		pair[1] = parent;

		Queue<int[]> pq = new LinkedList<>();
		pq.add(pair);
		visited[u] = true;

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();

			for (int v : map.get(temp[0])) {
				if (v == temp[1])
					continue;

				if (visited[v])
					return true;

				pq.add(new int[] { v, temp[0] });
				visited[v] = true;
			}
		}
		return false;
	}
}
